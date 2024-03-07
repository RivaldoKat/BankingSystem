package org.example;

public class SavingAccount extends AbstractBankAccount{
    private double rate = 0.01;
    public SavingAccount(int accNum){
        super(accNum);
    }
    public boolean hasEnoughCollateral(int loanAmt){
        return balance >= loanAmt / 2;
    }
    public void addInterest() {
        balance += (int) (balance * rate);
    }
    public String toString() {
        return "Savings account " + accNum + " : balance = "
                + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
}
