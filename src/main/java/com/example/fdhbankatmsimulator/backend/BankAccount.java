package com.example.fdhbankatmsimulator.backend;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private StageThreeData stageThreeData;
    private String accountNumber;
    private double balance;

    public BankAccount(StageThreeData stageThreeData, double balance, String accountNumber) {
        this.stageThreeData = stageThreeData;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public StageThreeData getStageThreeData() {
        return stageThreeData;
    }
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public void deposit(double amount) {
        if  (amount > 0) {
            balance += amount;
        }

    }
    public void withdraw(double amount) {
        if (!(amount > balance)) {
            if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
            balance -= amount;
        }
    }
}

