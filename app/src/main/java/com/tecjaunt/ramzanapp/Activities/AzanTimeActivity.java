package com.tecjaunt.ramzanapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;

public class AzanTimeActivity extends AppCompatActivity {

    ImageView back_press;
    TextView fajr_time,Dhuhur_time,Asr_time,Magrib_time,Isha_time,clock_azan;
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

        preferences=new Preferences(this);

        fajr_time.setText(preferences.getFajr());
        Dhuhur_time.setText(preferences.getDhur());
        Asr_time.setText(preferences.getAsr());
        Magrib_time.setText(preferences.getMaghrib());
        Isha_time.setText(preferences.getIsha());

        clock_azan.setVisibility(View.GONE);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
