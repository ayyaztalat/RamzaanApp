package com.tecjaunt.ramzanapp.Activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.tecjaunt.ramzanapp.AdManger;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.R;

import com.tecjaunt.ramzanapp.Services.Services;
import com.tecjaunt.ramzanapp.networkArea.TimingNetwork.TimingNetworkArray;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
    int MY_PERMISSIONS_REQUEST_LOCATION=10000;
    String latitude,longitude;
    LinearLayout Azan_time_layout,Sahar_Iftar,Allah_name_layout,Muhammad_name_layout,Dua_layout;
    Preferences preferences;
    int month,year;
    Calendar calendar;
    AdManger adManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferences=new Preferences(this);
        long time= System.currentTimeMillis();

        RelativeLayout adLayout=findViewById(R.id.adLayout);

        AdManger.init(this);
        AdManger.loadBannerAds(adLayout,this);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            calendar = Calendar.getInstance();
            year= calendar.get(Calendar.YEAR);
            month= calendar.get(Calendar.MONTH)+1;
            Log.e("error",month+"-"+year);
        }else{
            java.util.Calendar calendar1= java.util.Calendar.getInstance();
            year= calendar1.get(java.util.Calendar.YEAR);
            month= calendar1.get(java.util.Calendar.MONTH);
        }


        preferences.setYear(year);
        preferences.setMonth(month);
        getLatlng();

        startService(new Intent(getApplicationContext(), Services.class));

       // array=new TimingNetworkArray(this,String.valueOf(time));
        Azan_time_layout=findViewById(R.id.Azan_time_layout);
        Sahar_Iftar=findViewById(R.id.Sahar_Iftar);
        Allah_name_layout=findViewById(R.id.Allah_name_layout);
        Muhammad_name_layout=findViewById(R.id.Muhammad_name_layout);
        Dua_layout=findViewById(R.id.Dua_layout);

        isStoragePermissionGranted();
        onClick();
        startSecond_API_For_DATE_PRAYER(time);


    }
    TimingNetworkArray array;

    private RequestQueue requestQueue;
    private static HomeActivity instance;


    JsonObjectRequest objectRequest;

    public RequestQueue getRequestQueue()
    {
        if (requestQueue == null)
        {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }
    private void startSecond_API_For_DATE_PRAYER(long time) {

     /*   array.GETWeather(new NetworkListener<ArrayList>() {
            @Override
            public void onResult(ArrayList object) {
                Log.e("error", "onResult: "+object );
                TimingModel model= (TimingModel) object.get(0);

                Log.e("error", "onResult: "+model.Asr);


            }
        }, new NetworkListener() {
            @Override
            public void onResult(Object object) {


            }
        });*/


        java.util.Calendar calendar= java.util.Calendar.getInstance();
        String date= String.valueOf(calendar.get(Calendar.DATE));
        String Month=String.valueOf(calendar.get(Calendar.MONTH));
        String year=String.valueOf(calendar.get(Calendar.YEAR));
       // String day=String.valueOf(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        preferences.setDate(date+"-"+Month+"-"+year);
      //  preferences.setDay(day);

        String   OPEN_ISLAM_API="http://api.aladhan.com/v1/timings/"+time+"?latitude="+preferences.getLatitude()+"&longitude="+preferences.getLongitude()+"&method="+preferences.getFiqa();
        Log.e("error", "startSecond_API_For_DATE_PRAYER: "+OPEN_ISLAM_API );
        RequestQueue queue = getRequestQueue();
        JsonObjectRequest objectRequest =  new JsonObjectRequest(
                Request.Method.GET, OPEN_ISLAM_API, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    JSONObject object=response.getJSONObject("data");
                   // JSONObject dateObject=object.getJSONObject("date");



                   // String date=dateObject.getString("readable");

       //             JSONObject gregorianArray=dateObject.getJSONObject("gregorian");

       //             String date=gregorianArray.getString("date");

       //             JSONObject hijriArray=dateObject.getJSONObject("hijri");

       //             String hijriDay=hijriArray.getString("day");


      //              JSONObject object2=gregorianArray.getJSONObject("weekday");
               //     String day=object.getString("en");

                    JSONObject timings=object.getJSONObject("timings");

                    String Fajr=timings.getString("Fajr");
                    String Sunrise=timings.getString("Sunrise");
                    String Dhur=timings.getString("Dhuhr");
                    String Asr=timings.getString("Asr");
                    String Sunset=timings.getString("Sunset");
                    String Maghrib=timings.getString("Maghrib");
                    String Isha=timings.getString("Isha");
                    String Midnight=timings.getString("Midnight");


                //   preferences.setDate(date);
             //       preferences.setDay(day);
                    preferences.setFajr(Fajr);
                    preferences.setSunRise(Sunrise);
                    preferences.setDhur(Dhur);
                    preferences.setAsr(Asr);
        //            preferences.setHijirDay(hijriDay);
                    preferences.setSunset(Sunset);
                    preferences.setMaghrib(Maghrib);
                    preferences.setIsha(Isha);
                    preferences.setMidnight(Midnight);


                }
                catch (JSONException e)
                {
                    // For now, if something goes wrong just send nothing back - although we should send something sensible back
                    Log.e("error", "onResponse: "+e );
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("error", "onResponse: "+error );
                // For now, if something goes wrong just send nothing back - although we should send something sensible back

            }
        }
        );
queue.add(objectRequest);

    }




    LocationRequest request;
    FusedLocationProviderClient client;
    private void getLatlng() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new android.app.AlertDialog.Builder(this)
                        .setTitle("Location Permission")
                        .setMessage("Please provide permission for get times of your location")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(HomeActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            }
        }else{
           /* Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            longitude = String.valueOf(location.getLongitude());
            latitude = String.valueOf(location.getLatitude());*/
            request= new LocationRequest();
            request.setInterval(10000);
            request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            client = LocationServices.getFusedLocationProviderClient(this);
            int permission = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION);
            if (permission == PackageManager.PERMISSION_GRANTED) {
                client.requestLocationUpdates(request,new LocationCallback(){
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        Location location = locationResult.getLastLocation();
                        if (location != null) {
                            //  Log.d(TAG, "location update " + location);
                            longitude=String.valueOf(location.getLongitude());
                            preferences.setLongitude(longitude);

                            latitude=String.valueOf(location.getLatitude());
                            preferences.setLatitude(latitude);

                     //       Log.e("error", "onLocationResult: "+preferences.getLatitude()+" "+preferences.getLongitude() +" "+longitude+latitude);

                        }
                    }



                },null);
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    //    client.removeLocationUpdates(new LocationCallback());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==MY_PERMISSIONS_REQUEST_LOCATION){
            if (resultCode==RESULT_OK && data!=null){
                getLatlng();
            }
        }
    }

    private void onClick() {
        Azan_time_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AzanTimeActivity.class));
            }
        });

        Sahar_Iftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SaharIftarActivity.class));
            }
        });

        Allah_name_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AllahNameActivity.class));
            }
        });

        Muhammad_name_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MuhammadActivity.class));
            }
        });

        Dua_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DuaLayout.class));
            }
        });

    }


    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED||checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED) {
          //      Log.v("error","Permission is granted");
                return true;
            } else {

            //    Log.v("error","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
           //// Log.v("error","Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v("error","Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure want to exit");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HomeActivity.this.finish();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
