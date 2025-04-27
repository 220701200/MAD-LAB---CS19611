package org.rajalakshmi.experiment14speechtotext

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var tvText: TextView
    lateinit var btSpeak: Button
    private val REQUEST_CODE_SPEECH_INPUT = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        btSpeak = findViewById(R.id.btSpeak)

        btSpeak.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak something...")
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btSpeak)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK)
        {
            val result = data?.getStringArrayExtra(RecognizerIntent.EXTRA_RESULTS)
            tvText.text = result?.get(0)
        }
    }
}