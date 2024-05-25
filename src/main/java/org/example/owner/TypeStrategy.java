package org.example.owner;

import org.example.model.BankAccount;

public interface TypeStrategy extends BankAccount {
    double collateralRatio();
    String accountType();
    double interestRate();
}
