package org.example;

public class SavingAccount implements BankAccount{
    private int accNum;
    private int balance = 0;
    private boolean isForeign = false;
    private double rate = 0.01;
    private int type;

    public SavingAccount(int accNum) {
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

    public boolean hasEnoughCollateral(int amt){
        return balance >= amt / 2;
    }

    public void addInterest(){
        balance += (int) (balance * rate);
    }
    public int compareTo(BankAccount ba){
        int bal1 = getBalance();
        int bal2 = ba.getBalance();
        if (bal1 == bal2){
            return getAccNum() - ba.getAccNum();
        }else {
            return bal1 - bal2;
        }
    }
    public String toString(){
        
        return "Savings account " + accNum + " : balance = "
                + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
}
