package com.example.suara

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


private var sp : SoundPool? = null
private var SoundID = 0



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        }
    }

    override fun onStart() {
        super.onStart()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            createNewsoundPool()
        }
        else{
            createOldSoundPool()
        }
        sp?.setOnLoadCompleteListener { soundPool, sampleId, status ->
            if(status != 0) {
                Toast.makeText(this, "gagal load", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "berhasil load", Toast.LENGTH_SHORT).show()
            }
        }
        SoundID =sp?.load(this,R.raw.save,1) ?: 0
    }

    fun createOldSoundPool() {
        sp = SoundPool(15,AudioManager.STREAM_MUSIC,0)
    }

    fun createNewsoundPool() {
        sp = SoundPool.Builder()
            .setMaxStreams(15)
            .build()
    }

    override fun onStop() {
        super.onStop()
        sp?.release()
        sp = null
    }
}






