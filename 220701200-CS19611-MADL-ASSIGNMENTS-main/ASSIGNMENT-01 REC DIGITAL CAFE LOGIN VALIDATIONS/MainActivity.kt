package com.example.digitalcafe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailid: EditText = findViewById(R.id.emailid)
        val password : EditText=findViewById(R.id.password)
        val validate : Button =findViewById(R.id.validatebtn)



        validate.setOnClickListener {
            val email=emailid.text.toString()
            val pass=password.text.toString()
            if(email.isEmpty() || pass.isEmpty() )
            {
                Toast.makeText(this,"All fields are Mandatory..!",Toast.LENGTH_LONG).show()
                return@setOnClickListener

            }

            else if(!email.matches(Regex("^[A-Za-z0-9._%+-]+@rajalakshmi.edu.in$")))
            {
                Toast.makeText(this,"Invalid emailid..",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            else if(!pass.matches(Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")))
            {
                Toast.makeText(this,"Invalid password...",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            else
            {
                Toast.makeText(this,"LOGIN SUCCESSFUL...!",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
        }

    }
}
