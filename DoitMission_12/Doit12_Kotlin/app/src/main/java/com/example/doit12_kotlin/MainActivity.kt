package com.example.doit12_kotlin

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val name = "NAME"
        const val message = "MESSAGE"
    }

    lateinit var receiver: BroadcastReceiver

    override fun onResume() {
        receiver = TextReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("BroadCast")
        registerReceiver(receiver,intentFilter)
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendbutton.setOnClickListener {
            val serviceIntent = Intent(applicationContext, TextService::class.java)
            serviceIntent.putExtra(name,"Service")
            serviceIntent.putExtra(message,editText.text.toString())
            Log.e("Start","서비스 시작 전 호출")
            startService(serviceIntent)
        }

        val mainIntent = intent
        process(mainIntent)
    }

    private fun process(intent : Intent){
        if(intent.getStringExtra(message) != null) {
            receiveText.text = intent.getStringExtra(message)
        }
    }

    override fun onNewIntent(intent: Intent) {
        process(intent)
        super.onNewIntent(intent)
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

}
