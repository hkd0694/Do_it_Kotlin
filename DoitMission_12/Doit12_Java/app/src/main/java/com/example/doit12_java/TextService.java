package com.example.doit12_java;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TextService extends Service {
    public TextService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = intent.getStringExtra(MainActivity.name);
        String message = intent.getStringExtra(MainActivity.message);

        Log.e("Start", name + "로 보낸 메시지는 : " + message);
        /*Intent broadIntent = new Intent();
        sendBroadcast(broadIntent);*/
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
