package org.example.model;

import org.example.owner.TypeStrategy;

public class InterestChecking extends CheckingAccount {
    private final double rate = 0.01;

    public InterestChecking(int accNum, TypeStrategy ts){
        super(accNum, ts);
    }

    protected String accountType() {
        return "Interest checking";
    }

    protected double interestRate() {
        return rate;
    }

    public String toString(){
        return "Interest checking account " + getAccNum()
                + ": balance = " + getBalance() + ", is"
                + (isForeign() ? "Foreign" : "Domestic");
    }
    public void addInterest(){
        int newBalance = (int) (getBalance() * rate);
        deposit(newBalance);
    }
}
