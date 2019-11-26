package com.example.doit09_kotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_custom.*

class CustomFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val rootView =  inflater.inflate(R.layout.fragment_custom, container, false)

        var name = rootView.findViewById(R.id.name) as EditText
        var age = rootView.findViewById(R.id.age) as EditText



        save.setOnClickListener {

        }

        return rootView
    }


}
