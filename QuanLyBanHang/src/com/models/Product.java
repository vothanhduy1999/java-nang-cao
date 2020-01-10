package com.models;

public class Product {
    private  int ID;
    private  String fullName;
    private  int amount;

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    private  int prices;

    public Product() {
    }

    public Product(int ID, String fullName, int amount, int prices) {
        this.ID = ID;
        this.fullName = fullName;
        this.amount = amount;
        this.prices = prices;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
