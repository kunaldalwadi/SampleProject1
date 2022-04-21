package com.example.sampleproject1;

import android.app.Application;

import com.example.sampleproject1.model.network.NetworkApi;
import com.example.sampleproject1.model.network.NetworkModule;
import com.example.sampleproject1.model.rds.TransactionRDS;
import com.example.sampleproject1.model.repository.TransactionRepository;

public class BaseApplication extends Application {

    private NetworkApi networkApi;

    @Override
    public void onCreate() {
        super.onCreate();

        networkApi = NetworkModule.getRetrofit().create(NetworkApi.class);
    }

    public NetworkApi getNetworkApi() {
        return networkApi;
    }

    //This should be called by MainActivity when we create ViewModel connection.
    //Only ViewModel should be sending data to Repository
    public TransactionRepository getTransactionRepositoryInstance() {
        return TransactionRepository.getInstance(getTransactionRDSInstance());
    }

    public TransactionRDS getTransactionRDSInstance() {
        return TransactionRDS.getInstance(getNetworkApi());
    }
}

