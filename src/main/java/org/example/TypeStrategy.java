package org.example;

public interface TypeStrategy extends BankAccount{
    double collateralRatio();
    String accountType();
    double interestRate();
}
