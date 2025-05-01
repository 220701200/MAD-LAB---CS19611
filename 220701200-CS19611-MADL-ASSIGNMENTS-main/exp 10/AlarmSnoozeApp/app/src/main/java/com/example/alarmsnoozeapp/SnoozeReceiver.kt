package com.example.alarmsnoozeapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager

class SnoozeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtone = RingtoneManager.getRingtone(context, uri)
        ringtone.play()

        // Schedule next snooze
        val nextIntent = Intent(context, SnoozeReceiver::class.java)
        val pendingNext = PendingIntent.getBroadcast(context, 1, nextIntent, PendingIntent.FLAG_IMMUTABLE)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val nextSnoozeTime = System.currentTimeMillis() + 10 * 60 * 1000
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, nextSnoozeTime, pendingNext)
    }
}