package com.example.myapplication.model;

public class Voucher {
    private String title;
    private String description;
    private int discount;

    public Voucher(String title, String description, int discount) {
        this.title = title;
        this.description = description;
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
