package com.tecjaunt.ramzanapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tecjaunt.ramzanapp.R;

public class SaharIftarActivity extends AppCompatActivity {

    ImageView calender_opener,back_press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azan_time_current);
        calender_opener=findViewById(R.id.calender_opener);
        back_press=findViewById(R.id.back_press);



        onclick();
    }

    private void onclick() {
        calender_opener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CalenderActivity.class));
            }
        });

        back_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
