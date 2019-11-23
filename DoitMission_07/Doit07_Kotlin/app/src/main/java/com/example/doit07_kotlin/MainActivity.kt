package com.example.doit07_kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener{

            val intent = Intent(this,MenuActivity::class.java)
            startActivityForResult(intent,REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data1: Intent?) {
        super.onActivityResult(requestCode, resultCode, data1)
        if(requestCode == REQUEST_CODE){
            when(resultCode){
                Activity.RESULT_OK -> {
                    toast(data1?.getStringExtra("data").toString())
                }
            }
        }
    }
}
