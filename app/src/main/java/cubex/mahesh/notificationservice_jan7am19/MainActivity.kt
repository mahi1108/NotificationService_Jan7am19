package cubex.mahesh.notificationservice_jan7am19

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        button.setOnClickListener {

            val  nManager:NotificationManager = getSystemService(
         Context.NOTIFICATION_SERVICE)  as NotificationManager

            var nBuilder:NotificationCompat.Builder =
                   NotificationCompat.Builder(this,
                       "and7am")
            nBuilder.setSmallIcon(R.drawable.ic_child_friendly_black_24dp) //1
            nBuilder.setTicker("Sample Notification") // 2
            var bmp:Bitmap = BitmapFactory.decodeResource(resources,
                                    R.drawable.ic_child_friendly_black_24dp)
            nBuilder.setLargeIcon(bmp) // 3
            nBuilder.setContentTitle("And 7 AM Jan 2019") // 4
            nBuilder.setContentText(
                "demo notification from NareshIT Android session") // 5
            nBuilder.setAutoCancel(true) //6
            var i = Intent(this@MainActivity,
                MainActivity::class.java)
            var pIntent = PendingIntent.getActivity(this@MainActivity,
                0,i,0)
            nBuilder.setContentIntent(pIntent)  // 7
            nManager.notify(++count,nBuilder.build()) // 8
        }
    }
}
