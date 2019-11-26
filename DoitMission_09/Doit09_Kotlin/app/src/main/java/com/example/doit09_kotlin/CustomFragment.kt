package com.example.doit09_kotlin


import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_custom.*
import java.text.SimpleDateFormat
import java.util.*

class CustomFragment : Fragment() {

    val date = Date()
    val simple = SimpleDateFormat("yyyy.MM.dd")
    private lateinit var today:String
    private lateinit var birth:Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val rootView =  inflater.inflate(R.layout.fragment_custom, container, false)

        var name = rootView.findViewById(R.id.name) as EditText
        var age = rootView.findViewById(R.id.age) as EditText
        birth = rootView.findViewById(R.id.birthday) as Button
        var save = rootView.findViewById(R.id.save) as Button
        today = simple.format(date)

        birth.text = today

        birth.setOnClickListener {
            val arr = today.split(".")
            val date = DatePickerDialog(activity!!,DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                birth.text = "${year}.${month +1}.${dayOfMonth}"
                today = "${year}.${month+1}.${dayOfMonth}"
            },Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1,Integer.parseInt(arr[2]))
            date.show()
        }
        save.setOnClickListener {
            Toast.makeText(activity!!.applicationContext,"${name.text} ${age.text} ${today}",Toast.LENGTH_LONG).show()
        }

        return rootView
    }

}

