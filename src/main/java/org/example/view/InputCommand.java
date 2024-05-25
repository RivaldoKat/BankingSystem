package org.example.view;

import org.example.model.Bank;

import java.util.Scanner;

public interface InputCommand {
    int execute(Scanner sc, Bank bank, int current);
}
