package com.tecjaunt.ramzanapp;

import android.app.Application;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        AudienceNetworkAds.initialize(this);
        AdManger.init(this);
    }
}
