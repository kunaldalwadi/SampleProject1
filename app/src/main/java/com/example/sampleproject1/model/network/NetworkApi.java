package com.example.sampleproject1.model.network;

import com.example.sampleproject1.model.db.Transaction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApi {
   
   @GET("U13023932")
   Call<List<Transaction>> getTransactions();
   
}
