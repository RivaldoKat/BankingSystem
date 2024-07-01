package org.example;

import org.example.model.*;
import org.example.view.BankClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankProgram {
    public static void main(String... args){
        SavedBankInfo info = new SavedBankInfo("bank.info");
        Map<Integer, BankAccount> accounts = info.getAccounts();
        int nextAcc = info.nextAccNum();
        Bank bank = new Bank((HashMap<Integer, BankAccount>) accounts, nextAcc);
        BankObserver auditor = new Auditor(bank);
        bank.addObserver(BankEvent.DEPOSIT,
                (event, ba, amt) -> {
                    if (amt > 10000000)
                        bank.makeSuspicious(ba.getAccNum());
                });
        Scanner scanner = new Scanner(System.in);
        BankClient client = new BankClient(scanner,bank);
        client.run();
        info.saveMap(accounts, info.nextAccNum());
    }
}