package com.example.fdhbankatmsimulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AccountBalanceController {
    @FXML
    private Label balanceLabel;
    @FXML
    protected void initialize() {
        ArrayList<BankAccount> bankAccounts = (ArrayList<BankAccount>) AccountManager.loadAccounts();
        BankAccount account = bankAccounts.get(UseAtmController.loggedInUserIndex);

        balanceLabel.setText("Mk " + String.valueOf(account.getBalance()));

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

}
