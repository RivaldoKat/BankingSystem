package org.example.controller;

import org.example.model.Bank;
import org.example.view.InputCommand;

import java.util.Scanner;

public class QuitCmd implements InputCommand {
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        boolean done = true;
        System.out.println("Goodbye!");
        return 0;
    }
}
