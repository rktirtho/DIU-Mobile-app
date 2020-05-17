package com.tirtho.diu.com.tirtho.others;

import android.content.Context;
import android.content.SharedPreferences;

import com.tirtho.diu.LoginActivity;

public class ServiceHelper {


    private static SharedPreferences preferences;
    public static String mySharedPreference = "myPrep";
    public static String isLogin = "isLogin";
    public static String EMAIL = "email";
    public static String PASSWORD = "password";
    public static String TOKEN = "token";
    public static String ID= "id";
    public static String ST_NAME = "st_name";
    public static String ST_PROFILE_IMAGE = "st_image";


    public static String getToken(Context context){
        preferences = context.getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);
        return preferences.getString(TOKEN, "test");
    }

    public static String getProfileImage(Context context){
        preferences = context.getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);
        return preferences.getString(ST_PROFILE_IMAGE, "test");
    }

    public static int getId(Context context){
        preferences = context.getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);
        return preferences.getInt(ID, 0);
    }

    public static String getEmail(Context context){
        preferences = context.getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);
        return preferences.getString(EMAIL, "test");
    }

    public static String getPassword(Context context){
        preferences = context.getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);
        return preferences.getString(PASSWORD, "test");
    }

    public static String getStudentName(Context context){
        preferences = context.getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);
        return preferences.getString(ST_NAME, "test");
    }

    public static boolean isLogin(Context context){
        preferences = context.getSharedPreferences(mySharedPreference, Context.MODE_PRIVATE);
        return preferences.getBoolean(isLogin, false);
    }




}
