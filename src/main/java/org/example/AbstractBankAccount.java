package org.example;

public abstract class AbstractBankAccount implements BankAccount{
    protected int accNum;
    protected int balance = 0;
    protected boolean isForeign = false;

    protected AbstractBankAccount(int accNum){
        this.accNum = accNum;
    }
    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public int getBalance() {
        return (int) balance;
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

    public void deposit(int amt){
        balance += amt;
    }

    public int compareTo(BankAccount ba) {
        int bal1 = getBalance();
        int bal2 = ba.getBalance();
        if (bal1 == bal2) {
            return getAccNum() - ba.getAccNum();
        } else {
            return bal1 - bal2;
        }
    }
    public boolean equals(Object obj){
        if(! (obj instanceof BankAccount)){
            return false;
        }
        BankAccount ba = (BankAccount) obj;
        return getAccNum() == ba.getAccNum();
    }
    public abstract boolean hasEnoughCollateral(int loanAmt);
    public abstract String toString();
    public abstract void addInterest();
}
