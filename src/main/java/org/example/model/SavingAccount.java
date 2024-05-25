package org.example.model;

import org.example.owner.TypeStrategy;

public class SavingAccount implements TypeStrategy {
    private final int acctNum;

    public SavingAccount(int acctNum) {
        this.acctNum = acctNum;
    }
    public double collateralRatio() {
        return 1.0 / 2.0;
    }


    public String accountType() {
        return "Savings";
    }

    public double interestRate() {
        return 0.01;
    }
    public int getAccNum() {
        return acctNum;
    }
    public int getBalance() {
        return 0;
    }
    public boolean isForeign() {
        return false;
    }
    public void setForeign(boolean isForeign) {

    }
    public void deposit(int amt) {

    }
    public boolean hasEnoughCollateral(int loanAmt) {
        return false;
    }
    public void addInterest() {

    }
    public int fee() {
        return 0;
    }
    public boolean isEmpty() {
        return TypeStrategy.super.isEmpty();
    }
    public int compareTo(BankAccount o) {
        return 0;
    }
}
