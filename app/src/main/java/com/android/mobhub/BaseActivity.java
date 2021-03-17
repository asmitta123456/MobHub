package com.android.mobhub;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;

public abstract class BaseActivity extends LocalizationActivity {

    protected static final String TAG = BaseActivity.class.getName();

    protected DrawerLayout mDrawer;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public static boolean isAppWentToBg = false;

    public static boolean isWindowFocused = false;

    public static boolean isBackPressed = false;

    @Override
    protected void onStart() {
        applicationWillEnterForeground();
        super.onStart();
    }

    private void applicationWillEnterForeground() {
        if (isAppWentToBg) {
            isAppWentToBg = false;
        }


    }

    @Override
    protected void onStop() {
        super.onStop();

    }



    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        isWindowFocused = hasFocus;
        if (isBackPressed && !hasFocus) {
            isBackPressed = false;
            isWindowFocused = true;
        }
        super.onWindowFocusChanged(hasFocus);
    }

}