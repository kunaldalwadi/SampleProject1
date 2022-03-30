package com.example.sampleproject1.model.db;

import androidx.databinding.BaseObservable;

public class Transaction {//extends BaseObservable {
    
    private String image;
    private String itemName;
    private String refundAmt;
    private String serial;
    private String description;
    private String refundDate;
    
    public Transaction(String image, String itemName, String refundAmt, String serial, String description, String refundDate) {
        this.image = image;
        this.itemName = itemName;
        this.refundAmt = refundAmt;
        this.serial = serial;
        this.description = description;
        this.refundDate = refundDate;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public String getRefundAmt() {
        return refundAmt;
    }
    
    public void setRefundAmt(String refundAmt) {
        this.refundAmt = refundAmt;
    }
    
    public String getSerial() {
        return serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getRefundDate() {
        return refundDate;
    }
    
    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }
}
