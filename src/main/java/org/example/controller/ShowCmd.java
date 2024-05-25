package org.example.controller;

import org.example.model.Bank;
import org.example.view.InputCommand;

import java.util.Scanner;

public class ShowCmd implements InputCommand {
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        System.out.println(bank.toString());
        return 0;
    }
}
