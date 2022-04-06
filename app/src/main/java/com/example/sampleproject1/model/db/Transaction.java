package com.example.sampleproject1.model.db;

public class Transaction {

    private String image;
    private String item_name;
    private String refund_amt;
    private String serial;
    private String description;
    private String refund_date;

    public Transaction(String image, String item_name, String refund_amt, String serial, String description, String refund_date) {
        this.image = image;
        this.item_name = item_name;
        this.refund_amt = refund_amt;
        this.serial = serial;
        this.description = description;
        this.refund_date = refund_date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getRefund_amt() {
        return refund_amt;
    }

    public void setRefund_amt(String refund_amt) {
        this.refund_amt = refund_amt;
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

    public String getRefund_date() {
        return refund_date;
    }

    public void setRefund_date(String refund_date) {
        this.refund_date = refund_date;
    }
}
