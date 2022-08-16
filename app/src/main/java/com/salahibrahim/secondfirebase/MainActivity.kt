package com.salahibrahim.secondfirebase

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.ibrahim.secondfirebase.R

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var databaseRef: DatabaseReference


    private lateinit var EtEmail: TextInputLayout
    private lateinit var EtPassword: TextInputLayout
    private lateinit var btnLogin: Button
    private lateinit var btnLoginGoogle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//

        supportActionBar!!.title="login"

        EtEmail = findViewById(R.id.Emaild)
        EtPassword = findViewById(R.id.Password)
        btnLogin = findViewById(R.id.Btn_Login)
        btnLoginGoogle = findViewById(R.id.Btn_logGoogle)

        btnLogin.setOnClickListener {loginUser()}
    }

        private fun loginUser() {
            val email = EtEmail.editText!!.text.toString()
            val password = EtPassword.editText!!.text.toString()
            when {
                TextUtils.isEmpty(email) -> Toast.makeText(
                    this,
                    "email is required.",
                    Toast.LENGTH_SHORT
                ).show()

                TextUtils.isEmpty(password) -> Toast.makeText(
                    this,
                    "password is required.",
                    Toast.LENGTH_SHORT
                ).show()

                else -> {
                    val progreessDialog = ProgressDialog(this@MainActivity)
                    progreessDialog.setTitle("Login")
                    progreessDialog.setMessage("Please whit, this may take a while...")
                    progreessDialog.setCanceledOnTouchOutside(false)
                    progreessDialog.show()
                    var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

                    mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                progreessDialog.dismiss()
                                val intent = Intent(this@MainActivity, NextActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                                startActivity(intent)
                                finish()
                            } else {
                                val message = task.exception!!.toString()
                                Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
                                FirebaseAuth.getInstance().signOut()
                                progreessDialog.dismiss()
                            }
                        }
                }
            }
        }
}