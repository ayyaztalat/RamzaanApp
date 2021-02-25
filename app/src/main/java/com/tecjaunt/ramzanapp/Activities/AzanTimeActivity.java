package com.tecjaunt.ramzanapp.Activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;
import com.tecjaunt.ramzanapp.Alarm;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AzanTimeActivity extends AppCompatActivity {

    ImageView back_press;
    TextView fajr_time,Dhuhur_time,Asr_time,Magrib_time,Isha_time,clock_azan;
    ImageView  fajr_image,Dhuhr_image,Asr_image,Magrib_image,Isha_Image;

    boolean check_one,check_two,check_three,check_four,check_five;

    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azan_time);
        back_press=findViewById(R.id.back_press);
        back_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fajr_time=findViewById(R.id.fajr_time);
        Dhuhur_time=findViewById(R.id.Dhuhur_time);
        Asr_time=findViewById(R.id.Asr_time);
        Magrib_time=findViewById(R.id.Magrib_time);
        Isha_time=findViewById(R.id.Isha_time);
        clock_azan=findViewById(R.id.clock_azan);




        fajr_image=findViewById(R.id.fajr_alarm);
        Dhuhr_image=findViewById(R.id.Dhur_alarm);
        Asr_image=findViewById(R.id.asr_alarm);
        Magrib_image=findViewById(R.id.magrib_alarm);
        Isha_Image=findViewById(R.id.isha_alarm);

        preferences=new Preferences(this);

        fajr_time.setText(preferences.getFajr());
        Dhuhur_time.setText(preferences.getDhur());
        Asr_time.setText(preferences.getAsr());
        Magrib_time.setText(preferences.getMaghrib());
        Isha_time.setText(preferences.getIsha());

//        int isha= Integer.parseInt(preferences.getIsha());

      //  Log.e("isha", "setAlarmFive: "+isha);

        String fiqa=preferences.getFiqa();
        if (fiqa.equalsIgnoreCase("0")) {

            clock_azan.setText("Jafri");
        }else{
            clock_azan.setText("Hanfi");
        }

        if (preferences.getCheckAlarm1()){
            fajr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        }else{
            fajr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
        }

        if (preferences.getCheckAlarm2()){
            Dhuhr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        }else{
            Dhuhr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
        }

        if (preferences.getCheckAlarm3()){
            Asr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        }else{
            Asr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
        }

        if (preferences.getCheckAlarm4()){
            Magrib_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        }else{
            Magrib_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
        }

        if (preferences.getCheckAlarm5()){
            Isha_Image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        }else{
            Isha_Image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
        }




        onclick();

        clock_azan.setVisibility(View.GONE);

    }

    private void onclick() {
        fajr_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmOne();
            }
        });

        Dhuhur_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmTwo();
            }
        });
        Asr_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmThree();
            }
        });

        Magrib_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmFour();
            }
        });
        Isha_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmFive();
            }
        });

    }

    private void setAlarmFive() {
        if (!preferences.getCheckAlarm5()){
        check_five=true;
        Isha_Image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        preferences.setCheckAlarm5(check_five);
        AlarmManager am =( AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(getApplicationContext(), Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 5, i, PendingIntent.FLAG_UPDATE_CURRENT);


        String givenDateString = preferences.getIsha();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date mDate = sdf.parse(givenDateString);
            long timeInMilliseconds = mDate.getTime();
            am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 24*60*60*1000, pi);
            Toast.makeText(this, "Alarm set isha", Toast.LENGTH_SHORT).show();
            System.out.println("Date in milli :: " + timeInMilliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        }else{
            check_five=false;
            preferences.setCheckAlarm5(check_five);
            Isha_Image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
            Intent intent = new Intent(AzanTimeActivity.this, Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(AzanTimeActivity.this, 5, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.cancel(sender);
        }

    }

    private void setAlarmFour() {
        if (!preferences.getCheckAlarm4()){
        check_four=true;
        preferences.setCheckAlarm4(check_four);
            Magrib_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        AlarmManager am =( AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(getApplicationContext(), Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 4, i, PendingIntent.FLAG_UPDATE_CURRENT);


        String givenDateString = preferences.getMaghrib();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date mDate = sdf.parse(givenDateString);

            long timeInMilliseconds = mDate.getTime();

            am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 24*60*60*1000, pi);
            Toast.makeText(this, "Alarm set magrib", Toast.LENGTH_SHORT).show();;
            System.out.println("Date in milli :: " + timeInMilliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        }else{
            check_four=false;
            preferences.setCheckAlarm4(check_four);
            Magrib_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
            Intent intent = new Intent(getApplicationContext(), Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 4, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }

    private void setAlarmThree() {
        if (!preferences.getCheckAlarm3()){
        check_three=true;
        preferences.setCheckAlarm3(check_three);
            Asr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        AlarmManager am =( AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(getApplicationContext(), Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 3, i, PendingIntent.FLAG_UPDATE_CURRENT);


        String givenDateString = preferences.getAsr();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date mDate = sdf.parse(givenDateString);
            long timeInMilliseconds = mDate.getTime();
            am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 24*60*60*1000, pi);
            Toast.makeText(this, "Alarm set asr", Toast.LENGTH_SHORT).show();
            System.out.println("Date in milli :: " + timeInMilliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        }else{
            check_three=false;
            preferences.setCheckAlarm3(check_three);
            Asr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
            Intent intent = new Intent(getApplicationContext(), Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 3, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }

    private void setAlarmTwo() {
        if (!preferences.getCheckAlarm2()){
        check_two=true;
            Dhuhr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));
        preferences.setCheckAlarm2(check_two);
        AlarmManager am =( AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(getApplicationContext(), Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 2, i, PendingIntent.FLAG_UPDATE_CURRENT);


        String givenDateString = preferences.getDhur();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date mDate = sdf.parse(givenDateString);
            long timeInMilliseconds = mDate.getTime();
            am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 24*60*60*1000, pi);
            Toast.makeText(this, "Alarm set dhur", Toast.LENGTH_SHORT).show();
            System.out.println("Date in milli :: " + timeInMilliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        }else{
            check_two=false;

            preferences.setCheckAlarm2(check_two);
            Dhuhr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
            Intent intent = new Intent(getApplicationContext(), Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }

    private void setAlarmOne() {
        if (!preferences.getCheckAlarm1()) {
            check_one = true;
            preferences.setCheckAlarm1(check_one);
            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(getApplicationContext(), Alarm.class);
            PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 1, i, PendingIntent.FLAG_UPDATE_CURRENT);
            fajr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm));

            String givenDateString = preferences.getFajr();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            try {
                Date mDate = sdf.parse(givenDateString);
                long timeInMilliseconds = mDate.getTime();
                am.setRepeating(AlarmManager.RTC_WAKEUP, timeInMilliseconds, 24*60*60*1000, pi);
                Toast.makeText(this, "Alarm set fajr", Toast.LENGTH_SHORT).show();
                System.out.println("Date in milli :: " + timeInMilliseconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            check_one=false;
            preferences.setCheckAlarm1(check_one);
            fajr_image.setImageDrawable(getResources().getDrawable(R.drawable.alarm_off));
            Intent intent = new Intent(getApplicationContext(), Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, "Alarm removed", Toast.LENGTH_SHORT).show();
            alarmManager.cancel(sender);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
