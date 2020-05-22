package com.example.androidbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        init()
    }

    private fun init(){
        link_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        btn_login.setOnClickListener {
            logInUser()
        }
    }

    private fun logInUser(){
        val email = input_email.text.toString()
        val password = input_password.text.toString()
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please fill all field",
                Toast.LENGTH_LONG).show()
            return
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("user success message ", "signInWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(this, "user Succesfuly sign in.",
                        Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("error", "signInWithEmail:failure", task.exception)
                    Toast.makeText(this, "Authentication failed. pleas check password and email",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }
}
