package com.example.doit08_kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product.*
import org.jetbrains.anko.startActivity

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val intent = intent

        productmenu.setOnClickListener {
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

        productlogin.setOnClickListener {
            val inten1 = Intent(this, MainActivity::class.java)
            inten1.putExtra("data",intent.getStringExtra("data"))
            inten1.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(inten1)
        }
    }

    override fun onBackPressed() {

    }
}
