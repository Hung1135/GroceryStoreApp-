package com.example.myapplication.model;

public class CartItem {

    private int imageResId;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private boolean selected;

    public CartItem(int imageResId, String name, String category, double price, int quantity, boolean selected) {
        this.imageResId = imageResId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.selected = selected;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}