package org.example.commands;

import org.example.bank.Bank;

import java.util.Scanner;

public class RequestCmd implements InputCommand {
    public int execute(Scanner sc, Bank bank, int current){
        System.out.println("Enter 1 for foreign, 2 for domestic: ");
        current = sc.nextInt();
        return current;
    }
}
