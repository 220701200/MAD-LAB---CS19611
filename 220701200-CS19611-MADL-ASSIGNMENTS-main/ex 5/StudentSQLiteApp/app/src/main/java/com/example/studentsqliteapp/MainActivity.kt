package com.example.studentsqliteapp

import android.content.ContentValues
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: StudentDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameField = findViewById<EditText>(R.id.nameField)
        val rollField = findViewById<EditText>(R.id.rollField)
        val marksField = findViewById<EditText>(R.id.marksField)
        val outputText = findViewById<TextView>(R.id.outputText)

        val insertButton = findViewById<Button>(R.id.insertButton)
        val updateButton = findViewById<Button>(R.id.updateButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val viewButton = findViewById<Button>(R.id.viewButton)

        dbHelper = StudentDbHelper(this)

        insertButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("name", nameField.text.toString())
                put("roll", rollField.text.toString().toInt())
                put("marks", marksField.text.toString().toInt())
            }
            db.insert("Student", null, values)
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show()
        }

        updateButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("name", nameField.text.toString())
                put("marks", marksField.text.toString().toInt())
            }
            db.update("Student", values, "roll = ?", arrayOf(rollField.text.toString()))
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
        }

        deleteButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Student", "roll = ?", arrayOf(rollField.text.toString()))
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        }

        viewButton.setOnClickListener {
            val db = dbHelper.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM Student", null)
            val builder = StringBuilder()
            while (cursor.moveToNext()) {
                builder.append("Name: ${cursor.getString(0)}, Roll: ${cursor.getInt(1)}, Marks: ${cursor.getInt(2)}\n")
            }
            cursor.close()
            outputText.text = builder.toString()
        }
    }
}