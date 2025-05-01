package com.example.alarmsnoozeapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtone = RingtoneManager.getRingtone(context, uri)
        ringtone.play()

        // Schedule snooze after 10 minutes
        val snoozeIntent = Intent(context, SnoozeReceiver::class.java)
        val pendingSnooze = PendingIntent.getBroadcast(context, 1, snoozeIntent, PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val snoozeTime = System.currentTimeMillis() + 10 * 60 * 1000
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, snoozeTime, pendingSnooze)
    }
}