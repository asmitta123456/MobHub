package com.android.mobhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.mobhub.adapter.CatalogListAdapter;

public class CatalogListActivity extends BaseActivity implements OnClickListener {
    TextView tvToolbar;
    LinearLayout llBack;
    RecyclerView recyclerView;
    CatalogListAdapter catalogListAdapter;
    LinearLayoutManager linearLayoutManager;
    String title = "";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_list);

        title = getIntent().getStringExtra("title");

        tvToolbar = findViewById(R.id.tv_toolbar);
        llBack = findViewById(R.id.ll_back);
        recyclerView = findViewById(R.id.recycler_view);

        linearLayoutManager = new LinearLayoutManager(CatalogListActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(catalogListAdapter);

        tvToolbar.setText(title);

        llBack.setOnClickListener(this);

        loadData(title);

    }

    private void loadData(String title){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;
        }
    }
}