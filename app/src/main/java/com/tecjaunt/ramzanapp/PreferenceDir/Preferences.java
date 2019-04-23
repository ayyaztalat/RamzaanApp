package com.tecjaunt.ramzanapp.PreferenceDir;

import android.content.Context;
import android.content.ContextWrapper;

import com.pixplicity.easyprefs.library.Prefs;

public class Preferences {

    public Preferences(Context context){
        new Prefs.Builder().setContext(context)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(context.getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

    }

    public void setCountry(String countryName) {
        Prefs.putString("country",countryName);
    }
    public String getCountry(){
        return Prefs.getString("country","");
    }
}
