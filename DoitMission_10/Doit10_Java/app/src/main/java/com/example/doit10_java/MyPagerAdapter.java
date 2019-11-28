package com.example.doit10_java;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private EmailFragment emailFragment = new EmailFragment();
    private InfoFragment infoFragment = new InfoFragment();
    private MapFragment mapFragment = new MapFragment();
    private int tabCount = 0;

    public MyPagerAdapter(FragmentManager fm, int tabCount){
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabCount = tabCount;
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return emailFragment;
            case 1:
                return infoFragment;
            case 2:
                return mapFragment;
                default:
                    return null;
        }
    }
}
