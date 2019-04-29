package com.tecjaunt.ramzanapp.PreferenceDir;

import android.content.Context;
import android.content.ContextWrapper;

import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;

public class Preferences {

    public Preferences(Context context) {
        new Prefs.Builder().setContext(context)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(context.getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

    }

    public void setCountry(String countryName) {
        Prefs.putString("country", countryName);
    }

    public String getCountry() {
        return Prefs.getString("country", "");
    }

    public void setLongitude(String longitude) {
        Prefs.putString("longitude", longitude);
    }

    public void setLatitude(String latitude) {
        Prefs.putString("latitude", latitude);
    }

    public String getLongitude() {
        return Prefs.getString("longitude", "");
    }

    public String getLatitude() {
        return Prefs.getString("latitude", "");
    }

    public void setMonth(int month) {
        Prefs.putInt("month", month);
    }

    public void setYear(int year) {
        Prefs.putInt("year", year);
    }

    public int getMonth() {
        return Prefs.getInt("month", 0);

    }

    public int getYear() {
        return Prefs.getInt("year", 0);
    }

    public void setModel(ArrayList object) {
        String gson = new Gson().toJson(object);
        Prefs.putString("object", gson);
    }

    public String getModel() {
        return Prefs.getString("object", "");
    }

    public void setDate(String date) {
        Prefs.putString("date", date);

    }

    public void setDay(String day) {
        Prefs.putString("day", day);
    }

    public void setFajr(String Fajr) {
        Prefs.putString("Fajr", Fajr);
    }

    public void setSunRise(String Fajr) {
        Prefs.putString("sunrise", Fajr);
    }

    public void setDhur(String Fajr) {
        Prefs.putString("dhur", Fajr);
    }

    public void setAsr(String Fajr) {
        Prefs.putString("asr", Fajr);
    }

    public void setSunset(String Fajr) {
        Prefs.putString("sunset", Fajr);
    }

    public void setMaghrib(String Fajr) {
        Prefs.putString("maghrib", Fajr);
    }

    public void setIsha(String Fajr) {
        Prefs.putString("isha", Fajr);
    }

    public void setMidnight(String Fajr) {
        Prefs.putString("midnight", Fajr);
    }



    public String getDate() {
       return Prefs.getString("date", "");

    }

    public String getDay() {
        return  Prefs.getString("day", "");
    }

    public String getFajr() {
        return  Prefs.getString("Fajr", "");
    }

    public String getSunRise() {
        return Prefs.getString("sunrise", "");
    }

    public String getDhur() {
        return Prefs.getString("dhur", "");
    }

    public String getAsr() {
        return   Prefs.getString("asr", "");
    }

    public String getSunset() {
        return  Prefs.getString("sunset", "");
    }

    public String getMaghrib() {
        return  Prefs.getString("maghrib", "");
    }

    public String getIsha() {
        return  Prefs.getString("isha", "");
    }

    public String getMidnight() {
        return  Prefs.getString("midnight", "");
    }


    public void setHijirDay(String hijriDay) {
        Prefs.putString("hijriDay",hijriDay);
    }
    public String getHijirDay() {
       return Prefs.getString("hijriDay","");
    }


    public void setCheckAlarm1(Boolean alarm){
        Prefs.putBoolean("alarm1",alarm);
    }public void setCheckAlarm2(Boolean alarm){
        Prefs.putBoolean("alarm2",alarm);
    }public void setCheckAlarm3(Boolean alarm){
        Prefs.putBoolean("alarm3",alarm);
    }public void setCheckAlarm4(Boolean alarm){
        Prefs.putBoolean("alarm4",alarm);
    }public void setCheckAlarm5(Boolean alarm){
        Prefs.putBoolean("alarm5",alarm);
    }

    public Boolean getCheckAlarm1(){
       return Prefs.getBoolean("alarm1",false);
    }public Boolean getCheckAlarm2(){
       return Prefs.getBoolean("alarm2",false);
    }public Boolean getCheckAlarm3(){
      return   Prefs.getBoolean("alarm3",false);
    }public Boolean getCheckAlarm4(){
      return   Prefs.getBoolean("alarm4",false);
    }public Boolean getCheckAlarm5(){
       return    Prefs.getBoolean("alarm5",false);
    }

    public void setFiqa(String fiqa) {
        Prefs.putString("fiqa",fiqa);
    }

    public String getFiqa(){
        return Prefs.getString("fiqa","1");
    }
}
