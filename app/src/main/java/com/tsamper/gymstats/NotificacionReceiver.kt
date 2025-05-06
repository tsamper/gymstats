package com.tsamper.gymstats

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificacionReceiver : BroadcastReceiver() {
    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun onReceive(context: Context, intent: Intent) {
        val builder = NotificationCompat.Builder(context, "canal_id")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("¡Recordatorio diario!")
            .setContentText("Tu mensaje diario a la hora programada")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(1001, builder.build())
    }
}