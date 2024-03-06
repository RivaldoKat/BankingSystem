package org.example;

public class CheckingAccount implements BankAccount{
    private int accNum;
    private int balance = 0;
    private boolean isForeign = false;
    public CheckingAccount (int accNum) {
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
       return  balance >= 2 * amt / 3;
    }
    public void addInterest(){
        // do nothing
    };
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
        return "Checking account " + accNum + " : balance = "
                + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
}
