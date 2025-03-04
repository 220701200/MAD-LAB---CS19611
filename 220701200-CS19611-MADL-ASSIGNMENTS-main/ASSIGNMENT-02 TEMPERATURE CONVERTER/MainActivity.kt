package com.example.temperatureconverter

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTemp = findViewById<EditText>(R.id.editTextText)
        val btnToFahrenheit = findViewById<Button>(R.id.btnToFahrenheit)
        val btnToCelsius = findViewById<Button>(R.id.btnToCelsius)
        val textViewResult = findViewById<TextView>(R.id.textView)

        btnToFahrenheit.setOnClickListener {
            val celsius = editTextTemp.text.toString().toDouble()
            val fahrenheit = (celsius * 9 / 5) + 32
            textViewResult.text = "Result: $fahrenheit °F"
        }

        btnToCelsius.setOnClickListener {
            val fahrenheit = editTextTemp.text.toString().toDouble()
            val celsius = (fahrenheit - 32) * 5 / 9
            textViewResult.text = "Result: $celsius °C"
        }
        }

    }
