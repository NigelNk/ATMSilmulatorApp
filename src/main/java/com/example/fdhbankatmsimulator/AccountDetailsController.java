package com.example.fdhbankatmsimulator;

import com.example.fdhbankatmsimulator.backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AccountDetailsController {
    @FXML
    public Label accountNumberLabel;
    @FXML
    public Label pinLabel;
    @FXML
    private RadioButton savingAccount, currentAccount;

    private ToggleGroup accountTypeGroup;
    @FXML
    private Label formNoLabel;

    static ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public void setFormNumber(String formNo) {
        formNoLabel.setText(formNo);
    }


    @FXML
    private void initialize() {
        accountTypeGroup = new ToggleGroup();
        savingAccount.setToggleGroup(accountTypeGroup);
        currentAccount.setToggleGroup(accountTypeGroup);

        //        Create random account number and pin for the user
        Random rand = new Random();
        String accountNumber = 10002025 + "" +  rand.nextInt(10000);

        int pin = new java.util.Random().nextInt(10000);
        String pinString = String.format("%04d", pin);
        pinLabel.setText(pinString);
        accountNumberLabel.setText(accountNumber);
    }

    @FXML
    private void handleSubmit(ActionEvent event) throws IOException {
        // Get selected RadioButton
        RadioButton selectedRadio = (RadioButton) accountTypeGroup.getSelectedToggle();
        String accountType = selectedRadio.getText();


        String pin = pinLabel.getText();
        String cardNumber = accountNumberLabel.getText();

        // Create the StageThreeData object
        StageThreeData stageThreeData = new StageThreeData(cardNumber, pin, accountType, BankFormPage2Controller.stageTwoDataList[0]);

        Random rand = new Random();
        int f = new java.util.Random().nextInt(10000);
        String fString = String.format("%04d", (f+1));

//        account numbers based on types
        String savingsAccount = "1 001 987654"+fString;

        String currentAccount = "001 9"+ "0332" + fString;

        String fixedDeposit = "2001 9 332" +  fString;

//        give each created account a total amount of 10,000 as the account balance

//        Check the selected account type

        if (selectedRadio.getText().equals("Savings Account")) {
            BankAccount savings = new SavingsAccount(stageThreeData, 10000, savingsAccount);
            AccountManager.addAccount(savings);
            showSuccess("Savings");
        }
        else if (selectedRadio.getText().equals("Current Account")) {
            BankAccount current = new CurrentAccount(stageThreeData, 10000, currentAccount);
            AccountManager.addAccount(current);
            showSuccess("Current");
        }

        else if (selectedRadio.getText().equals("Fixed Deposit Account")) {
            BankAccount fixed = new FixedDepositAccount(stageThreeData, 10000, fixedDeposit);
            AccountManager.addAccount(fixed);
            showSuccess("Fixed Deposit");
        }


        // Load next page (Use ATM Window)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("use-atm-view.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private void handleCancel(ActionEvent event) {
        System.exit(0);
    }

    public void backBtn(ActionEvent actionEvent) {
    }

    public void cancelBtn(ActionEvent actionEvent) {
    }

    public void enterBtn(ActionEvent actionEvent) {
    }

    private void showSuccess(String type) {
        Alert success = new Alert(Alert.AlertType.INFORMATION, type + " Account Created successfully");
        success.showAndWait();
    }
}

