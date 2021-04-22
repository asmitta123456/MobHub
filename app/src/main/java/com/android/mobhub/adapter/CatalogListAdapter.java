package com.android.mobhub.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.mobhub.R;
import com.android.mobhub.db.DatabaseHelper;
import com.android.mobhub.model.CatalogItem;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CatalogListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<CatalogItem> catalogItems;
    private DatabaseHelper databaseHelper;

    public CatalogListAdapter(Context context, ArrayList<CatalogItem> catalogItems){
        this.context = context;
        this.catalogItems = catalogItems;
        databaseHelper = new DatabaseHelper(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalog_list, parent, false);
        CatalogHolder catalogHolder = new CatalogHolder(view);
        return catalogHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final CatalogHolder catalogHolder = (CatalogHolder) holder;
        final CatalogItem catalogItem = catalogItems.get(position);


//        Glide.with(context).load(catalogItem.getImage()).into(catalogHolder.imageView);
        Picasso.get()
                .load(catalogItem.getImage())
                .into(catalogHolder
                .imageView);
        catalogHolder.tvName.setText(catalogItem.getName());
        catalogHolder.tvDesc.setText(catalogItem.getDesc());
        catalogHolder.tvPrice.setText(catalogItem.getPrice());

        Log.e("imagelink",catalogItem.getImage());

        if(databaseHelper.isInCart(catalogItem)){
            catalogHolder.btnAddToCart.setVisibility(View.GONE);
            catalogHolder.btnRemoveFromCart.setVisibility(View.VISIBLE);
        }else{
            catalogHolder.btnAddToCart.setVisibility(View.VISIBLE);
            catalogHolder.btnRemoveFromCart.setVisibility(View.GONE);
        }

        catalogHolder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.addToCart(catalogItem);
                catalogHolder.btnAddToCart.setVisibility(View.GONE);
                catalogHolder.btnRemoveFromCart.setVisibility(View.VISIBLE);
                notifyDataSetChanged();
            }
        });

        catalogHolder.btnRemoveFromCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.removeFromCart(catalogItem);
                catalogHolder.btnAddToCart.setVisibility(View.VISIBLE);
                catalogHolder.btnRemoveFromCart.setVisibility(View.GONE);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return catalogItems.size();
    }

    class CatalogHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvDesc, tvPrice;
        Button btnAddToCart, btnRemoveFromCart;

        public CatalogHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvPrice = itemView.findViewById(R.id.tv_price);
            btnAddToCart = itemView.findViewById(R.id.btn_add_to_cart);
            btnRemoveFromCart = itemView.findViewById(R.id.btn_remove_cart);


        }
    }

}
