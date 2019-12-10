package com.example.doit11_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val name = "NAME"
        const val message = "MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendbutton.setOnClickListener {
            val serviceIntent = Intent(applicationContext,TextService::class.java)
            serviceIntent.putExtra(name,"Service")
            serviceIntent.putExtra(message,editText.text.toString())
            Log.e("Start","버튼 클릭!")
            startService(serviceIntent)
        }
        val intent1 = intent
        processIntent(intent1)
    }

    override fun onNewIntent(intent: Intent) {
        processIntent(intent)
        super.onNewIntent(intent)
    }

    private fun processIntent(intent : Intent){
        if(intent.getStringExtra(message) != null) {
            val processmessage = intent.getStringExtra(message)
            receiveText.text = processmessage
        }
    }
}
