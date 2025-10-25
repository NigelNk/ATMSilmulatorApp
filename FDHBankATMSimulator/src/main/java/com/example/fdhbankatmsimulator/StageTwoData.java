package com.example.fdhbankatmsimulator;

import java.io.Serializable;

public class StageTwoData implements Serializable {

    private String religion;
    private String category;
    private String income;
    private String education;
    private String occupation;
    private String panNumber;
    private boolean seniorCitizen;  // true if yes, false if no
    private boolean existingAccount; // true if yes, false if no
    StageOneData stageOneData;

    // Constructor
    public StageTwoData(String religion, String category, String income, String education,
                        String occupation, String panNumber, boolean seniorCitizen, boolean existingAccount, StageOneData stageOneData) {
        this.religion = religion;
        this.category = category;
        this.income = income;
        this.education = education;
        this.occupation = occupation;
        this.panNumber = panNumber;
        this.seniorCitizen = seniorCitizen;
        this.existingAccount = existingAccount;
        this.stageOneData = stageOneData;
    }

    public String getReligion() {
        return religion;
    }

    public String getCategory() {
        return category;
    }

    public String getIncome() {
        return income;
    }

    public String getEducation() {
        return education;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public boolean isSeniorCitizen() {
        return seniorCitizen;
    }

    public boolean isExistingAccount() {
        return existingAccount;
    }
    public  StageOneData getStageOneData() {
        return stageOneData;
    }
}
