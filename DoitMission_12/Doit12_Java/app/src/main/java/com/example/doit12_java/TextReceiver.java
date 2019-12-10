package com.example.doit12_java;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TextReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra(MainActivity.message);
        Intent broadIntent = new Intent(context,MainActivity.class);
        broadIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        broadIntent.putExtra(MainActivity.message,message);
        context.startActivity(broadIntent);
        Intent stopService1 = new Intent(context,TextService.class);
        context.stopService(stopService1);
    }
}
