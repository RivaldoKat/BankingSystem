package org.example.decorators;

import org.example.model.BankAccount;

public class UnmodifiableAccount extends BankAccountWrapper{

    public UnmodifiableAccount(BankAccount ba) {
        super(ba);
    }

    public void deposit(int amt) {
        throw new UnsupportedOperationException();
    }

    public void addInterest() {
        throw new UnsupportedOperationException();
    }

    public void setForeign(boolean isForeign) {
        throw new UnsupportedOperationException();
    }

}
