package org.example.controller;

import org.example.model.Bank;
import org.example.view.InputCommand;

import java.util.Scanner;

public enum SelectCmd implements InputCommand {
    INSTANCE;
    public int execute(Scanner sc, Bank bank, int current){
        System.out.print("Enter account#: ");
        current = sc.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account " + current + " is " + balance);
        return balance;
    }
    public String toString(){
        return "Select";
    }
}
