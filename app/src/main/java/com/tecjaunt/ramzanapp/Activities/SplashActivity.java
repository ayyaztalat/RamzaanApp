package com.tecjaunt.ramzanapp.Activities;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Preferences preferences=new Preferences(this);
        if (preferences.getCountry().isEmpty()){
            Handlers();
        }else{
            Handler2();
        }



    }

    private void Handler2() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        },4000);
    }

    private void Handlers() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),CountrySelector.class).
                        setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        },5000);
    }
}
