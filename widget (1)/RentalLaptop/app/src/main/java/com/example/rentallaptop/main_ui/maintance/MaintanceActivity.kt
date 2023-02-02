package com.example.rentallaptop.main_ui.maintance

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.rentallaptop.R
import com.example.rentallaptop.databinding.ActivityMaintanceBinding
import org.jetbrains.anko.find
import java.io.IOException

private const val SAVE = "SIMPAN"
class MaintanceActivity : AppCompatActivity() {
    var mediaPlayer : MediaPlayer? = null
    private lateinit var send : Button

    private val CHANNEL_ID = "channel_id"
    private val notificationId = 101

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
    createNotificationChannel()
       binding.send.setOnClickListener{
           sendNotification()
       }
    }


    private fun createNotificationChannel(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
       val name = "Notification Title"
        val descriptionText = "Notification Description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel :NotificationChannel = NotificationChannel(CHANNEL_ID,name,importance).apply {
            description=descriptionText
        }
        val notificationManager: NotificationManager =getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
    }
    private fun sendNotification(){
        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.laptop)
            .setContentTitle("LAPORAN")
            .setContentText("KELUHAN ANDA SUDAH DITERIMA")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(notificationId,builder.build())
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









