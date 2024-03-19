package org.example;

public class RegularChecking extends CheckingAccount{
    public RegularChecking(int accNum){
        super(accNum);
    }
    protected String accountType() {
        return "Regular Checking";
    }
    protected double interestRate() {
        return 0.0;
    }
}
