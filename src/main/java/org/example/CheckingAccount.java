package org.example;

public abstract class CheckingAccount extends AbstractBankAccount{
    private final double rate = 0.01;
    public CheckingAccount(int accNum) {
        super(accNum);
    }
    public boolean hasEnoughCollateral(int loanAmt){
        return balance >= 2 * loanAmt / 3;
    }
    public abstract void addInterest();
    public abstract String toString();
}
