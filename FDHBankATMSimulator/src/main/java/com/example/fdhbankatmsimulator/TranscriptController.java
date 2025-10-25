package com.example.fdhbankatmsimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TranscriptController {

    @FXML private Label lblAccountName;
    @FXML private Label lblAccountNumber;
    @FXML private Label lblDate;

    @FXML private TableView<Transaction> transactionsTable;
    @FXML private TableColumn<Transaction, String> colDate;
    @FXML private TableColumn<Transaction, String> colDescription;
    @FXML private TableColumn<Transaction, Double> colDebit;
    @FXML private TableColumn<Transaction, Double> colCredit;
    @FXML private TableColumn<Transaction, Double> colBalance;

    static ArrayList<Transaction> transactions = new ArrayList<>();

    @FXML
    public void initialize() {

        ArrayList<BankAccount>  bankAccounts = (ArrayList<BankAccount>) AccountManager.loadAccounts();
        BankAccount account = bankAccounts.get(UseAtmController.loggedInUserIndex);

        String name = account.getStageThreeData().getStageTwoData().getStageOneData().getName();
        String atmNumber = account.getStageThreeData().getCardNumber();
        String branch = account.getStageThreeData().getStageTwoData().stageOneData.getCity() + " Branch";
        String accNumber = account.getAccountNumber();
        lblAccountNumber.setText("Account Number: " + accNumber);
        lblAccountName.setText("Account Holder: " + name);
        lblDate.setText("Date: " + LocalDate.now());

        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDebit.setCellValueFactory(new PropertyValueFactory<>("debit"));
        colCredit.setCellValueFactory(new PropertyValueFactory<>("credit"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));

        ObservableList<Transaction> transactionList = FXCollections.observableArrayList(transactions);

        transactionsTable.setItems(transactionList);
    }

    // Transaction class
    public static class Transaction {
        private final LocalDateTime date;
        private final String description;
        private final double debit;
        private final double credit;
        private final double balance;

        public Transaction(LocalDateTime date, String description, double debit, double credit, double balance) {
            this.date = date;
            this.description = description;
            this.debit = debit;
            this.credit = credit;
            this.balance = balance;
        }

        public LocalDateTime getDate() { return date; }
        public String getDescription() { return description; }
        public double getDebit() { return debit; }
        public double getCredit() { return credit; }
        public double getBalance() { return balance; }
    }
}

