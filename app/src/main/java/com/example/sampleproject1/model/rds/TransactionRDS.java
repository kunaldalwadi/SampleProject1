package com.example.sampleproject1.model.rds;

import com.example.sampleproject1.model.db.Transaction;
import com.example.sampleproject1.model.network.NetworkApi;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class TransactionRDS {

    //This class will be making network calls.
    //SO this class needs reference to Network API

    private static TransactionRDS transactionRDS;

    private NetworkApi networkApi;

    public TransactionRDS(NetworkApi networkApi) {
        this.networkApi = networkApi;
    }

    public static TransactionRDS getInstance(NetworkApi networkApi) {

        if (transactionRDS == null) {
            synchronized (TransactionRDS.class) {
                if (transactionRDS == null) {
                    transactionRDS = new TransactionRDS(networkApi);
                }
            }
        }

        return transactionRDS;
    }

    public List<Transaction> getTransactionsFromNetwork() {

        Call<List<Transaction>> transactions = networkApi.getTransactions("2");

        try {
            Response<List<Transaction>> listResponse = transactions.execute();

            if (listResponse.isSuccessful())
            {
                if(listResponse.body() != null)
                {
                    return listResponse.body();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
