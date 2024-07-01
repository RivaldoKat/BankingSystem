package org.example.decorators;

import org.example.model.BankAccount;

public class CollateralAuthorizer implements LoanAuthorizer{

    private final BankAccount ba;

    public CollateralAuthorizer(BankAccount ba) {
        this.ba = ba;
    }

    @Override
    public boolean authorizeLoan(int amt) {
        return ba.hasEnoughCollateral(amt);
    }
}
