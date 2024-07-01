package org.example.decorators;

import java.util.Random;

public class GoodCustomerAuthorizer extends AuthorizeWrapper{

    private final boolean isGood;

    public GoodCustomerAuthorizer(LoanAuthorizer auth) {
        super(auth);
        Random random = new Random();
        isGood = random.nextBoolean();
    }

    public boolean authorizeLoan(int amt) {
        if (isGood && amt < 200000)
            return true;
        else
            return auth.authorizeLoan(amt);
    }
}
