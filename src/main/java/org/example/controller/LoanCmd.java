package org.example.controller;

import org.example.model.Bank;
import org.example.view.InputCommand;

import java.util.Scanner;

public class LoanCmd implements InputCommand {
    @Override
    public int execute(Scanner sc, Bank bank, int current) {
        current = -1;
        System.out.print("Enter loan amount: ");
        int loanAmt = sc.nextInt();
        if(bank.authorizeLoan(current, loanAmt)){
            System.out.println("Your loan is approved");
        }else{
            System.out.println("Your loan is denied");
        }
        return current;
    }
}
