package com.example.sampleproject1.viewmodel;

import android.text.PrecomputedText;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.sampleproject1.model.repository.TransactionRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    public final TransactionRepository transactionRepository;

    public ViewModelFactory(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(transactionRepository);
    }
}
