package com.tecjaunt.ramzanapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.tecjaunt.ramzanapp.Activities.AzanTimeActivity;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoStart extends BroadcastReceiver {
    Alarm alarm = new Alarm();
    Preferences preferences;
    Boolean check_five,check_four,check_three,check_two,check_one;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            preferences=new Preferences(context);

            setAlarmFive(context);
            setAlarmFour(context);
            setAlarmTwo(context);
            setAlarmOne(context);
            setAlarmThree(context);

        }
    }

    private void setAlarmFive(Context context) {
        if (preferences.getCheckAlarm5()){
            check_five=true;
            preferences.setCheckAlarm5(check_five);
            AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, Alarm.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 5, i, PendingIntent.FLAG_UPDATE_CURRENT);


            String givenDateString = preferences.getIsha();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
                Date mDate = sdf.parse(givenDateString);
                long timeInMilliseconds = mDate.getTime();
                am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 86400000, pi);
                Toast.makeText(context, "Alarm set isha", Toast.LENGTH_SHORT).show();
                System.out.println("Date in milli :: " + timeInMilliseconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }else{
            check_five=false;
            preferences.setCheckAlarm5(check_five);
            Intent intent = new Intent(context, Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(context, 5, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.cancel(sender);
        }

    }

    private void setAlarmFour(Context context) {
        if (preferences.getCheckAlarm4()){
            check_four=true;
            preferences.setCheckAlarm4(check_four);

            AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, Alarm.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 4, i, PendingIntent.FLAG_UPDATE_CURRENT);


            String givenDateString = preferences.getMaghrib();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
                Date mDate = sdf.parse(givenDateString);

                long timeInMilliseconds = mDate.getTime();

                am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 86400000, pi);
                Toast.makeText(context, "Alarm set magrib", Toast.LENGTH_SHORT).show();;
                System.out.println("Date in milli :: " + timeInMilliseconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            check_four=false;
            preferences.setCheckAlarm4(check_four);
            Intent intent = new Intent(context, Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(context, 4, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(context, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }

    private void setAlarmThree(Context context) {
        if (preferences.getCheckAlarm3()){
            check_three=true;
            preferences.setCheckAlarm3(check_three);
            AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, Alarm.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 3, i, PendingIntent.FLAG_UPDATE_CURRENT);


            String givenDateString = preferences.getAsr();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
                Date mDate = sdf.parse(givenDateString);
                long timeInMilliseconds = mDate.getTime();
                am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 86400000, pi);
                Toast.makeText(context, "Alarm set asr", Toast.LENGTH_SHORT).show();
                System.out.println("Date in milli :: " + timeInMilliseconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            check_three=false;
            preferences.setCheckAlarm3(check_three);
            Intent intent = new Intent(context, Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(context, 3, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(context, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }

    private void setAlarmTwo(Context context) {
        if (preferences.getCheckAlarm2()){
            check_two=true;
            preferences.setCheckAlarm2(check_two);
            AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, Alarm.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 2, i, PendingIntent.FLAG_UPDATE_CURRENT);


            String givenDateString = preferences.getDhur();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
                Date mDate = sdf.parse(givenDateString);
                long timeInMilliseconds = mDate.getTime();
                am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 86400000, pi);
                Toast.makeText(context, "Alarm set dhur", Toast.LENGTH_SHORT).show();
                System.out.println("Date in milli :: " + timeInMilliseconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            check_two=false;
            preferences.setCheckAlarm2(check_two);
            Intent intent = new Intent(context, Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(context, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }

    private void setAlarmOne(Context context) {
        if (preferences.getCheckAlarm1()) {
            check_one = true;
            preferences.setCheckAlarm1(check_one);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, Alarm.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 1, i, PendingIntent.FLAG_UPDATE_CURRENT);


            String givenDateString = preferences.getFajr();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
                Date mDate = sdf.parse(givenDateString);
                long timeInMilliseconds = mDate.getTime();
                am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 86400000, pi);
                Toast.makeText(context, "Alarm set fajr", Toast.LENGTH_SHORT).show();
                System.out.println("Date in milli :: " + timeInMilliseconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            check_one=false;
            preferences.setCheckAlarm1(check_one);
            Intent intent = new Intent(context, Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(context, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }
}
