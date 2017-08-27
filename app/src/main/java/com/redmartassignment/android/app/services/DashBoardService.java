package com.redmartassignment.android.app.services;

import com.redmartassignment.android.callbackInterfaces.GetProductsListener;
import com.redmartassignment.android.responseModels.productList.ProductListResponse;
import com.redmartassignment.android.utils.RetrofitAdapters;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class DashBoardService {


    public void getProductList(int pageCount, final GetProductsListener getProductsListener) {
        Timber.d("-- getProductList --");
        Call<ProductListResponse> call = RetrofitAdapters.getWebServiceInterface().getAllProducts(String.valueOf(pageCount), String.valueOf(20));

        call.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                if (response.isSuccessful()) {
                    getProductsListener.onProductListSuccess(response.body());
                } else {
                    getProductsListener.onProductListError("Something went wrong..");
                }
            }

            @Override
            public void onFailure(Call<ProductListResponse> call, Throwable throwable) {
                getProductsListener.onProductListError(throwable.getLocalizedMessage());
            }
        });

    }

}
