package org.example.decorators;

public class AuthorizeWrapper implements LoanAuthorizer {

    protected final LoanAuthorizer auth;

    protected AuthorizeWrapper(LoanAuthorizer auth) {
        this.auth = auth;
    }

    @Override
    public boolean authorizeLoan(int amt) {
        return auth.authorizeLoan(amt);
    }
}
