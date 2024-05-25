package org.example.controller;

import org.example.model.Bank;
import org.example.view.InputCommand;

import java.util.Scanner;

public class RequestCmd implements InputCommand {
    public int execute(Scanner sc, Bank bank, int current){
        System.out.println("Enter 1 for foreign, 2 for domestic: ");
        current = sc.nextInt();
        return current;
    }
}
