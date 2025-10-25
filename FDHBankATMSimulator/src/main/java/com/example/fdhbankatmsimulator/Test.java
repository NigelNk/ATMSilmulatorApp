package com.example.fdhbankatmsimulator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("accounts.dat");
        ObjectInputStream ois = new ObjectInputStream(file);

        ArrayList<BankAccount> accounts = (ArrayList<BankAccount>) ois.readObject();
        for (BankAccount account : accounts) {
            System.out.println(account.getStageThreeData().getCardNumber() + " " + account.getStageThreeData().getPin());
        }


    }
}
