package com.example.model;

public class Purchase {
    private String purchaseDetails;
    private double amount;

    //Getters and Setters
    public String getPurchaseDetails() {
        return purchaseDetails;
    }
    public double getAmount() {
        return amount;
    }

    //construtor
    public Purchase(String purchaseDetails, double amount) {
        this.purchaseDetails = purchaseDetails;
        this.amount = amount;
    }
}
