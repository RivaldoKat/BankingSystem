package org.example;

public class BankAccount {
    private int accnum;
    private int balance = 0;
    private boolean isForeign = false;
    private double rate = 0.01;

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

    public boolean hasEnoughCollateral(int amt){
        return balance >= amt / 2;
    }

    public void addInterest(){
        balance += (int) (balance * rate);
    }

    public String toString(){
        return "Bank account " + accnum + " : balance = "
                + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
}
