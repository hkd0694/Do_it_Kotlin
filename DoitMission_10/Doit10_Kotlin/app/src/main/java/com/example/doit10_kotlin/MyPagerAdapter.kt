package com.example.doit10_kotlin

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter: FragmentPagerAdapter {

    var emailFragment: EmailFragment = EmailFragment()
    var infoFragment: InfoFragment = InfoFragment()
    var locationFragment: LocationFragment = LocationFragment()
    var tabCount:Int = 0

    constructor(fm : FragmentManager, count:Int) : super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        tabCount = count
        Log.e("Start", " 여기 들어옴 $tabCount")
    }


    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->    return emailFragment
            1 ->    return infoFragment
            2 ->    return locationFragment
        }
        return emailFragment
    }

    override fun getCount(): Int {
        return tabCount
    }
}