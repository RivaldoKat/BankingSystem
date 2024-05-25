package org.example.model;

import org.example.factories.AccountFactories;
import org.example.factories.AccountFactory;

public interface BankAccount extends Comparable<BankAccount>{
    int getAccNum();
    int getBalance();
    boolean isForeign();
    void setForeign(boolean isForeign);
    void deposit(int amt);
    boolean hasEnoughCollateral(int loanAmt);
    String toString();
    void addInterest();
    int fee();
    static BankAccount createSavingsWithDeposit(int accNum, int n){
        AccountFactory af = AccountFactories.SAVINGS;
        BankAccount ba = af.create(accNum);
        ba.deposit(n);
        return ba;
    }
    default boolean isEmpty(){
        return getBalance() == 0;
    }
}
