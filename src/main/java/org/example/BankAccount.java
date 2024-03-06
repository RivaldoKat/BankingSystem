package org.example;

public interface BankAccount extends Comparable<BankAccount>{
    int getAccNum();
    int getBalance();
    boolean isForeign();
    void setForeign(boolean isForeign);
    void deposit(int amt);
    boolean hasEnoughCollateral(int loanAmt);
    String toString();
    void addInterest();
}
