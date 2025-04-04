package com.example.scientificcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val cosButton = findViewById<Button>(R.id.cosButton)
        val sinButton = findViewById<Button>(R.id.sinButton)
        val tanButton = findViewById<Button>(R.id.tanButton)
        val powButton = findViewById<Button>(R.id.powButton)
        val sqrtButton = findViewById<Button>(R.id.sqrtButton)
        val logButton = findViewById<Button>(R.id.logButton)
        val modButton = findViewById<Button>(R.id.modButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        addButton.setOnClickListener { performOperation(inputEditText, resultTextView, "+") }
        subtractButton.setOnClickListener { performOperation(inputEditText, resultTextView, "-") }
        multiplyButton.setOnClickListener { performOperation(inputEditText, resultTextView, "*") }
        divideButton.setOnClickListener { performOperation(inputEditText, resultTextView, "/") }
        cosButton.setOnClickListener { performSingleOperation(inputEditText, resultTextView, "cos") }
        sinButton.setOnClickListener { performSingleOperation(inputEditText, resultTextView, "sin") }
        tanButton.setOnClickListener { performSingleOperation(inputEditText, resultTextView, "tan") }
        powButton.setOnClickListener { performOperation(inputEditText, resultTextView, "pow") }
        sqrtButton.setOnClickListener { performSingleOperation(inputEditText, resultTextView, "sqrt") }
        logButton.setOnClickListener { performSingleOperation(inputEditText, resultTextView, "log") }
        modButton.setOnClickListener { performOperation(inputEditText, resultTextView, "mod") }
    }

    private fun performOperation(inputEditText: EditText, resultTextView: TextView, operation: String) {
        val inputText = inputEditText.text.toString()
        val numbers = inputText.split(" ").mapNotNull { it.toDoubleOrNull() }

        if (numbers.size < 2) {
            Toast.makeText(this, "Enter two numbers separated by space", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = numbers[0]
        val num2 = numbers[1]
        val result = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else { Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show(); return }
            "pow" -> num1.pow(num2)
            "mod" -> num1 % num2
            else -> return
        }
        resultTextView.text = "Result: $result"
    }

    private fun performSingleOperation(inputEditText: EditText, resultTextView: TextView, operation: String) {
        val inputText = inputEditText.text.toString()
        val number = inputText.toDoubleOrNull()

        if (number == null) {
            Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "cos" -> cos(Math.toRadians(number))
            "sin" -> sin(Math.toRadians(number))
            "tan" -> tan(Math.toRadians(number))
            "sqrt" -> sqrt(number)
            "log" -> if (number > 0) log10(number) else { Toast.makeText(this, "Logarithm undefined for non-positive values", Toast.LENGTH_SHORT).show(); return }
            else -> return
        }
        resultTextView.text = "Result: $result"
    }
}
