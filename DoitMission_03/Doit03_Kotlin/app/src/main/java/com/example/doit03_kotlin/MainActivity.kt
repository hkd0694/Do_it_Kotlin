package com.example.doit03_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton2.setOnClickListener {
            topimage.visibility = View.VISIBLE
            if(bottomimage.visibility == View.VISIBLE)
                bottomimage.visibility = View.GONE
        }

        imageButton1.setOnClickListener {
            bottomimage.visibility = View.VISIBLE
            if (topimage.visibility == View.VISIBLE)
                topimage.visibility = View.GONE
        }
    }
}
