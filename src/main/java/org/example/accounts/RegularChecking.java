package org.example.accounts;

import org.example.owner.TypeStrategy;

public class RegularChecking extends CheckingAccount {
    public RegularChecking(int accNum, TypeStrategy ts){
        super(accNum, ts);
    }
    protected String accountType() {
        return "Regular Checking";
    }
    protected double interestRate() {
        return 0.0;
    }
}
