package com.redmartassignment.android.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.redmartassignment.android.BuildConfig;
import com.redmartassignment.android.retrofitWebservice.RedMartWebInterface;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapters {


    private static RedMartWebInterface retrofitAdapterInterface;

    public static RedMartWebInterface getWebServiceInterface() {
        if (retrofitAdapterInterface != null) {
            return retrofitAdapterInterface;
        }
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(AppConstants.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getValidatedClient())
                .build();

        retrofitAdapterInterface = restAdapter.create(RedMartWebInterface.class);
        return retrofitAdapterInterface;
    }


    private static OkHttpClient getValidatedClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(interceptor);
        }
        httpClient.readTimeout(120, TimeUnit.SECONDS);
        httpClient.connectTimeout(120, TimeUnit.SECONDS);
        return httpClient.build();
    }


}
