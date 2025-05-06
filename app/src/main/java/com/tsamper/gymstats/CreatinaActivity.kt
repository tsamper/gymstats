package com.tsamper.gymstats

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class CreatinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_creatina)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnElegirHora = findViewById<Button>(R.id.btnElegirHora)
        btnElegirHora.setOnClickListener {
            val now = Calendar.getInstance()
            val hour = now.get(Calendar.HOUR_OF_DAY)
            val minute = now.get(Calendar.MINUTE)

            TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                programarNotificacionDiaria(this, selectedHour, selectedMinute)
                Toast.makeText(this, "Notificación diaria programada a las $selectedHour:$selectedMinute", Toast.LENGTH_SHORT).show()
            }, hour, minute, true).show()
        }
    }

    fun programarNotificacionDiaria(context: Context, hora: Int, minuto: Int) {
        val intent = Intent(context, NotificacionReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hora)
            set(Calendar.MINUTE, minuto)
            set(Calendar.SECOND, 0)
            Log.d("NotiDebug", "Hora seleccionada: $hora:$minuto")
            if (before(Calendar.getInstance())) {
                add(Calendar.DAY_OF_MONTH, 1)
                Log.d("NotiDebug", "Hora ya pasada, programando para mañana")
            } else {
                Log.d("NotiDebug", "Programando para hoy")
            }
        }

        Log.d("NotiDebug", "Notificación programada para: ${calendar.time}")

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )

        Log.d("NotiDebug", "Alarma diaria registrada con éxito")
    }

}
