package com.example.fdhbankatmsimulator.backend;

public class FixedDepositAccount extends BankAccount{
    public FixedDepositAccount(StageThreeData stageThreeData, double balance, String accountNumber) {
        super(stageThreeData, balance, accountNumber);
    }
}
