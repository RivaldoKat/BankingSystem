package org.example;

import java.util.Scanner;

public class NewAccountCmd implements InputCommand{
    public int execute(Scanner sc, Bank bank, int current){
        System.out.println("Enter account type(1=savings, 2=checking, 3=interesting checking)");
        boolean isForeign = true;
        int type = sc.nextInt();
        current = bank.newAccount(type, isForeign);
        System.out.println("Your new account is " + current);
        return current;
    }
}
