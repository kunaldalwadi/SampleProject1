package com.example.sampleproject1.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sampleproject1.BaseApplication;
import com.example.sampleproject1.R;
import com.example.sampleproject1.databinding.MainActivityBinding;
import com.example.sampleproject1.model.db.Transaction;
import com.example.sampleproject1.model.network.NetworkApi;
import com.example.sampleproject1.model.network.NetworkModule;
import com.example.sampleproject1.view.adapter.RecyclerViewNetworkDataAdapter;
import com.example.sampleproject1.viewmodel.MainActivityViewModel;
import com.example.sampleproject1.viewmodel.ViewModelFactory;

import java.util.Arrays;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainActivityBinding mMainActivityBinding;
    private ViewModelFactory viewModelFactory;
    private MainActivityViewModel mainActivityViewModel;
//    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Creating ViewModel like this is completely okay.
        //But if we have a Repository which in most cases we will.
        //We want only ViewModel to have access to the Repository. In that case ViewModelFactory will help.
//        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        /*
        Steps to follow
          1. Create ViewModelFactory.
          2. Create new VIewModelProvider and get viewModel object.
          3. Setup Observer.
          4. Fetch that data from ViewModel to kick start the process.
         */
        viewModelFactory = new ViewModelFactory(((BaseApplication)getApplication()).getTransactionRepositoryInstance());
        mainActivityViewModel = new ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel.class);

        setupObserver();
        fetchDataFromViewModel();


//        makeApiCall("page" + count);
//
//        mMainActivityBinding.btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                count = count + 1;
//                String pageNo = "page" + count;
//
//                Log.d(TAG, "onClick Next : Page No = " + pageNo);
//                makeApiCall(pageNo);
//            }
//        });
//
//        mMainActivityBinding.btnPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (count > 1) {
//                    count = count - 1;
//                }
//
//                String pageNo = "page" + count;
//
//                Log.d(TAG, "onClick Prev: Page No = " + pageNo);
//                makeApiCall(pageNo);
//            }
//        });
    }



    private void setupObserver() {

        mainActivityViewModel.getListLiveData().observe(this, new Observer<List<Transaction>>() {
            @Override
            public void onChanged(List<Transaction> transactions) {
                //display wherever you want.
                displayList(transactions);
            }
        });
    }

    private void fetchDataFromViewModel() {
        mainActivityViewModel.getTransactionsListFromRepository();
    }

//    private void makeApiCall(String pageNumber) {
//
//        NetworkApi networkApi = NetworkModule.getRetrofit().create(NetworkApi.class);
//
//        networkApi.getTransactions(pageNumber).enqueue(new Callback<List<Transaction>>() {
//            @Override
//            public void onResponse(Call<List<Transaction>> call, Response<List<Transaction>> response) {
//
//                Log.d(TAG, "onResponse: " + response);
//
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        List<Transaction> transactionList = response.body();
//
//                        Log.d(TAG, "onResponse: " + Arrays.toString(transactionList.toArray()));
//                        displayList(transactionList);
//                    } else {
//                        Log.d(TAG, "onResponse: else " + response.toString());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Transaction>> call, Throwable t) {
//                Log.d(TAG, "onFailure: " + t.getMessage());
//            }
//        });
//    }

    private void displayList(List<Transaction> transactionList) {

        mMainActivityBinding.rvTransactionsList.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewNetworkDataAdapter recyclerViewNetworkDataAdapter = new RecyclerViewNetworkDataAdapter(transactionList, this);
        mMainActivityBinding.rvTransactionsList.setAdapter(recyclerViewNetworkDataAdapter);
    }
}