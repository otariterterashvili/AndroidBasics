package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        logInButton.setOnClickListener{
            val email = userEmail.text.toString()
            val password = userPassword.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                Toast.makeText(this, "Log in success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Error field is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
