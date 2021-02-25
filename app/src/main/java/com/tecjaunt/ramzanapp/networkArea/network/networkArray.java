package com.tecjaunt.ramzanapp.networkArea.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static okhttp3.internal.Internal.instance;

public class networkArray {

    private final Context context;
    private String OPEN_ISLAM_API;
    private String latitude;
    private String longitude;
    private String method;
    private int month;
    private int year;
    Preferences preferences;
    private RequestQueue requestQueue;
    private static networkArray instance;


    public networkArray(Context context){
    this.context=context;
    preferences=new Preferences(context);
    latitude=preferences.getLatitude();
    longitude=preferences.getLongitude();
    method=preferences.getFiqa();
    month=preferences.getMonth();
    year=preferences.getYear();


    OPEN_ISLAM_API="http://api.aladhan.com/v1/calendar?latitude="+latitude+"&longitude="+longitude+"&method="+method+"&month="+month+"&year="+year;


}
    public static synchronized networkArray getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new networkArray(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue()
    {
        if (requestQueue == null)
        {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }

    public void GETWeather(final NetworkListener<ArrayList> okListener, final NetworkListener errorListener)
    {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                Request.Method.GET, OPEN_ISLAM_API, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    // Parse our json response and put it into a data structure of our choosing - at the moment just an arrayList
                    ArrayList result = parseISLAMAPI(response);

                    okListener.onResult(result);
                }
                catch (JSONException e)
                {
                    // For now, if something goes wrong just send nothing back - although we should send something sensible back
                    errorListener.onResult(null);

                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                // For now, if something goes wrong just send nothing back - although we should send something sensible back
                errorListener.onResult(null);
            }
        }
        );

        addToRequestQueue(jsObjRequest);
    }

    private ArrayList parseISLAMAPI(JSONObject json)
            throws JSONException
    {
        ArrayList arrayList = new ArrayList();

        //getting the list node from the json
        JSONArray list=json.getJSONArray("data");

        // Now iterate through each one creating our data structure and grabbing the info we need
        for(int i=0;i<list.length();i++)
        {
            // Create a new instance of our
            IslamModel dtEntry = new IslamModel();

            // Get the dateTime object
            JSONObject dtItem = list.getJSONObject(i);
            JSONObject dateObject=dtItem.getJSONObject("date");



                JSONObject gregorianArray=dateObject.getJSONObject("gregorian");

                dtEntry.date=gregorianArray.getString("date");
                JSONObject day=gregorianArray.getJSONObject("weekday");
                dtEntry.day=day.getString("en");



                JSONObject hijri_array=dateObject.getJSONObject("hijri");

                dtEntry.ramzan_date=hijri_array.getString("date");


            JSONObject list2=list.getJSONObject(i);
            JSONObject timmings=list2.getJSONObject("timings");


            dtEntry.sahri_time=timmings.getString("Fajr");
            dtEntry.Sunrise=timmings.getString("Sunrise");
            dtEntry.aftari_time=timmings.getString("Maghrib");
            dtEntry.Dhuhr=timmings.getString("Dhuhr");
            dtEntry.Asr=timmings.getString("Asr");
            dtEntry.Sunset=timmings.getString("Sunset");
            dtEntry.Isha=timmings.getString("Isha");
            dtEntry.Imsak=timmings.getString("Imsak");
            dtEntry.Midnight=timmings.getString("Midnight");


            // pull out the date and put it in our own data
          //  dtEntry.date = dtItem.getString("dt_txt");

            // Now go for the weather object



            arrayList.add(dtEntry);
        }

        return arrayList;
    }
}
