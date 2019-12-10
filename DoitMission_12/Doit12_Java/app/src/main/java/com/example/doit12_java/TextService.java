package com.example.doit12_java;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class TextService extends Service {

    public TextService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = intent.getStringExtra(MainActivity.name);
        String message = intent.getStringExtra(MainActivity.message);
        Intent broadIntent = new Intent();
        broadIntent.setAction("BroadCast");
        broadIntent.putExtra(MainActivity.name, name);
        broadIntent.putExtra(MainActivity.message, message);
        sendBroadcast(broadIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
