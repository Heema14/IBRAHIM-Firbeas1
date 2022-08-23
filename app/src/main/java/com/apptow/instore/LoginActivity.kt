package com.apptow.instore

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {


    private lateinit var btn: Button
    private lateinit var gmail: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var openLoginActivity: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn = findViewById(R.id.login)
        gmail = findViewById(R.id.gmail)
        password = findViewById(R.id.password)
        openLoginActivity = findViewById(R.id.openLoginActivity)


        btn.setOnClickListener {
            Toast.makeText(this, "JAVA", Toast.LENGTH_SHORT).show()
            loginuser();

        }

        openLoginActivity.setOnClickListener {

            startActivity(Intent(this,SingUpActivity::class.java))
            finish()

//            if (!Patterns.EMAIL_ADDRESS.matcher(gmail).matches()){
//
//            }

        }





    }

    private fun loginuser() {
        var email = gmail.editText!!.text.toString().trim()
        var pass = password.editText!!.text.toString().trim()

        when {
            TextUtils.isEmpty(email) -> gmail.error = "JAVA"
            TextUtils.isEmpty(pass) -> password.error = "JAVA"

            else -> {
                val progressDialog = ProgressDialog(this@LoginActivity)
                progressDialog.setTitle("login")
                progressDialog.setMessage("plase whit , this may take a while")
                progressDialog.setCanceledOnTouchOutside(false)
                progressDialog.show()
                var mAuth = FirebaseAuth.getInstance()
                mAuth.signInWithEmailAndPassword(email , pass).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        progressDialog.dismiss()
                        var intent = Intent(this@LoginActivity,SingUpActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                        //
                    } else {
                      val message= task.exception!!.toString()
                      Toast.makeText(this,"JAVA: $message",Toast.LENGTH_SHORT).show()
                        FirebaseAuth.getInstance().signOut()
                        progressDialog.dismiss()
                    }
                }
            }
        }
    }

    override fun onBackPressed() {

        super.onBackPressed()
    }
}