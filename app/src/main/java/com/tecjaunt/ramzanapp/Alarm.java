package com.tecjaunt.ramzanapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import com.tecjaunt.ramzanapp.AudioActivity.AudioActivity;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;

import java.util.Calendar;

public class Alarm extends BroadcastReceiver {
    String TAG="mywakeaplogtag";
    Preferences preferences;

    String fajr_time;
    String Dhuhur_time;
    String Asr_time;
    String Magrib_time;
    String Isha_time;

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, TAG);
        wl.acquire(10*60*1000L /*10 minutes*/);
        preferences=new Preferences(context);

        fajr_time= preferences.getFajr();
        Dhuhur_time= preferences.getDhur();
       Asr_time = preferences.getAsr();
        Magrib_time= preferences.getMaghrib();
        Isha_time= preferences.getIsha();

        Log.e(TAG, "onReceive: "+fajr_time);

        // Put here YOUR code.
        Toast.makeText(context, "Namaz Time", Toast.LENGTH_LONG).show(); // For example

     //   MediaPlayer player=new MediaPlayer();


      /*  Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int min=calendar.get(Calendar.MINUTE);*/


     /*   String value= hour+":"+min;
        Log.e(TAG, "setAlarm: "+value);*/
        /*if (value.equalsIgnoreCase(fajr_time)){

               context.startActivity(new Intent(context, AudioActivity.class));
        }else if (value.equalsIgnoreCase(Dhuhur_time)){
            context.startActivity(new Intent(context, AudioActivity.class));
        }else if (value.equalsIgnoreCase(Asr_time)){
            ;context.startActivity(new Intent(context, AudioActivity.class));

        }else if (value.equalsIgnoreCase(Magrib_time)){
            ;
              context.startActivity(new Intent(context, AudioActivity.class));
        }else if (value.equalsIgnoreCase(Isha_time)){


        }*/
        context.startActivity(new Intent(context, AudioActivity.class));

        wl.release();
    }

    /*public void setAlarm(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);

        preferences=new Preferences(context);

        fajr_time= preferences.getFajr();
        Dhuhur_time= preferences.getDhur();
        Asr_time = preferences.getAsr();
        Magrib_time= preferences.getMaghrib();
        Isha_time= preferences.getIsha();

        Log.e(TAG, "setAlarm: "+fajr_time);
        Log.e(TAG, "setAlarm: "+Dhuhur_time);
        Log.e(TAG, "setAlarm: "+Asr_time);
        Log.e(TAG, "setAlarm: "+Magrib_time);
        Log.e(TAG, "setAlarm: "+Isha_time);

        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int min=calendar.get(Calendar.MINUTE);
        long values=System.currentTimeMillis();

        *//*String value= hour+":"+min;
        Log.e(TAG, "setAlarm: "+value);
        if (value.equalsIgnoreCase(fajr_time)){
            am.setRepeating(AlarmManager.RTC,values,1000*60*10,pi);
         //   context.startActivity(new Intent(context, AudioActivity.class));
        }else if (value.equalsIgnoreCase(Dhuhur_time)){
            am.setRepeating(AlarmManager.RTC,values,1000*60*10,pi);
         //   context.startActivity(new Intent(context, AudioActivity.class));
        }else if (value.equalsIgnoreCase(Asr_time)){
            am.setRepeating(AlarmManager.RTC,values,1000*60*10,pi);

        }else if (value.equalsIgnoreCase(Magrib_time)){
            am.setRepeating(AlarmManager.RTC,values,1000*60*10,pi);
          //  context.startActivity(new Intent(context, AudioActivity.class));
        }else if (value.equalsIgnoreCase(Isha_time)){
            am.setRepeating(AlarmManager.RTC,values,1000*60*10,pi);
         //   context.startActivity(new Intent(context, AudioActivity.class));
        }*//*

       // am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pi); // Millisec * Second * Minute
    }*/

  /*  public void cancelAlarm(Context context)
    {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }*/
}
