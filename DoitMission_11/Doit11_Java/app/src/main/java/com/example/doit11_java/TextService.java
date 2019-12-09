package com.example.doit11_java;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TextService extends Service {


    public TextService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("Start", "onStartComman() 함수 호출");

        if(intent == null){
            return Service.START_STICKY;
        } else{
            processIntent(intent);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    public void processIntent(Intent intent){

        String command = intent.getStringExtra(MainActivity.name);
        String message = intent.getStringExtra(MainActivity.message);

        Log.e("Start",command + " : " + message + " 서비스 호출");

        /*try{
            Thread.sleep(5000);
            Log.e("Start","Thread 호출중");
        }catch (Exception o){
            o.printStackTrace();
        }*/

        Intent showIntent = new Intent(getApplicationContext(),MainActivity.class);

        showIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        showIntent.putExtra(MainActivity.name,command);
        showIntent.putExtra(MainActivity.message,message);
        startActivity(showIntent);

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
