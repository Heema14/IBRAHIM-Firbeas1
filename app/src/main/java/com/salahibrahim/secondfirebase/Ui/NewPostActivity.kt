package com.salahibrahim.secondfirebase.Ui

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.salahibrahim.secondfirebase.R

class NewPostActivity : AppCompatActivity() {

    private lateinit var Post_Ok :ImageView
    private lateinit var Post_Cancel :ImageView
    private lateinit var Post_Image :ImageView
    private lateinit var Post_Write :EditText

    private var myUrl = ""
    private var imageUri: Uri? = null
    private var storagePostPicRef: StorageReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        Post_Ok = findViewById(R.id.Post_ok)
        Post_Cancel = findViewById(R.id.Post_cancel)
        Post_Image = findViewById(R.id.Post_image)
        Post_Write = findViewById(R.id.Post_write)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.statusBarColor = Color.WHITE
        }

        storagePostPicRef = FirebaseStorage.getInstance().reference.child("Posts Pictures")
        Post_Ok.setOnClickListener { uploadImage() }
        CropImage.activity().start(this@NewPostActivity)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val result = CropImage.getActivityResult(data)
            imageUri = result.uri
            Post_Image.setImageURI(imageUri)
        }
    }

    private fun uploadImage() {
        when {

            imageUri == null -> Toast.makeText(this, "Please select image first", Toast.LENGTH_LONG)
                .show()

            TextUtils.isEmpty(Post_Write.text.toString()) -> Toast.makeText(this, "Please write the description first", Toast.LENGTH_LONG).show()
            else -> {
                val progressDialog = ProgressDialog(this)
                progressDialog.setTitle("Adding New Post")
                progressDialog.setMessage("Please wait , we are adding your picture post....")
                progressDialog.show()
                val fileref =
                    storagePostPicRef!!.child(System.currentTimeMillis().toString() + ".jpg")
                val uploadeTask: StorageTask<*>
                uploadeTask = fileref.putFile(imageUri!!)
                uploadeTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let {
                            throw it
                            progressDialog.dismiss()
                        }
                    }

                    return@Continuation fileref.downloadUrl
                }).addOnCompleteListener(OnCompleteListener<Uri> { task ->
                    if (task.isSuccessful) {
                        val downloadUrl = task.result
                        myUrl = downloadUrl.toString()

                        val ref = FirebaseDatabase.getInstance().reference.child("Posts")
                        val postid = ref.push().key

                        val postMap = HashMap<String, Any>()
                        postMap["postid"] = postid!!

                        postMap["description"] = Post_Write.text.toString().toLowerCase()
                        postMap["publisher"] = FirebaseAuth.getInstance().currentUser!!.uid
                        postMap["postimage"] = myUrl

                        ref.child(postid).updateChildren(postMap)
                        Toast.makeText(this, "Post uploaded successfully", Toast.LENGTH_LONG).show()
                        val intent =
                            Intent(this@NewPostActivity, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                        progressDialog.dismiss()

                    } else {
                        progressDialog.dismiss()
                    }
                })
            }
        }
    }
}