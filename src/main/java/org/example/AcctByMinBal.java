package org.example;

import java.util.Comparator;

public class AcctByMinBal implements Comparator<BankAccount> {
    public int compare(BankAccount ba1, BankAccount ba2){
        int bal1 = ba1.getBalance();
        int bal2 = ba2.getBalance();
        if(bal1 == bal2){
            return ba1.getAccNum() - ba2.getAccNum();
        }else{
            return bal2 - bal1;
        }
    }
}
