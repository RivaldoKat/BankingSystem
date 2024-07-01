package org.example.decorators;

import org.example.model.BankAccount;

public interface LoanAuthorizer {

    boolean authorizeLoan(int amt);

    static LoanAuthorizer getAuthorizer(BankAccount ba) {
        LoanAuthorizer auth = new CollateralAuthorizer(ba);
        auth = new CreditScoreAuthorizer(auth);
        return new GoodCustomerAuthorizer(auth);
    }

}