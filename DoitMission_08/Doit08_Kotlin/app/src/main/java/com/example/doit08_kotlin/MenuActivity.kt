package com.example.doit08_kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        custom.setOnClickListener {
            val intent = Intent(this,CustomActivity::class.java)
            intent.putExtra("data",custom.text)
            startActivityForResult(intent,301)
        }

        product.setOnClickListener {
            val intent = Intent(this,ProductActivity::class.java)
            intent.putExtra("data",product.text)
            startActivityForResult(intent,301)
        }

        sales.setOnClickListener {
            val intent = Intent(this,SalesActivity::class.java)
            intent.putExtra("data",sales.text)
            startActivityForResult(intent,301)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(0,intent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            val dataA = data!!.getStringExtra("data")
            toast(dataA + "에서 넘어옴")
        }
    }
}
