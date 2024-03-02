package org.example;

public class BankAccount {
    private int accnum;
    private int balance = 0;
    private boolean isForeign = false;

    public BankAccount(int accnum) {
        this.accnum = accnum;
    }

    public int getAccnum() {
        return accnum;
    }

    public void setAccnum(int accnum) {
        this.accnum = accnum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }
}
