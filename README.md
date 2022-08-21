class RegisterActivity : AppCompatActivity() {
    private lateinit var fullNameTil: TextInputLayout
    private lateinit var userNameTil: TextInputLayout
    private lateinit var emailTil: TextInputLayout
    private lateinit var passwordTil: TextInputLayout
    private lateinit var rePasswordTil: TextInputLayout
    private lateinit var signUp_Btn: Button
    private lateinit var registerProgressDialog: ProgressDialog
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseRef: DatabaseReference
    private var doubleBackToExit = false
    override fun onBackPressed() {
        if (doubleBackToExit) {
            super.onBackPressed()
            return
        }
        doubleBackToExit = true
        Toast.makeText(this, "Press Again To Exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            doubleBackToExit = false

        }, 2000)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullNameTil = findViewById(R.id.register_input_layout_username)
        userNameTil = findViewById(R.id.register_input_layout_fullname)
        emailTil = findViewById(R.id.register_input_layout_Email)
        passwordTil = findViewById(R.id.register_input_layout_Password)
        rePasswordTil = findViewById(R.id.register_input_layout_rePassword)
        signUp_Btn = findViewById(R.id.register_Btn_signup)
        auth = FirebaseAuth.getInstance()
        // ملاحظة 44
        databaseRef = FirebaseDatabase.getInstance().reference.child("users")
        registerProgressDialog = ProgressDialog(this@RegisterActivity)
        signUp_Btn.setOnClickListener {
                registerNewUser()

        }

    }
    private fun validateFullName(): Boolean {
        val fullName = fullNameTil.editText!!.text.toString().trim()
        if (fullName.isEmpty()){
            fullNameTil.error = "Field Can't be Empty"
            return false
        }
        //ملاحظة 59
        fullNameTil.error = null
        return true

    }
    private fun validateUserName(): Boolean {
        val userName = userNameTil.editText!!.text.toString().trim()
        if (userName.isEmpty()){
            userNameTil.error = "Field Can't be Empty"
            return false
        }
        userNameTil.error = null
        return true
        }
    private fun validateEmail(): Boolean {
        val email = emailTil.editText!!.text.toString().trim()
        if (email.isEmpty()){
            emailTil.error = "Field Can't be Empty"
            return false

        }
        // ملاحظة 79
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailTil.error = "Invalid Email"
            return false
        }

        emailTil.error = null
        return true
    }
    private fun validatePassword(): Boolean {
        val password = passwordTil.editText!!.text.toString().trim()
        val confirmPassword = rePasswordTil.editText!!.text.toString().trim()

        if (password.isEmpty()){
            passwordTil.error = "Field Can't be Empty"
            return false
        }

        if (confirmPassword.isEmpty()){
            rePasswordTil.error = "Field Can't be Empty"
            return false
        }

        if (confirmPassword.isEmpty() || password.isEmpty()) return false
        if (password.length<6){
            passwordTil.error = "Password is Too Short (Min. 6 Characters)"
            return false
        }
        if (password!= confirmPassword){
            rePasswordTil.error = "Password Doesn't Match"
            return false
        }

        // ملاحظة 111 & 112
        passwordTil.error = null
        rePasswordTil.error = null
        return true
    }

    private fun registerNewUser() {
        if (!validateFullName() or !validateUserName() or !validateEmail() or !validatePassword())
        return
        var email = emailTil.editText!!.text.toString()
        var password = passwordTil.editText!!.text.toString()
        var fullName = fullNameTil.editText!!.text.toString()
        registerProgressDialog.setTitle("Registering...")
        registerProgressDialog.setMessage("We Are Creating Your Account")
        registerProgressDialog.show()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                val currentUser = auth.currentUser
                val profileUpdate = userProfileChangeRequest { displayName = fullName }

                currentUser!!.updateProfile(profileUpdate).addOnCompleteListener {
                    if (it.isSuccessful){
                     addUserDetailsToDatabase(currentUser)

                    }
                }
            }else {
                showMyDialog("Registration Field", task.exception.toString())

            }

        }

    }

    private fun addUserDetailsToDatabase(currentUser: FirebaseUser) {
        registerProgressDialog.setMessage("Uploading Details to Database")
        var userName = userNameTil.editText!!.text.toString()
        val user = databaseRef.child(currentUser.uid)
        user.child("username").setValue(userName)
        user.child("gender").setValue("none")
        user.child("reg_date").setValue(getRegDate())
        user.child("full_name").setValue(fullNameTil.editText!!.text.toString().trim())
        user.child("email").setValue(emailTil.editText!!.text.toString().trim())
        sendEmailVerification(currentUser)
    }

    private fun sendEmailVerification(user: FirebaseUser) {
        user.sendEmailVerification().addOnCompleteListener {
            if (it.isSuccessful){
                AlertDialog.Builder(this).setTitle("Verify Email Address")
                    .setMessage("Register Successfully ! \n a Verification Link Has been sent to your Email Address")
                    .setPositiveButton("OK", DialogInterface.OnClickListener {  _ , _ ->
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    })

                    .setCancelable(false)
                    .create()
                    .show()

            }
        }
            .addOnFailureListener {t ->
                showMyDialog("Verification Link", t.message.toString())
            }


    }


    private fun showMyDialog(title: String, message : String) {
       AlertDialog.Builder(this)
           .setTitle(title)
           .setMessage(message)
           .setPositiveButton("OK", DialogInterface.OnClickListener{dialogInterface, _ ->
               dialogInterface.dismiss()

           })
           .setCancelable(false)
           .create()
           .show()
        registerProgressDialog.dismiss()

    }

    private fun getRegDate(): String {
        val c = Calendar.getInstance()
        val monthName = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
        val dayNumber = c.get(Calendar.DAY_OF_MONTH)
        val year = c.get(Calendar.YEAR)
        return "%02d-${monthName.substring(0,3)}-$year".format(dayNumber)
    }


}
