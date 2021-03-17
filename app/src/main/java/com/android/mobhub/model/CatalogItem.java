package com.android.mobhub.model;

import androidx.annotation.NonNull;

public class CatalogItem {
    String id, itemName, image;
    int price, qty;


    //overrides these when db updated TODO:
    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public CatalogItem() {
        super();
    }


}
