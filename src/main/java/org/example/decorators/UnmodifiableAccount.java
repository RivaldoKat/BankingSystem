package org.example.decorators;

import org.example.model.BankAccount;

public class UnmodifiableAccount implements BankAccount {
    private final BankAccount ba;
    
    public UnmodifiableAccount(BankAccount ba) {
        this.ba = ba;
    }
    
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

    public void deposit(int amt) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasEnoughCollateral(int loanAmt) {
        return ba.hasEnoughCollateral(loanAmt);
    }

    public void addInterest() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int fee() {
        return ba.fee();
    }

    public void setForeign(boolean isForeign) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int compareTo(BankAccount o) {
        return ba.compareTo(o);
    }
}
