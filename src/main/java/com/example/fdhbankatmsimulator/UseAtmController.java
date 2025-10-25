package com.example.fdhbankatmsimulator;

import com.example.fdhbankatmsimulator.backend.AccountManager;
import com.example.fdhbankatmsimulator.backend.BankAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UseAtmController {
    @FXML
    private TextField cardNumberField;
    @FXML
    private PasswordField pinField;

    static int changeField;
    public static int loggedInUserIndex;

    @FXML
    protected void accountNumberField(MouseEvent event) {
        changeField = 1;
    }
    @FXML
    protected void pinNumberField(MouseEvent event) {
        changeField = 2;
    }

    @FXML
    protected void sevenBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "7");
        }
        else {
            pinField.setText(pinField.getText() + "7");
        }

    }
    @FXML
    protected void eightBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "8");
        }
        else {
            pinField.setText(pinField.getText() + "8");
        }

    }
    @FXML
    protected void nineBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "9");
        }
        else {
            pinField.setText(pinField.getText() + "9");
        }

    }
    @FXML
    protected void fourBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "4");
        }
        else {
            pinField.setText(pinField.getText() + "4");
        }

    }
    @FXML
    protected void fiveBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "5");
        }
        else {
            pinField.setText(pinField.getText() + "5");
        }

    }
    @FXML
    protected void sixBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "6");
        }
        else {
            pinField.setText(pinField.getText() + "6");
        }

    }
    @FXML
    protected void oneBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "1");
        }
        else {
            pinField.setText(pinField.getText() + "1");
        }

    }
    @FXML
    protected void twoBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "2");
        }
        else {
            pinField.setText(pinField.getText() + "2");
        }

    }
    @FXML
    protected void threeBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "3");
        }
        else {
            pinField.setText(pinField.getText() + "3");
        }

    }
    @FXML
    protected void zeroBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText(cardNumberField.getText() + "0");
        }
        else {
            pinField.setText(pinField.getText() + "0");
        }

    }

    @FXML
    protected void clearBtn(ActionEvent event) {
        if (changeField == 1) {
            cardNumberField.setText("");
        }
        else {
            pinField.setText("");
        }
    }


    public void enterBtn(ActionEvent actionEvent) {
        if (pinField.getText().isEmpty() || cardNumberField.getText().isEmpty()) {
            Alert success = new Alert(Alert.AlertType.WARNING, "Please fill all fields");
            success.showAndWait();
        }
        else {
            ArrayList<BankAccount> bankAccounts = (ArrayList<BankAccount>) AccountManager.loadAccounts();
            String enteredCardNumber = cardNumberField.getText();
            String enteredPin = pinField.getText();

            boolean found = false;

            for (BankAccount bankAccount : bankAccounts) {
                if (bankAccount.getStageThreeData().getCardNumber().equals(enteredCardNumber) &&
                        bankAccount.getStageThreeData().getPin().equals(enteredPin)) {

                    found = true;
                    loggedInUserIndex = bankAccounts.indexOf(bankAccount);
                    // Load next page (Use authorize window)
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("authorized-view.fxml"));
                        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
                        Scene scene = new Scene(loader.load());
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break; // stop loop once match found
                }
            }

            if (!found) {
                Alert success = new Alert(Alert.AlertType.WARNING, "Invalid card number or PIN. Try again.");
                success.showAndWait();
            }
        }
    }

    public void backBtn(ActionEvent actionEvent) {
        try {
//            set the logged in use index to -2 to prevent unauthorized access
            UseAtmController.loggedInUserIndex = -2;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
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
