package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mobhub.db.DatabaseHelper;
import com.android.mobhub.model.CatalogItem;

import java.util.List;

public class PaymentActivity extends AppCompatActivity {
    TextView tvToolbar;
    LinearLayout llBack;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        tvToolbar = findViewById(R.id.tv_toolbar);
        llBack = findViewById(R.id.ll_back);

        databaseHelper = new DatabaseHelper(PaymentActivity.this);

        tvToolbar.setText(getString(R.string.place_order));

        List<CatalogItem> items = databaseHelper.getCart();

        if(items != null && items.size() > 0){
            int price = 0;
            for(int i=0;i<items.size();i++){

            }

            TextView textView = findViewById(R.id.tv_qty);
            textView.setText(String.valueOf(items.size()));
        }

        Button btnPlaceOrder = findViewById(R.id.btn_place_order);

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PaymentActivity.this,"Your order has been placed",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PaymentActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}