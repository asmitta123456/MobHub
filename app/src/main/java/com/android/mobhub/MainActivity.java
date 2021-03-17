package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    AppCompatButton btnMobile,btnLaptop,btnAcc;
    TextView tvSelectLang;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMobile = findViewById(R.id.btn_smartphone);
        btnLaptop = findViewById(R.id.btn_laptop);
        btnAcc = findViewById(R.id.btn_accessories);
        tvSelectLang = findViewById(R.id.tv_select_lang);

        btnMobile.setOnClickListener(this);
        btnLaptop.setOnClickListener(this);
        btnAcc.setOnClickListener(this);
        tvSelectLang.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_smartphone:

                break;

            case R.id.btn_laptop:

                break;

            case R.id.btn_accessories:

                break;

            case R.id.tv_select_lang:

                break;

        }
    }
}