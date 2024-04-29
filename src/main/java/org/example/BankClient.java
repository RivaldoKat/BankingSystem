package org.example;

import org.example.bank.Bank;
import org.example.commands.InputCommand;
import org.example.commands.InputCommands;

import java.util.Scanner;
public class BankClient {
    private int current = 0;
    private final Scanner scanner;
    private boolean done = false;
    private final Bank bank;
    private final InputCommand[] commands = InputCommands.values();
    public BankClient(Scanner scanner, Bank bank){
        this.scanner = scanner;
        this.bank = bank;
    }
    public void run(){
        String userMessage = constructMessage();
        while(!done){
            System.out.print(userMessage);
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }
    private String constructMessage(){
        int last = commands.length - 1;
        StringBuilder result = new StringBuilder("Enter Account Type (");
        for(int i =0; i < last; i++){
            result.append(i).append("=").append(commands[i]).append(", ");
        }
        result.append(last).append("=").append(commands[last]).append("):");
        return result.toString();
    }

    private void processCommand(int cnum){
        InputCommand cmd = commands[cnum];
        current = cmd.execute(scanner, bank, current);
        if(current < 0)
            done = true;
    }
    private void addInterest(){
        bank.addInterest();
    }

}
