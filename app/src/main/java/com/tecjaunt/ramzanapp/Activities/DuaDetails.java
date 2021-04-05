package com.tecjaunt.ramzanapp.Activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.tecjaunt.ramzanapp.AdManger;
import com.tecjaunt.ramzanapp.R;

public class DuaDetails extends AppCompatActivity {
    ImageView back_press;
    TextView arabic_text,transliterations,meaning;
    String arabic_lines, meanings_line,transliterations_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dua_full_screen);

        RelativeLayout adLayout=findViewById(R.id.adLayout);
//        AdManger.init(this);
        AdManger.loadBannerAds(adLayout,this);


        // Instantiate an AdView object.
        // NOTE: The placement ID from the Facebook Monetization Manager identifies your App.
        // To get test ads, add IMG_16_9_APP_INSTALL# to your placement id. Remove this when your app is ready to serve real ads.


        Intent getintent=getIntent();
        if (getintent!=null){
            arabic_lines=getintent.getStringExtra("dua_arabic");
            meanings_line=getintent.getStringExtra("name");
            transliterations_line=getintent.getStringExtra("translatation");
        }


        back_press=findViewById(R.id.back_press);
        arabic_text=findViewById(R.id.arabic_text);
        transliterations=findViewById(R.id.transliterations);
        meaning=findViewById(R.id.meaning);


        arabic_text.setText(arabic_lines);
        transliterations.setText(transliterations_line);
        meaning.setText(meanings_line);

        onClicks();

    }

    private void onClicks() {
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
