package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
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

    private void startCatalogActivity(String title){
        Intent in = new Intent(MainActivity.this, CatalogListActivity.class);
        in.putExtra("title",title);
        startActivity(in);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_smartphone:
                startCatalogActivity(getString(R.string.smartphone));
                break;

            case R.id.btn_laptop:
                startCatalogActivity(getString(R.string.laptop));
                break;

            case R.id.btn_accessories:
                startCatalogActivity(getString(R.string.accessories));
                break;

            case R.id.tv_select_lang:

                break;

        }
    }
}