package com.example.rentallaptop

import MyAlarmReceiver
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.rentallaptop.databinding.ActivityTransferBinding
import com.example.rentallaptop.main_ui.EXTRA_PESAN
import com.example.rentallaptop.main_ui.payment.PaymentActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.*
class Transfer : AppCompatActivity() {


    private lateinit var binding: ActivityTransferBinding
    private var activeButton: Button? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)


        val submit: Button = findViewById(R.id.submit)

        submit.setOnClickListener {
            var myDetailIntent =
                Intent(this@Transfer, PaymentActivity::class.java)
            startActivity(myDetailIntent)
        }
        doAsync {
            Thread.sleep(5000L)
            uiThread {
                showNotivy()
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun showNotivy() {
        val Channel_id = "my_channel_01"
        val name = "ON/OFF"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val nNotifyChannel = NotificationChannel(Channel_id,
            name,
            importance)

        val myNotfyManager =
            this.getSystemService(android.content.Context.NOTIFICATION_SERVICE) as NotificationManager
        val myBuilder = NotificationCompat.Builder(this,Channel_id)
            .setContentTitle("Metode pembayaran")
            .setContentText("lanjut ke menu pembayaran")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
        myNotfyManager.createNotificationChannel(nNotifyChannel)
        myNotfyManager.notify(1101, myBuilder.build())

    }
        }


