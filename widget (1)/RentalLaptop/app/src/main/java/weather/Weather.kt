package weather

import MyAlarmReceiver
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rentallaptop.R
import com.example.rentallaptop.main_ui.EXTRA_PESAN
import java.util.*

class Weather : AppCompatActivity() {

    private var mPendingIntent: PendingIntent? = null
    private var sendIntent: Intent? = null
    private var mAlarmManager: AlarmManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)


        val setAlarm: Button = findViewById(R.id.setAlarm)
        val cancelAlarm: Button = findViewById(R.id.cancelAlarm)
        val myMessage: EditText = findViewById(R.id.myMessage)
        mAlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        setAlarm.setOnClickListener{
            if (mPendingIntent != null){
                mAlarmManager?.cancel(mPendingIntent)
                mPendingIntent?.cancel()
            }
            var alarmTimer = Calendar.getInstance()
            alarmTimer.add(Calendar.SECOND,15)

            Log.w("Ok", "${alarmTimer.time}")

            sendIntent = Intent(this, MyAlarmReceiver::class.java)
            sendIntent?.putExtra(EXTRA_PESAN,myMessage.text.toString())

            mPendingIntent = PendingIntent
                .getBroadcast(this,101, sendIntent!!,0)

           // mAlarmManager?.set(AlarmManager.RTC,alarmTimer.timeInMillis,mPendingIntent)
            mAlarmManager?.setInexactRepeating(AlarmManager.RTC,alarmTimer.timeInMillis,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES,mPendingIntent)
            Toast.makeText(this,"Scheduler Di Aktifkan",Toast.LENGTH_SHORT).show()
        }
        cancelAlarm.setOnClickListener{
            if(mPendingIntent!=null){
                mAlarmManager?.cancel(mPendingIntent)
                mPendingIntent?.cancel()
                Toast.makeText(this,"alarmstop", Toast.LENGTH_SHORT).show()  }
            else{
                Toast.makeText(this,"alarmbelumdimulai", Toast.LENGTH_SHORT).show()

            }

        }
    }
}



