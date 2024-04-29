package org.example.bank;

import org.example.owner.OwnerStrategy;
import org.example.owner.Owners;
import org.example.owner.TypeStrategy;

public class AbstractBankAccount implements BankAccount {
    protected int accNum;
    protected int balance = 0;
    private OwnerStrategy owner = Owners.DOMESTIC;
    private final TypeStrategy ts;

    public AbstractBankAccount(int accNum, TypeStrategy ts){
        this.accNum = accNum;
        this.ts = ts;

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
        return owner.isForeign();
    }

    public void setForeign(boolean foreign) {
        owner = foreign ? Owners.FOREIGN : Owners.DOMESTIC;
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
    public boolean hasEnoughCollateral(int loanAmt){
        double ratio = collateralRatio();
        return balance >= loanAmt * ratio;
    }
    private double collateralRatio(){
     return ts.collateralRatio();
    }
    public String toString() {
        String accType = accountType();
        return accType + " account " + accNum + " : balance = "
                + balance + ", is "
                + owner.toString() + ", fee=" + fee();
    }
    public void addInterest(){
        balance += (int) (balance * interestRate());
    }
    public int fee(){
       return owner.fee();
    }
    private String accountType(){
        return ts.accountType();
    }
    protected double interestRate(){
        return ts.interestRate();
    }
}
