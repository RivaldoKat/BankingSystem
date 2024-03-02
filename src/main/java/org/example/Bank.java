package org.example;

import java.util.HashMap;


public class Bank {
    private HashMap<Integer, BankAccount> accounts;
    private int nextacct;
    public Bank(HashMap<Integer, BankAccount> accounts, int n) {
        this.accounts = accounts;
        nextacct = n;
    }
    public int newAccount(boolean isForeign){
        int acctnum = nextacct++;
        BankAccount ba = new BankAccount(acctnum);
        ba.setForeign(isForeign);
        accounts.put(acctnum, ba);
        return acctnum;
    }
    public int getBalance(int acctNum){
        BankAccount ba = accounts.get(acctNum);
        return ba.getBalance();
    }
    public void deposit(int acctNum, int amt){
        BankAccount ba = accounts.get(acctNum);
        ba.deposit(amt);
    }
    public boolean authorizeLoan(int acctNum, int loanAmt){
        BankAccount ba = accounts.get(acctNum);

        return ba.hasEnoughCollateral(loanAmt);
    }
    public void setForeign(int acctnum, boolean isForeign){
        BankAccount ba = accounts.get(acctnum);
        ba.setForeign(isForeign);
    }

    public String toString(){
        String result = "The bank has " + accounts.size() + " acounts.";
        for(BankAccount ba: accounts.values()){
            result += "\n\t" + ba.toString();
        }
        return result;
    }
    public void addInterest(){
        for(BankAccount ba: accounts.values()){
            ba.addInterest();
        }
    }
}
