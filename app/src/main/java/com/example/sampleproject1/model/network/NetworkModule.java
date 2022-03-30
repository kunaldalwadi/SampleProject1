package com.example.sampleproject1.model.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {
    
    private static Retrofit mRetrofit;
    public static final String BASE_URL = "https://idme-takehome.proxy.beeceptor.com/refunds/";
    
    public static synchronized Retrofit getRetrofit() {
        
        if (mRetrofit == null)
        {
            mRetrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        }
        
        return mRetrofit;
    }
}
