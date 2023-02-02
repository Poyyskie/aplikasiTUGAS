package sound

import android.annotation.TargetApi
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import android.media.session.PlaybackState.ACTION_PLAY
import android.media.session.PlaybackState.ACTION_STOP
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pertemuan8.SharePrefHelper
import com.example.rentallaptop.R
import com.example.rentallaptop.viewmodel.ACTION_CREATE
import com.example.rentallaptop.viewmodel.MyMPService


//anda bisa cek datanya di Device Explorer >> data >> data >> {nama package anda di baris 1} >> shared_prefs
private val PrefFileName = "MYFILEPREF01"

var sp : SoundPool? = null
var soundID  : Int = 0
var myIntentService : Intent? = null
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btn_play:Button = findViewById(R.id.btn_play)
        val btn_find:Button = findViewById(R.id.btn_find)
        val btn_submit:Button = findViewById(R.id.btn_submit)
        val btn_reset:Button = findViewById(R.id.btn_reset)

        btn_submit.setOnClickListener(this)
        btn_find.setOnClickListener(this)
        btn_reset.setOnClickListener(this)
        btn_play.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val btn_play:Button = findViewById(R.id.btn_play)
        val btn_find:Button = findViewById(R.id.btn_find)
        val btn_submit:Button = findViewById(R.id.btn_submit)
        val btn_reset:Button = findViewById(R.id.btn_reset)

        btn_submit.setOnClickListener(this)
        btn_find.setOnClickListener(this)
        btn_reset.setOnClickListener(this)
        btn_play.setOnClickListener(this)

        var mySharedHelper = SharePrefHelper(this,PrefFileName)
        when(p0?.id){
            R.id.btn_submit -> {
                val edit_text_name : EditText = findViewById(R.id.edit_text_name)
                val edit_text_email : EditText = findViewById(R.id.edit_text_email)
                mySharedHelper.nama = edit_text_name.text.toString()
                mySharedHelper.email = edit_text_email.text.toString()
                Toast.makeText(this,"Simpan berhasil",Toast.LENGTH_SHORT).show()
                clearEditText()
                if(soundID!=0) {
                    sp?.play(soundID,.99f,.99f,1,0,.99f)
                }
            }
            R.id.btn_reset -> {
                mySharedHelper.clearValues()
                clearEditText()
            }
            R.id.btn_find -> {
                val edit_text_name : EditText = findViewById(R.id.edit_text_name)
                val edit_text_email : EditText = findViewById(R.id.edit_text_email)
                edit_text_name.setText(mySharedHelper.nama)
                edit_text_email.setText(mySharedHelper.email)
            }
            R.id.btn_play-> {
                if(btn_play.text.toString().toUpperCase().equals("PLAY")){
                    btn_play.text = "STOP"
                    myIntentService?.setAction(ACTION_PLAY.toString())
                    startService(myIntentService)
                }
                else{
                    btn_play.text = "PLAY"
                    myIntentService?.setAction(ACTION_STOP.toString())
                    startService(myIntentService)
                }
            }
        }
    }
    private fun clearEditText(){
        val edit_text_name : EditText = findViewById(R.id.edit_text_name)
        val edit_text_email : EditText = findViewById(R.id.edit_text_email)
        edit_text_name.text.clear()
        edit_text_email.text.clear()
    }

    override fun onStart() {
        super.onStart()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            createNewSoundPool()
        else
            createOldSoundPool()

        sp?.setOnLoadCompleteListener{soundPool, id, status ->
            if(status != 0)
                Toast.makeText(this,"Gagal Load",Toast.LENGTH_SHORT)
                    .show()
            else
                Toast.makeText(this,"Load Sukses",Toast.LENGTH_SHORT)
                    .show()
        }


        if(myIntentService==null){
            myIntentService = Intent(this, MyMPService::class.java)
            myIntentService?.setAction(ACTION_CREATE)
            startService(myIntentService)
        }
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun createNewSoundPool() {
        sp = SoundPool.Builder()
                .setMaxStreams(15)
                .build()
    }
    @Suppress("DEPRECATION")
    private fun createOldSoundPool() {
        sp = SoundPool(15, AudioManager.STREAM_MUSIC,0)
    }

    override fun onStop() {
        super.onStop()
        sp?.release()
        sp = null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(myIntentService)
    }
}