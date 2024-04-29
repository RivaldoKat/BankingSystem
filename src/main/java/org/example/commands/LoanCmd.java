package org.example.commands;

import org.example.bank.Bank;

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
