package com.example.sampleproject1.model.network;

import com.example.sampleproject1.model.db.Transaction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkApi {
   
   @GET("U13023932/{page}")
   Call<List<Transaction>> getTransactions(@Path("page") String page);
   
}
