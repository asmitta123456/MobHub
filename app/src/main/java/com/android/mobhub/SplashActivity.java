package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.android.mobhub.auth.RegisterActivity;
import com.android.mobhub.db.Pref;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Pref.getIsLoggedIn()){
                    Intent in = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(in);
                }else {
                    Intent in = new Intent(SplashActivity.this, RegisterActivity.class);
                    startActivity(in);
                }
            }
        },2000);

    }
}