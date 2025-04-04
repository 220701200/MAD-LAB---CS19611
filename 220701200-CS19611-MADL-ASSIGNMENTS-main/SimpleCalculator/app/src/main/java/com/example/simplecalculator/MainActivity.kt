package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumberEditText = findViewById<EditText>(R.id.firstNumberEditText)
        val secondNumberEditText = findViewById<EditText>(R.id.secondNumberEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        addButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "+")
        }

        subtractButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "-")
        }

        multiplyButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "*")
        }

        divideButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "/")
        }
    }

    private fun performOperation(firstEditText: EditText, secondEditText: EditText, resultTextView: TextView, operation: String) {
        val firstText = firstEditText.text.toString()
        val secondText = secondEditText.text.toString()

        if (firstText.isEmpty() || secondText.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val firstNumber = firstText.toDouble()
        val secondNumber = secondText.toDouble()
        var result: Double? = null

        when (operation) {
            "+" -> result = firstNumber + secondNumber
            "-" -> result = firstNumber - secondNumber
            "*" -> result = firstNumber * secondNumber
            "/" -> {
                if (secondNumber == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                } else {
                    result = firstNumber / secondNumber
                }
            }
        }

        resultTextView.text = "Result: $result"
    }
}
