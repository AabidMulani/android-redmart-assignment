package com.redmartassignment.android.callbackInterfaces;

import com.redmartassignment.android.responseModels.productList.ProductListResponse;

public interface GetProductsListener {

    void onProductListSuccess(ProductListResponse productsListResponse);

    void onProductListError(String errorMsg);


}
