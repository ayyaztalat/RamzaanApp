package com.tecjaunt.ramzanapp.networkArea.TimingNetwork;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tecjaunt.ramzanapp.PreferenceDir.Preferences;
import com.tecjaunt.ramzanapp.networkArea.network.IslamModel;
import com.tecjaunt.ramzanapp.networkArea.network.NetworkListener;
import com.tecjaunt.ramzanapp.networkArea.network.networkArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimingNetworkArray {

    private final Context context;
    private final String time;
    private String OPEN_ISLAM_API;
    private String latitude;
    private String longitude;
    private int method=2;
    private int month;
    private int year;
    Preferences preferences;
    private RequestQueue requestQueue;
    private static networkArray instance;


    public TimingNetworkArray(Context context,String time){
        this.context=context;
        preferences=new Preferences(context);
        latitude=preferences.getLatitude();
        longitude=preferences.getLongitude();
        month=preferences.getMonth();
        year=preferences.getYear();
        this.time=time;


        OPEN_ISLAM_API="http://api.aladhan.com/v1/timings/"+time+"?latitude="+latitude+"&longitude="+longitude+"&method="+method;


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
        JSONObject list=json.getJSONObject("data");


            TimingModel dtEntry = new TimingModel();

            // Get the dateTime object

            JSONObject dateObject=list.getJSONObject("date");



            JSONObject gregorianArray=dateObject.getJSONObject("gregorian");

            dtEntry.date=gregorianArray.getString("date");
            JSONObject object=gregorianArray.getJSONObject("weekday");


            dtEntry.day=object.getString("en");



            JSONObject timings=list.getJSONObject("timings");

            dtEntry.Fajr=timings.getString("Fajr");
            dtEntry.Sunrise=timings.getString("Sunrise");
            dtEntry.Dhur=timings.getString("Dhuhr");
            dtEntry.Asr=timings.getString("Asr");
            dtEntry.Sunset=timings.getString("Sunset");
            dtEntry.Maghrib=timings.getString("Maghrib");
            dtEntry.Isha=timings.getString("Isha");
            dtEntry.Midnight=timings.getString("Midnight");


            // pull out the date and put it in our own data
            //  dtEntry.date = dtItem.getString("dt_txt");

            // Now go for the weather object



            arrayList.add(dtEntry);


        return arrayList;
    }
}
