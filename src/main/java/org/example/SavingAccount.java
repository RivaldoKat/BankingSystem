package org.example;

public class SavingAccount extends AbstractBankAccount{
    private double rate = 0.01;
    public SavingAccount(int accNum){
        super(accNum);
    }
    protected double collateralRatio() {
        return 1.0 * 2.0;
    }
    public void addInterest() {
        balance += (int) (balance * rate);
    }
    public String accountType(){
        return "Savings";
    }
    public double interestRate() {
        return 0.01;
    }
}
