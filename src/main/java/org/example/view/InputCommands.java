package org.example.view;

import org.example.model.Bank;
import org.example.factories.AccountFactories;
import org.example.factories.AccountFactory;

import java.util.Scanner;

public enum InputCommands implements InputCommand {
    QUIT("quit", (sc, bank, current)->{
        sc.close();
        System.out.println("Goodbye");
        return -1;
    }),
    NEW("new", (sc, bank, current)->{
       printMessage();
       int type = sc.nextInt();
       boolean isForeign = requestForeign(sc);
       current = bank.newAccount(type, isForeign);
       System.out.println("Your new account is" + current);
       return current;
    }),
    SELECT("select", (sc, bank, current)->{
        System.out.print("Enter account#: ");
        current = sc.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account " + current
        + " is " + balance);
        return current;
    }),
    DEPOSIT("deposit", (sc, bank, current)->{
        System.out.print("Enter deposit amount: ");
        int amt = sc.nextInt();
        bank.deposit(current, amt);
        return current;
    }),
    LOAN("loan", (sc, bank, current)->{
        System.out.print("Enter loan amount: ");
        int amt = sc.nextInt();
        boolean ok = bank.authorizeLoan(current, amt);
        if(ok)
            System.out.println("Your loan is approved");
        else
            System.out.print("Your loan is denied");
        return current;
    }),
    SHOW("show", (sc, bank, current)->{
        System.out.println(bank.toString());
        return current;
    }),
    INTEREST("interest", (sc, bank, current)->{
        bank.addInterest();
        return current;
    }),
    SET_FOREIGN("setForeign", (sc, bank, current)->{
        bank.setForeign(current, requestForeign(sc));
        return current;
    });
    private final String name;
    private final InputCommand cmd;
    private InputCommands(String name, InputCommand cmd){
        this.name = name;
        this.cmd = cmd;
    }
    public int execute(Scanner sc, Bank bank, int current){
        return cmd.execute(sc, bank, current);
    }
    public String toString(){
        return name;
    }
    private static boolean requestForeign(Scanner sc){
        System.out.println("Enter 1 for foreign, 2 for domestic: ");
        int val = sc.nextInt();
        return (val == 1);
    }
    private static String message;
    static{
        AccountFactory[] factories = AccountFactories.values();
        message = "Enter Account Type (";
        for(int i = 0; i < factories.length - 1; i++)
            message += (i + 1) + "=" + factories[i] + ", ";
        message += factories.length + "="
                + factories[factories.length - 1] + ")";
    }
    private static void printMessage(){
        System.out.print(message);
    }
}
