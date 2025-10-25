package com.example.fdhbankatmsimulator.backend;

import java.io.Serializable;

public class StageThreeData implements Serializable {

    private String pin;
    private String accountTypeToggle;
    private String cardNumber;
    private StageTwoData stageTwoData;

    public StageThreeData(String cardNumber, String pin, String accountTypeToggle, StageTwoData stageTwoData) {
        this.pin = pin;
        this.accountTypeToggle = accountTypeToggle;
        this.cardNumber = cardNumber;
        this.stageTwoData = stageTwoData;
    }

    public String getPin() {
        return pin;
    }

    public String getAccountTypeToggle() {
        return accountTypeToggle;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public StageTwoData getStageTwoData() {
        return stageTwoData;
    }

}
