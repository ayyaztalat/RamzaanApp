package com.tecjaunt.ramzanapp.Services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.tecjaunt.ramzanapp.Alarm;

public class Services extends Service {

    Alarm alarm;
    public void onCreate()
    {
        super.onCreate();
      alarm  = new Alarm();
    }

 /*   @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        alarm.setAlarm(this);
        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        alarm.setAlarm(this);
    }*/

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
