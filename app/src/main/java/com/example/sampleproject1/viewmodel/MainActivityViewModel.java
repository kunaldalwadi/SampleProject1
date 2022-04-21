package com.example.sampleproject1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sampleproject1.model.db.Transaction;
import com.example.sampleproject1.model.repository.TransactionRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    //This class only needs to talk to Repository.

    private final TransactionRepository transactionRepository;
    private MutableLiveData<List<Transaction>> listMutableLiveData;

    public MainActivityViewModel(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;

        listMutableLiveData = new MutableLiveData<>();
    }

    public void getTransactionsListFromRepository() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                List<Transaction> transactionsListFromRepo = transactionRepository.getTransactionsListFromRDS();

                listMutableLiveData.postValue(transactionsListFromRepo);
            }
        }).start();
    }

    public LiveData<List<Transaction>> getListLiveData() {
        return listMutableLiveData;
    }
}
