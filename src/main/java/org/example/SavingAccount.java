package org.example;

public class SavingAccount implements TypeStrategy{
    @Override
    public double collateralRatio() {
        return 1.0 / 2.0;
    }

    @Override
    public String accountType() {
        return "Savings";
    }

    @Override
    public double interestRate() {
        return 0.01;
    }
}
