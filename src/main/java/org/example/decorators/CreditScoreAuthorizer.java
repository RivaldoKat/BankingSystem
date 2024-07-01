package org.example.decorators;

import java.util.Random;

public class CreditScoreAuthorizer extends AuthorizeWrapper{

    private final int score;

    public CreditScoreAuthorizer(LoanAuthorizer auth) {
        super(auth);

        Random random = new Random();

        this.score = 300 + random.nextInt(500);
    }

    public boolean authorizeLoan(int amt) {

        if(score > 700 && amt < 10000)
            return true;
        else if (score < 500)
            return false;
        else
            return auth.authorizeLoan(amt);
    }
}
