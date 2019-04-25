package com.tecjaunt.ramzanapp.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.tecjaunt.ramzanapp.Adapter.CalenderAdapter;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;

import com.tecjaunt.ramzanapp.networkArea.network.IslamModel;
import com.tecjaunt.ramzanapp.networkArea.network.NetworkListener;
import com.tecjaunt.ramzanapp.networkArea.network.networkArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalenderActivity extends AppCompatActivity {
    ImageView back_press;
    String latitude,longitude;
    int month,year;
    RecyclerView reyclerview_calender;
    LinearLayoutManager linearLayoutManager;

    CalenderAdapter adapter;
    Preferences preferences;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_ramzan);
        preferences=new Preferences(this);

        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading Calendar");
        progressDialog.setMessage("Please wait while we are loading Calender");
        progressDialog.setCancelable(false);

        array=new networkArray(this);
        reyclerview_calender=findViewById(R.id.reyclerview_calender);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        reyclerview_calender.setHasFixedSize(true);
        reyclerview_calender.setLayoutManager(linearLayoutManager);

        latitude=preferences.getLatitude();
        longitude=preferences.getLongitude();
        month=preferences.getMonth();
        year=preferences.getYear();

        Log.e("error", "onCreate: "+latitude+" "+longitude+" "+month+" "+year );

        getPrayerTimes();

        back_press=findViewById(R.id.back_press);
        back_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    networkArray array;
    private void getPrayerTimes() {
        progressDialog.show();
        /*APIServce servce= APIClient.getClient().create(APIServce.class);
        Call<CalenderModel> modelCall=servce.modelCall(latitude,longitude,2,month,year);
        modelCall.enqueue(new Callback<CalenderModel>() {
            @Override
            public void onResponse(Call<CalenderModel> call, Response<CalenderModel> response) {
                if (response.isSuccessful()){
                    CalenderModel model=response.body();
                    arrayList.add(model);

                    adapter=new CalenderAdapter(CalenderActivity.this,arrayList);
                    reyclerview_calender.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<CalenderModel> call, Throwable t) {

            }
        });*/

            array.GETWeather(new NetworkListener<ArrayList>() {
                @Override
                public void onResult(ArrayList object) {
                    Log.e("error", "onResult: "+object );
                    if (object.isEmpty()){
                        progressDialog.dismiss();

                        String array=preferences.getModel();
                        ArrayList<IslamModel> models= new Gson().fromJson(array,ArrayList.class);
                        adapter=new CalenderAdapter(CalenderActivity.this,models);
                    }else{
                        preferences.setModel(object);

                        progressDialog.dismiss();
                        adapter=new CalenderAdapter(CalenderActivity.this,object);
                        reyclerview_calender.setAdapter(adapter);
                    }


                }
            }, new NetworkListener() {
                @Override
                public void onResult(Object object) {
                    progressDialog.dismiss();

                }
            });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
