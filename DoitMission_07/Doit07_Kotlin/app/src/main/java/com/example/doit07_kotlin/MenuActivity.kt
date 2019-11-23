package com.example.doit07_kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    final val RESULT_DATA = "data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        custom.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(RESULT_DATA,custom.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        sales.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(RESULT_DATA,sales.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        product.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(RESULT_DATA,product.text)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
