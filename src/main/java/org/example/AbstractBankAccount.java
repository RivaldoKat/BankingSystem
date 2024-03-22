package org.example;

public abstract class AbstractBankAccount implements BankAccount{
    protected int accNum;
    protected int balance = 0;
    private OwnerStrategy owner = new Domestic();

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
        return owner.isForeign();
    }

    public void setForeign(boolean foreign) {
        owner = foreign ? new Foreign() : new Domestic();
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
    protected abstract double collateralRatio();
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
    protected abstract String accountType();
    protected abstract double interestRate();
}
