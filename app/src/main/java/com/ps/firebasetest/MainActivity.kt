package com.ps.firebasetest

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.DealDirect.App.R
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var layoutUser: TextInputLayout
    private lateinit var layoutPassword: TextInputLayout
    private lateinit var LoginBtn: Button
    private lateinit var googleBtn: Button
    private lateinit var registerTxt: TextView

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutUser = findViewById(R.id.layoutPasswordReg)
        layoutPassword = findViewById(R.id.layoutPassword)
        LoginBtn = findViewById(R.id.LoginBtn)
        googleBtn = findViewById(R.id.googleBtn)
        registerTxt = findViewById(R.id.register)




//        val user: DatabaseReference =
//            FirebaseDatabase.getInstance().reference.child("users")

        LoginBtn.setOnClickListener {
            loginUser()

//            val name = layoutUser.editText!!.text.toString()
//            val pass = layoutPassword.editText!!.text.toString()
//
//            if (passwordChecker(pass.trim())){
//
//                layoutUser.editText!!.setText("")
//                layoutPassword.editText!!.setText("")
//
//
//            } else {
//                layoutPassword.editText!!.setText("")
//                Toast.makeText(this, "password is invalid", Toast.LENGTH_LONG).show()
//            }



        }
        registerTxt.setOnClickListener {
            val intent = Intent(this,registerActivity::class.java)
            startActivity(intent)
        }

//
//            if (passwordChecker(pass.trim())) {
//
////                val userMap = HashMap<String, Any>()
////                userMap[name] = pass
////
////                user.updateChildren(userMap)

//                layoutUser.editText!!.setText("")
//                layoutPassword.editText!!.setText("")
//                Toast.makeText(this, "data added successfully", Toast.LENGTH_SHORT).show()
////
//            } else {
//                layoutPassword.editText!!.setText("")
//                Toast.makeText(this, "password is invalid", Toast.LENGTH_LONG).show()
//
//            }
//        }
    }

//        fun passwordChecker(password: String): Boolean {
//        val passwordREGEX = Pattern.compile(
//            "^" +
//                    "(?=.*[0-9])" +         //at least 1 digit
//                    "(?=.*[a-z])" +         //at least 1 lower case letter
//                    "(?=.*[A-Z])" +         //at least 1 upper case letter
//                    "(?=.*[a-zA-Z])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
//                    "(?=\\S+$)" +           //no white spaces
//                    ".{8,}" +               //at least 8 characters
//                    "$"
//        )
//        return passwordREGEX.matcher(password).matches()
//    }

    // عملنا الدالة برايفت عشان ما يقدر حد يصل للبيانات من واجهة ثانية
    private fun loginUser() {
        val name = layoutUser.editText!!.text.toString()
        val pass = layoutPassword.editText!!.text.toString()

        when {
            //وظيفة textUtils التعامل مع النصوص في الجمل الشرطية في حالة الادخال من المستخدم

            TextUtils.isEmpty(name) -> layoutUser.error = "Email is required"
            TextUtils.isEmpty(pass) -> layoutPassword.error = "Password is required"
            TextUtils.isEmpty(name) && TextUtils.isEmpty(pass) -> Toast.makeText(
                this,
                "you haven't entered anything",
                Toast.LENGTH_SHORT
            ).show()

            else -> {
                val progressDia = ProgressDialog(this)
                progressDia.setTitle("Logging in...")
                progressDia.setMessage("please wait, this may take a while")
                //ايقاف خاصية الخروج من التحميل عند الضغط على الخارج
                progressDia.setCanceledOnTouchOutside(false)
                progressDia.show()
                //تفعيل صلاحية الوصول لبيانات المستخدمين في ال firebase
                val mAuth = FirebaseAuth.getInstance()
                //استخدام خاصية تسجيل الدخول بايميل و كلمة مرور ثم تنفيذ اوامر بعد الانتهاء
                mAuth.signInWithEmailAndPassword(name, pass).addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        //ايقاف ال progress dialog بعد انتهاء التحميل
                        progressDia.dismiss()
                        //نقل على واجهة ال home
                        val intent = Intent(this, HomeActivity::class.java)
                        //ازالة التاسكات السابقة و بدء تاسك جديد
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    } else {
                        val message = task.exception!!.toString()
                        Toast.makeText(this, "Error: $message", Toast.LENGTH_LONG).show()
                        //عند فشل تسجيل الدخول عمل تسجيل خروج عشان ما يقدر يدخل بطرق غير قانونية
                        FirebaseAuth.getInstance().signOut()
                        progressDia.dismiss()
                    }

                }


            }
        }

    }

}