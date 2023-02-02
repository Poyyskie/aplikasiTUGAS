
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.rentallaptop.R
import com.example.rentallaptop.main_ui.EXTRA_PESAN


class MyAlarmReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        val NotifyId = 30103
        val channel_id = "notification_channel_id"
        val name = "ON/OFF"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val nNotifyChannel = NotificationChannel(channel_id, name, importance)
        val mBuilder = NotificationCompat.Builder(context, channel_id)
            .setSmallIcon(R.drawable.laptop)
            .setContentText(intent?.getStringExtra(EXTRA_PESAN) ?:"Pembayaran terjadwal")
            .setContentTitle("Pengingat pembayaran")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        var mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        for (s in mNotificationManager.notificationChannels){
            mNotificationManager.deleteNotificationChannel(s.id)
        }

        mNotificationManager.createNotificationChannel(nNotifyChannel)
        mNotificationManager.notify(NotifyId,mBuilder.build())

    }
}