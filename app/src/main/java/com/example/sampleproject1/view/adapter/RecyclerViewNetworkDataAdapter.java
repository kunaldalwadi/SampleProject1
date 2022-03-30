package com.example.sampleproject1.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.sampleproject1.R;
import com.example.sampleproject1.databinding.OneRowTransactionBinding;
import com.example.sampleproject1.model.db.Transaction;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewNetworkDataAdapter extends RecyclerView.Adapter<RecyclerViewNetworkDataAdapter.RecyclerViewNetworkDataHolder> {
   
   /*
   Whatever you want to show on this list view whatever kind of data, that has to be brought here, thats a 101.
   so to do that we do manual dependency injection (constructor injection).
    */
   
   private List<Transaction> mTransactionList;
   private Context mContext;
   
   public RecyclerViewNetworkDataAdapter(List<Transaction> transactionList, Context context) {
      mTransactionList = transactionList;
      mContext = context;
   }
   
   @NonNull
   @Override
   public RecyclerViewNetworkDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      
      /*
        This function runs everytime this recyclerview is created.
        3 Steps to follow here.
        1. Create the View using LayoutInflator and inflate the single row view you custom created.
        2. Pass that view and give it to your custom ViewHolder you made (which mimic's the single row xml)
        3. return that ViewHolder object
         */
   
      OneRowTransactionBinding rowTransactionBinding = OneRowTransactionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      RecyclerViewNetworkDataHolder viewNetworkDataHolder = new RecyclerViewNetworkDataHolder(rowTransactionBinding);
   
      return viewNetworkDataHolder;
   }
   
   @Override
   public void onBindViewHolder(@NonNull RecyclerViewNetworkDataHolder holder, int position) {
   
      /*
        This function binds the data with the UI
        This has to be each UI element we want the coming data to be binded with.
         */
   
//      Glide.with(mContext)
//           .load(mTransactionList.get(position).getImage()).centerCrop()
//           .placeholder(R.drawable.ic_launcher_background).into(holder.mOneRowTransactionBinding.ivUserimage);
      holder.mOneRowTransactionBinding.tvTransactionName.setText(mTransactionList.get(position).getItemName());
      holder.mOneRowTransactionBinding.tvRefundAmount.setText(mTransactionList.get(position).getRefundAmt());
   }
   
   @Override
   public int getItemCount() {
      return mTransactionList.size();
   }
   
   static class RecyclerViewNetworkDataHolder extends RecyclerView.ViewHolder {
   
      /*
        ViewHolder is the one that has to mimic the custom one_row_view
        so that it can bind data to the respective UI elements.
        Since in our current case we have 2 TextViews, 1 ImageView and 1 TextView(shows time)
        we will create them here and map them to the xml layout.(unless we do viewBinding)
         */
      
      private final OneRowTransactionBinding mOneRowTransactionBinding;
      
      public RecyclerViewNetworkDataHolder(@NonNull OneRowTransactionBinding rowTransactionBinding) {
         super(rowTransactionBinding.getRoot());
         
         this.mOneRowTransactionBinding = rowTransactionBinding;
      }
   }
}
