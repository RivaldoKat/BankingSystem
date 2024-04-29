package org.example.bank;

import org.example.decorators.SuspiciousAccount;
import org.example.decorators.UnmodifiableBankIterator;
import org.example.factories.AccountFactory;

import java.util.HashMap;
import java.util.Iterator;


public class Bank implements Iterable<BankAccount>{
    private final HashMap<Integer, BankAccount> accounts;
    private int nextAcc;
    public Bank(HashMap<Integer, BankAccount> accounts, int n) {
        this.accounts = accounts;
        nextAcc = n;
    }
    public int newAccount(int type, boolean isForeign){
        int acctNum = nextAcc++;
        BankAccount ba = AccountFactory.createAccount(type,acctNum);
        ba.setForeign(isForeign);
        accounts.put(acctNum, ba);
        return acctNum;
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
    public void setForeign(int acctNum, boolean isForeign){
        BankAccount ba = accounts.get(acctNum);
        ba.setForeign(isForeign);
    }

    public String toString(){
        StringBuilder result = new StringBuilder("The bank has " + accounts.size() + " accounts.");
        for(BankAccount ba: accounts.values()){
            result.append("\n\t").append(ba.toString());
        }
        return result.toString();
    }
    public void addInterest(){
        for(BankAccount ba: accounts.values()){
            ba.addInterest();
        }
    }
    public Iterator<BankAccount> iterator(){
        Iterator<BankAccount> iter = accounts.values().iterator();
        return new UnmodifiableBankIterator(iter);
    }

    public void makeSuspicious(int acctNum) {
        BankAccount ba = accounts.get(acctNum);
        ba = new SuspiciousAccount(ba);
        accounts.put(acctNum, ba);
    }
}
