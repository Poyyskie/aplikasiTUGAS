package com.example.rentallaptop

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.pertemuan8.SharePrefHelper
import com.example.rentallaptop.viewmodel.myDBHelper
import java.io.IOException

class Profile : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnplay : Button
    private lateinit var btnpause : Button
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btn_find:Button = findViewById(R.id.btn_find)
        val btn_submit:Button = findViewById(R.id.btn_submit)
        val btn_reset:Button = findViewById(R.id.btn_reset)


        btn_submit.setOnClickListener(this)
        btn_find.setOnClickListener(this)
        btn_reset.setOnClickListener(this)

        btn_submit.setOnClickListener {
            playAudio()
        }

        btn_find.setOnClickListener {
            pauseAudio()
        }

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


private fun playAudio() {
    val audioUrlQuerySanitizer = "https://www.bensound.com/bensound-music/bensound-ukulele.mp3"
    var mediaPlayer = MediaPlayer()
    mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

    try {

        mediaPlayer!!.setDataSource(audioUrlQuerySanitizer)
        mediaPlayer!!.prepare()
        mediaPlayer!!.start()


    }catch (e: IOException){
        e.printStackTrace()
    }

    Toast.makeText(this, "Profile tersimpan", Toast.LENGTH_SHORT).show()
}

private fun pauseAudio() {
    var mediaPlayer : MediaPlayer? = null
    if(mediaPlayer!!.isPlaying){

        var mediaPlayer : MediaPlayer? = null
        mediaPlayer!!.stop()
        mediaPlayer!!.reset()
        mediaPlayer!!.release()


    }else{
        Toast.makeText(this, "PROFILE TERSIMPAN", Toast.LENGTH_SHORT).show()
    }
}}
