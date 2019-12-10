package com.example.doit12_kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class TextReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val textMessage = intent.getStringExtra(MainActivity.message)
        val mainIntent = Intent(context,MainActivity::class.java)
        mainIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        mainIntent.putExtra(MainActivity.message,textMessage)
        context.startActivity(mainIntent)
        val spService = Intent(context,TextService::class.java)
        context.stopService(spService)
    }
}
