package org.example.accounts;

import org.example.bank.AbstractBankAccount;
import org.example.owner.TypeStrategy;

public abstract class CheckingAccount extends AbstractBankAccount {
    private final double rate = 0.01;
    public CheckingAccount(int accNum, TypeStrategy ts) {
        super(accNum, ts);
    }
    public double collateralRatio() {
        return 2.0 / 3.0;
    }
    protected abstract String accountType();
    protected abstract double interestRate();
}
