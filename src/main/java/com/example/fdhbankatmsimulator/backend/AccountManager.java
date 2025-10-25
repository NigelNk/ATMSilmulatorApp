package com.example.fdhbankatmsimulator.backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static final String FILE_NAME = "accounts.dat";

    public static void saveAccounts(List<BankAccount> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
            System.out.println("✅ Accounts saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<BankAccount> loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<BankAccount>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public static void addAccount(BankAccount newAccount) {
        List<BankAccount> accounts = loadAccounts(); // Load old ones
        accounts.add(newAccount);                    // Add new
        saveAccounts(accounts);                      // Save all
    }
}
