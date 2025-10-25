package com.example.fdhbankatmsimulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AccountViewController {
    @FXML
    public Label acountNumberLabel;
    @FXML
    public Label acountHolderLabel;
    @FXML
    public Label branchLabel;
    @FXML
    public Label atmLabel;

    @FXML
    protected void initialize() {
        ArrayList<BankAccount>  bankAccounts = (ArrayList<BankAccount>) AccountManager.loadAccounts();
        BankAccount account = bankAccounts.get(UseAtmController.loggedInUserIndex);

        String name = account.getStageThreeData().getStageTwoData().getStageOneData().getName();
        String atmNumber = account.getStageThreeData().getCardNumber();
        String branch = account.getStageThreeData().getStageTwoData().stageOneData.getCity() + " Branch";
        String accNumber = account.getAccountNumber();
        acountNumberLabel.setText(accNumber);
        acountHolderLabel.setText(name);
        atmLabel.setText(atmNumber);
        branchLabel.setText(branch);
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
