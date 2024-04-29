package org.example.commands;

import org.example.bank.Bank;

import java.util.Scanner;

public interface InputCommand {
    int execute(Scanner sc, Bank bank, int current);
}
