package com.tecjaunt.ramzanapp.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tecjaunt.ramzanapp.AdManger;
import com.tecjaunt.ramzanapp.Adapter.TimeAdapter;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;
import com.tecjaunt.ramzanapp.networkArea.network.IslamModel;
import com.tecjaunt.ramzanapp.networkArea.network.NetworkListener;
import com.tecjaunt.ramzanapp.networkArea.network.networkArray;

import java.util.ArrayList;

public class SaharIftarActivity extends AppCompatActivity {

    ImageView calender_opener,back_press;
    TextView number,Date,sehr_time,iftar_time;
    RecyclerView recycler_view;
    Preferences preferences;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.azan_time_current);
        calender_opener=findViewById(R.id.calender_opener);
        back_press=findViewById(R.id.back_press);

        RelativeLayout adLayout=findViewById(R.id.adLayout);
//        AdManger.init(this);
        AdManger.loadBannerAds(adLayout,this);


        // Instantiate an AdView object.
        // NOTE: The placement ID from the Facebook Monetization Manager identifies your App.
        // To get test ads, add IMG_16_9_APP_INSTALL# to your placement id. Remove this when your app is ready to serve real ads.

        recycler_view=findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        array=new networkArray(this);

        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading Calendar");
        progressDialog.setMessage("Please wait while we are loading Calender");
        progressDialog.setCancelable(false);


        callFOrAPI();

      /*  number=findViewById(R.id.number);
        Date=findViewById(R.id.Date);
        sehr_time=findViewById(R.id.sehr_time);
        iftar_time=findViewById(R.id.iftar_time);*/

        preferences=new Preferences(this);
       /* number.setText(preferences.getHijirDay());

        Date.setText(preferences.getDay()+" "+preferences.getDate());

        sehr_time.setText(preferences.getFajr());
        iftar_time.setText(preferences.getMaghrib());*/

        onclick();
    }
    networkArray array;
    TimeAdapter adapter;
    private void callFOrAPI() {
    progressDialog.show();

        array.GETWeather(new NetworkListener<ArrayList>() {
            @Override
            public void onResult(ArrayList object) {
                Log.e("error", "onResult: "+object );
                if (object.isEmpty()){
                    progressDialog.dismiss();

                    String array=preferences.getModel();
                    ArrayList<IslamModel> models= new Gson().fromJson(array,ArrayList.class);
                    adapter=new TimeAdapter(SaharIftarActivity.this,models);

                    recycler_view.setAdapter(adapter);
                }else{
                    preferences.setModel(object);

                    progressDialog.dismiss();
                    adapter=new TimeAdapter(SaharIftarActivity.this,object);
                    recycler_view.setAdapter(adapter);
                }


            }
        }, new NetworkListener() {
            @Override
            public void onResult(Object object) {
                progressDialog.dismiss();

            }
        });

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
