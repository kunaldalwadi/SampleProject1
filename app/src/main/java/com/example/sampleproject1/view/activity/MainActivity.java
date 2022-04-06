package com.example.sampleproject1.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sampleproject1.R;
import com.example.sampleproject1.databinding.MainActivityBinding;
import com.example.sampleproject1.model.db.Transaction;
import com.example.sampleproject1.model.network.NetworkApi;
import com.example.sampleproject1.model.network.NetworkModule;
import com.example.sampleproject1.view.adapter.RecyclerViewNetworkDataAdapter;

import java.util.Arrays;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainActivityBinding mMainActivityBinding;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        makeApiCall("page" + count);

        mMainActivityBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count = count + 1;
                String pageNo = "page" + count;

                Log.d(TAG, "onClick Next : Page No = " + pageNo);
                makeApiCall(pageNo);
            }
        });

        mMainActivityBinding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count > 1) {
                    count = count - 1;
                }

                String pageNo = "page" + count;

                Log.d(TAG, "onClick Prev: Page No = " + pageNo);
                makeApiCall(pageNo);
            }
        });
    }

    private void makeApiCall(String pageNumber) {

        NetworkApi networkApi = NetworkModule.getRetrofit().create(NetworkApi.class);

        networkApi.getTransactions(pageNumber).enqueue(new Callback<List<Transaction>>() {
            @Override
            public void onResponse(Call<List<Transaction>> call, Response<List<Transaction>> response) {

                Log.d(TAG, "onResponse: " + response);

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Transaction> transactionList = response.body();

                        Log.d(TAG, "onResponse: " + Arrays.toString(transactionList.toArray()));
                        displayList(transactionList);
                    } else {
                        Log.d(TAG, "onResponse: else " + response.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Transaction>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void displayList(List<Transaction> transactionList) {

        mMainActivityBinding.rvTransactionsList.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewNetworkDataAdapter recyclerViewNetworkDataAdapter = new RecyclerViewNetworkDataAdapter(transactionList, this);
        mMainActivityBinding.rvTransactionsList.setAdapter(recyclerViewNetworkDataAdapter);
    }
}