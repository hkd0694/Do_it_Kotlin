package com.example.doit12_kotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TextService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val message = intent.getStringExtra(MainActivity.message)
        val intentReceiver = Intent()
        intentReceiver.action = "BroadCast"
        intentReceiver.putExtra(MainActivity.message, message)
        Log.e("Start","서비스 onStartComman()")
        sendBroadcast(intentReceiver)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }
}
