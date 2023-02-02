package com.example.soundpool2

import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var btnplay : Button
    private lateinit var btnpause : Button
    var mediaPlayer : MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnplay = findViewById(R.id.btnplay)
        btnpause= findViewById(R.id.btnpause)

        btnplay.setOnClickListener {
            playAudio()
        }

        btnpause.setOnClickListener {
            pauseAudio()
        }
    }

    private fun playAudio() {
        val audioUrlQuerySanitizer = "https://www.bensound.com/bensound-music/bensound-ukulele.mp3"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

        try {

            mediaPlayer!!.setDataSource(audioUrlQuerySanitizer)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()


        }catch (e: IOException){
            e.printStackTrace()
        }

        Toast.makeText(this, "berhasil load", Toast.LENGTH_SHORT).show()
    }

    private fun pauseAudio() {
        if(mediaPlayer!!.isPlaying){

            mediaPlayer!!.stop()
            mediaPlayer!!.reset()
            mediaPlayer!!.release()


        }else{
            Toast.makeText(this, "gagal load", Toast.LENGTH_SHORT).show()
        }
    }
}