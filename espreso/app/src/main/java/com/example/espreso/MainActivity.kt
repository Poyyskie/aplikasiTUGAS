package com.example.espreso

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startSecondActivity :: Button = findmyid (R.id.startSecondActivity)
        startSecondActivity.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.mikroskil.ac.id/")
            startActivity(intent)
        }
        var myUppercase:: Button = findmyid (R.id.myUppercase)
        myUppercase.setOnClickListener {
            val text = nama.text.toString().toUpperCase()
            nama.setText(text)
        }
    }
}
