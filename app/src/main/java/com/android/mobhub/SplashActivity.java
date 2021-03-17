package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.android.mobhub.auth.RegisterActivity;
import com.android.mobhub.db.Pref;

import java.util.Locale;

public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Pref.getSelectedLanguage() != null && !Pref.getSelectedLanguage().isEmpty()){
                    switch (Pref.getSelectedLanguage()){
                        case "FR":
                            Pref.setSelectedLanguage("FR");
                            setLanguage("fr");
                            break;

                        default:
                            Pref.setSelectedLanguage("EN");
                            setLanguage(Locale.ENGLISH);
                    }
                }else{
                    Pref.setSelectedLanguage("EN");
                    setLanguage(Locale.ENGLISH);
                }
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