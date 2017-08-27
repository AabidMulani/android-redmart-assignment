package com.redmartassignment.android.retrofitWebservice;

import com.redmartassignment.android.responseModels.productDetails.ProductDetailsResponse;
import com.redmartassignment.android.responseModels.productList.ProductListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedMartWebInterface {

    @GET("/v1.5.8/catalog/search")
    Call<ProductListResponse> getAllProducts(@Query("page") String pageCount, @Query("pageSize") String pageSize);


    @GET("/v1.5.8/catalog/products/{product_id}")
    Call<ProductDetailsResponse> getProductDetails(@Path("product_id") String productId);


}
