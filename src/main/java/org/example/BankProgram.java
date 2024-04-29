package org.example;

import org.example.bank.Bank;
import org.example.bank.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankProgram {
    public static void main(String... args){
        SavedBankInfo info = new SavedBankInfo("bank.info");
        Map<Integer, BankAccount> accounts = info.getAccounts();
        int nextAcc = info.nextAccNum();
        Bank bank = new Bank((HashMap<Integer, BankAccount>) accounts, nextAcc);
        Scanner scanner = new Scanner(System.in);
        BankClient client = new BankClient(scanner,bank);
        client.run();
        info.saveMap(accounts, info.nextAccNum());
    }
}