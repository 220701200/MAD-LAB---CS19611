package com.example.techlounge

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count : TextView = findViewById(R.id.count)
        val checkin : Button = findViewById(R.id.checkin)
        val checkout : Button = findViewById(R.id.checkout)
        var studentCount=0
        count.text = studentCount.toString()

        checkin.setOnClickListener{
            studentCount++
            count.text=studentCount.toString()
        }

        checkout.setOnClickListener{
            if(studentCount>0)
            {
                studentCount--
                count.text=studentCount.toString()
            }
        }
    }
}
