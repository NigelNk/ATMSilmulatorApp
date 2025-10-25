package com.example.fdhbankatmsimulator;

import com.example.fdhbankatmsimulator.backend.AccountManager;
import com.example.fdhbankatmsimulator.backend.BankAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class WithdrawMoneyController {

    @FXML
    protected TextField amountField;

    @FXML
    protected void sevenBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "7");

    }

    @FXML
    protected void eightBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "8");

    }

    @FXML
    protected void nineBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "9");

    }

    @FXML
    protected void fourBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "4");

    }

    @FXML
    protected void fiveBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "5");

    }

    @FXML
    protected void sixBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "6");

    }

    @FXML
    protected void oneBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "1");
    }

    @FXML
    protected void twoBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "2");

    }

    @FXML
    protected void threeBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "3");

    }

    @FXML
    protected void zeroBtn(ActionEvent event) {
        amountField.setText(amountField.getText() + "0");
    }

    public void enterBtn(ActionEvent actionEvent) {
        ArrayList<BankAccount> bankAccounts = (ArrayList<BankAccount>) AccountManager.loadAccounts();
        BankAccount account = bankAccounts.get(UseAtmController.loggedInUserIndex);

        double amt = Integer.parseInt(amountField.getText());


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        if (amt < 0) {
            alert.setContentText("Enter a positive amount");
            alert.showAndWait();
        }
        else if (amt > account.getBalance()) {
            alert.setContentText("Sorry you have insufficient funds");
            alert.showAndWait();
        }
        else {
            account.withdraw(amt);
            TranscriptController.Transaction l = new TranscriptController.Transaction(LocalDateTime.now(), "ATM Withdraw", amt, 0.0, account.getBalance());

            TranscriptController.transactions.add(l);
            alert.setContentText("You have withdrawn " + amt + "Mk from your account");
            alert.showAndWait();
            amountField.setText("");
            AccountManager.saveAccounts(bankAccounts);
        }

    }

    public void backBtn(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("authorized-view.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelBtn(ActionEvent actionEvent) {
    }
}
