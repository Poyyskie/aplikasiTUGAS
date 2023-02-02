package com.example.rentallaptop.main_ui.maintance

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.rentallaptop.R
import com.example.rentallaptop.databinding.ActivityMaintanceBinding
private const val SAVE = "SIMPAN"
class MaintanceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMaintanceBinding
    private var activeButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaintanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button6.setOnClickListener{
            binding.savekeluhan.text = binding.Keluhan.text
            setActiveButton(binding.button6)
        }

        binding.button.setOnClickListener {
            setActiveButton(binding.button)
        }

        binding.button2.setOnClickListener {
            setActiveButton(binding.button2)
        }

        binding.button3.setOnClickListener {
            setActiveButton(binding.button3)
        }

        binding.button4.setOnClickListener {
            setActiveButton(binding.button4)
        }

        binding.button5.setOnClickListener {
            setActiveButton(binding.button5)
        }

        binding.send.setOnClickListener {
            Toast.makeText(this, "Laporan berhasil dikirim!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SAVE, binding.Keluhan.text.toString())
    }

    private fun setActiveButton(button: Button){
        activeButton?.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        activeButton?.setTextColor(ContextCompat.getColor(this, R.color.basic_blue_light))
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.basic_blue_dark))
        button.setTextColor(ContextCompat.getColor(this, R.color.white))
        activeButton = button
    }
}