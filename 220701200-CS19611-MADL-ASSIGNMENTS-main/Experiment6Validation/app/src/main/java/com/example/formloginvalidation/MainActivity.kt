package com.example.formloginvalidation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val user1:EditText=findViewById(R.id.user)
        val pin1 : EditText = findViewById(R.id.pin)
        val BtLogin : Button = findViewById(R.id.BtLogin)
        val BtClear : Button = findViewById(R.id.BtClear)

        BtLogin.setOnClickListener {
            val userName = user1.text.toString().trim()
            val pinNumber = pin1.text.toString().trim()
            if(userName.isEmpty() || pinNumber.isEmpty())
            {
                Toast.makeText(this,"Enter all the fields",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(!userName.matches(Regex("^[a-zA-z]+$")))
                {
                    Toast.makeText(this,"Invalid username",Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            if(!pinNumber.matches(Regex("^[0-9]{4}$")))
            {
                Toast.makeText(this,"Invalid pin number",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val intent:Intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.etUserName)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}