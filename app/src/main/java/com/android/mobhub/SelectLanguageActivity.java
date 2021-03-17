package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.mobhub.db.Pref;

public class SelectLanguageActivity extends BaseActivity implements View.OnClickListener {
    AppCompatButton btnEnglish,btnArabic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        init();

    }

    private void init(){
        btnEnglish = findViewById(R.id.btn_english);
        btnArabic = findViewById(R.id.btn_arabic);

        btnEnglish.setOnClickListener(this);
        btnArabic.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_english:
                Pref.setIsFirst(true);
                Pref.setSelectedLanguage("EN");
                setLanguage("en");

                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
                break;

            case R.id.btn_arabic:
                Pref.setIsFirst(true);
                Pref.setSelectedLanguage("FR");
                setLanguage("fr");

                Intent i1 = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i1);
                finish();
                break;

        }
    }

}