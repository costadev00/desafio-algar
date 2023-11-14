package com.example.model;

public class User {
    private String name;
    private String cpf;
    private String email;
    private double balance;

    //Getters and Setters
    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public double getBalance() {
        return balance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //construtor
    public User(String name, String cpf, String email, double balance) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.balance = balance;
    }
}
