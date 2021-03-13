package com.android.mobhub.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.mobhub.MobHub;

public class Pref {

    private static final String SHARED_PREFERENCES_FILE_NAME = "MobHubSharedPref";
    public static final String IS_LOGGED_IN = "false";

    public static Boolean getIsLoggedIn() {
        return (Boolean) read(IS_LOGGED_IN, Boolean.class);
    }

    public static void setIsLoggedIn(boolean appMain) {
        write(IS_LOGGED_IN, appMain);
    }

    public static void write(String key, Object value) {
        try {
            SharedPreferences sharedPreferences = getSharedPrefs();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (value instanceof String) // String value
            {
                editor.putString(key, ((String) value).trim());
            } else if (value instanceof Boolean) // Boolean value
            {
                editor.putBoolean(key, ((Boolean) value));
            } else if (value instanceof Float) // Float value
            {
                editor.putFloat(key, ((Float) value));
            } else if (value instanceof Integer) // Integer value
            {
                editor.putInt(key, ((Integer) value));
            } else if (value instanceof Long) // Long value
            {
                editor.putLong(key, ((Long) value));
            }
            editor.apply();
        } catch (Exception e) {

        }
    }

    public static Object read(String key, Class<?> classType) {
        Object object;
        SharedPreferences sharedPreferences = getSharedPrefs();
        if (classType.equals(String.class)) // String value
        {
            object = sharedPreferences.getString(key, "");
        } else if (classType.equals(Boolean.class)) // Boolean value
        {
            object = sharedPreferences.getBoolean(key, false);
        } else if (classType.equals(Integer.class)) // Integer value
        {
            object = sharedPreferences.getInt(key, 0);
        } else if (classType.equals(Float.class)) // Float value
        {
            object = sharedPreferences.getFloat(key, 0.00f);
        } else if (classType.equals(Long.class)) // Long value
        {
            object = sharedPreferences.getLong(key, 0);
        } else {
            object = null;
        }
        return object;
    }

    public static void clear(String _key) {
        getSharedPrefs().edit().remove(_key).commit();
    }

    private static SharedPreferences getSharedPrefs() {
        return MobHub.sInstance.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);

    }

}
