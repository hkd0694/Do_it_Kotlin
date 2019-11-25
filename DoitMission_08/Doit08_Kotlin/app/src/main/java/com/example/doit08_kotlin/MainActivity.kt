package com.example.doit08_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        if(intent.getStringExtra("data") != null){
            toast(intent.getStringExtra("data") + "에서 넘어옴")
        }

        loginbutton.setOnClickListener {
            var id = loginId.text.toString()
            var password = loginPassword.text.toString()

            if(!id.equals("") && !password.equals("")){
                val intent = Intent(this, MenuActivity::class.java)
                startActivityForResult(intent, 101)
            } else if(id.equals("") && !password.equals("")){
                toast("아이디")
            } else if(!id.equals("") && password.equals("")){
                toast("비밀번호")
            } else if(id.equals("") && password.equals("")){
                toast("아이디/비밀번호")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == 0){
            toast("MenuActivity 에서 뒤로가기 버튼 누름")
        }

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }
}
