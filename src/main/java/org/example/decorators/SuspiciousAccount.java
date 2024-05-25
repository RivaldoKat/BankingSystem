package org.example.decorators;

import org.example.model.BankAccount;

import java.util.Date;

public class SuspiciousAccount implements BankAccount {

    private final BankAccount ba;

    public SuspiciousAccount(BankAccount ba) {
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

    @Override
    public void setForeign(boolean isForeign) {
        isForeign = isForeign();
    }

    public void deposit(int amt) {
        Date d = new Date();
        String msg = "On " + d + " account #" + ba.getAccNum() +
                " deposited "  + amt;
        System.out.println(msg);
        ba.deposit(amt);
    }

    @Override
    public boolean hasEnoughCollateral(int loanAmt) {
        return ba.hasEnoughCollateral(loanAmt);
    }

    public String toString() {
        return "## " + ba.toString();
    }

    @Override
    public void addInterest() {
        ba.addInterest();
    }

    @Override
    public int fee() {
        return ba.fee();
    }

    @Override
    public int compareTo(BankAccount o) {
        return ba.compareTo(o);
    }
}
