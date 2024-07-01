package org.example.decorators;

import org.example.model.BankAccount;

public abstract class BankAccountWrapper implements BankAccount {

    protected final BankAccount ba;

    protected BankAccountWrapper(BankAccount ba) {
        this.ba = ba;
    }

    @Override
    public int getAccNum() {
        return ba.getAccNum();
    }

    @Override
    public int getBalance() {
        return ba.getBalance();
    }

    @Override
    public boolean isForeign() {
        return ba.isForeign();
    }

    @Override
    public boolean hasEnoughCollateral(int loanAmt) {
        return ba.hasEnoughCollateral(loanAmt);
    }

    @Override
    public boolean isEmpty() {
        return ba.isEmpty();
    }

    @Override
    public int compareTo(BankAccount o) {
        return ba.compareTo(o);
    }
}
