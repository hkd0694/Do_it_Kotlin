package com.example.doit11_kotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TextService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(intent == null) {
            return START_STICKY
        } else {
            process1(intent)
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    private fun process1(intent : Intent){
        val name = intent.getStringExtra(MainActivity.name)
        val message = intent.getStringExtra(MainActivity.message)

        Log.e("Start", "$name + 호출 : $message")

        val backIntent = Intent(applicationContext,MainActivity::class.java)
        backIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        backIntent.putExtra(MainActivity.name,name)
        backIntent.putExtra(MainActivity.message,message)
        startActivity(backIntent)
    }
}
