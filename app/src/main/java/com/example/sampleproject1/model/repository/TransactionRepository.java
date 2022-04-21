package com.example.sampleproject1.model.repository;

import com.example.sampleproject1.model.db.Transaction;
import com.example.sampleproject1.model.rds.TransactionRDS;

import java.util.List;

public class TransactionRepository {

    //This class will be gathering data form RDS and DDS
    //So this class needs the object of only those two classes.

    private static TransactionRepository transactionRepository;
    private final TransactionRDS transactionRDS;

    public TransactionRepository(TransactionRDS transactionRDS) {
        this.transactionRDS = transactionRDS;
    }

    public static TransactionRepository getInstance(TransactionRDS transactionRDS) {

        if (transactionRepository == null) {
            synchronized (TransactionRepository.class) {
                if (transactionRepository == null) {
                    transactionRepository = new TransactionRepository(transactionRDS);
                }
            }
        }

        return transactionRepository;
    }

    //This function brings data from RDS to Repository.
    //This function needs to be called from ViewModel to move data from here to ViewModel.
    //If we have database we send data from here to Database as well.
    public List<Transaction> getTransactionsListFromRDS() {
        return transactionRDS.getTransactionsFromNetwork();
    }
}
