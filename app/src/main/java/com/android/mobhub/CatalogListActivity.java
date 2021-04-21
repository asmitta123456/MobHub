package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.mobhub.adapter.CatalogListAdapter;
import com.android.mobhub.model.CatalogItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CatalogListActivity extends BaseActivity implements OnClickListener {
    TextView tvToolbar;
    LinearLayout llBack;
    RecyclerView recyclerView;
    CatalogListAdapter catalogListAdapter;
    LinearLayoutManager linearLayoutManager;
    ArrayList<CatalogItem> catalogItems;
    String title = "";
    Button btnPlaceOrder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_list);

        title = getIntent().getStringExtra("title");

        tvToolbar = findViewById(R.id.tv_toolbar);
        llBack = findViewById(R.id.ll_back);
        recyclerView = findViewById(R.id.recycler_view);
        btnPlaceOrder = findViewById(R.id.btn_place_order);

        catalogItems = new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(CatalogListActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);

        catalogListAdapter = new CatalogListAdapter(CatalogListActivity.this,catalogItems);

        recyclerView.setAdapter(catalogListAdapter);

        tvToolbar.setText(title);

        llBack.setOnClickListener(this);
        btnPlaceOrder.setOnClickListener(this);

        loadData(title);

    }

    private void loadData(String title){
        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset(CatalogListActivity.this,"catalog.json"));

            JSONArray titleArray = jsonObject.optJSONArray(title.toUpperCase());

            catalogItems.clear();
            if(titleArray != null && titleArray.length() > 0){
                for (int i=0;i<titleArray.length();i++){
                    JSONObject titleObj = titleArray.optJSONObject(i);
                    CatalogItem catalogItem = new CatalogItem();
                    catalogItem.setImage(titleObj.optString("image"));
                    catalogItem.setName(titleObj.optString("name"));
                    catalogItem.setDesc(titleObj.optString("desc"));
                    catalogItem.setPrice(titleObj.optString("price"));
                    catalogItems.add(catalogItem);
                }
                catalogListAdapter.notifyDataSetChanged();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static String loadJSONFromAsset(Context context, String jsonName) {
        String json = null;
        try {
            InputStream is =context.getAssets().open(jsonName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;

            case R.id.btn_place_order:

                break;
        }
    }
}