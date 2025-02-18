package com.example.guicomponents

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mainText: TextView
    private lateinit var changeFontSizeBtn: Button
    private lateinit var changeFontColorBtn: Button
    private lateinit var changeBgColorBtn: Button
    private lateinit var layout: LinearLayout

    private var fontSizeIndex = 0
    private var fontColorIndex = 0
    private var bgColorIndex = 0

    private val fontSizes = arrayOf(24f, 30f, 36f, 42f)
    private val fontColors = arrayOf(Color.BLACK, Color.GREEN, Color.BLUE, Color.RED)
    private val bgColors = arrayOf(Color.WHITE, Color.YELLOW, Color.CYAN, Color.BLUE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets*/

        // Initialize UI elements
        mainText = findViewById(R.id.main)
        changeFontSizeBtn = findViewById(R.id.button1)
        changeFontColorBtn = findViewById(R.id.button2)
        changeBgColorBtn = findViewById(R.id.button3)
        //layout=findViewById(R.id.button3).parent as LinearLayout
        //val layout: LinearLayout=findViewById(R.id.layout)
        layout=findViewById(R.id.layout)

        // Change Font Size
        changeFontSizeBtn.setOnClickListener {
            mainText.textSize = fontSizes[fontSizeIndex]
            fontSizeIndex = (fontSizeIndex + 1) % fontSizes.size
            Toast.makeText(this, "Font Size Changed!", Toast.LENGTH_SHORT).show()
        }

        // Change Font Color
        changeFontColorBtn.setOnClickListener {
            mainText.setTextColor(fontColors[fontColorIndex])
            fontColorIndex = (fontColorIndex + 1) % fontColors.size
            Toast.makeText(this, "Font Color Changed!", Toast.LENGTH_SHORT).show()
        }

        // Change Background Color
        changeBgColorBtn.setOnClickListener {
            layout.setBackgroundColor(bgColors[bgColorIndex])
            bgColorIndex = (bgColorIndex + 1) % bgColors.size
            Toast.makeText(this, "Background Color Changed!", Toast.LENGTH_SHORT).show()
        }
    }
}