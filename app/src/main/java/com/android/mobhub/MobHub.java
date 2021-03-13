package com.android.mobhub;

import android.app.Application;

public class MobHub extends Application {

    public static MobHub sInstance;

    public static MobHub getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

    }

}
