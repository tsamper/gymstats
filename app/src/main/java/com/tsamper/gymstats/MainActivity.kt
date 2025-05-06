package com.tsamper.gymstats

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        crearCanalNotificaciones(this)
        val botonCreatina: Button = findViewById(R.id.buttonCreatina)
        botonCreatina.setOnClickListener{
            val intent = Intent(this, CreatinaActivity::class.java)
            startActivity(intent)
        }
        val botonPesos: Button = findViewById(R.id.buttonPesos)
        botonPesos.setOnClickListener{
            val intent = Intent(this, PesosActivity::class.java)
            startActivity(intent)
        }

    }

    fun crearCanalNotificaciones(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val canal = NotificationChannel(
                "canal_id",
                "Canal de Recordatorios",
                NotificationManager.IMPORTANCE_HIGH
            )
            canal.description = "Canal para notificaciones diarias"

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(canal)
        }
    }
}