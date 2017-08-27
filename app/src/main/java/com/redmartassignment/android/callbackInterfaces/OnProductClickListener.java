package com.redmartassignment.android.callbackInterfaces;

import android.view.View;

import com.redmartassignment.android.responseModels.productList.Product;

public interface OnProductClickListener {

    void onProductClicked(Product product, View imageView, View amountView);

    void onAddToCartCounterChanged(Product product, int count, boolean isIncreased);


}
