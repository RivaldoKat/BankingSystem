package org.example;

public class InterestChecking extends CheckingAccount{
    private final double rate = 0.01;

    public InterestChecking(int accNum){
        super(accNum);
    }
    public String toString(){
        return "Interest checking account " + getAccNum()
                + ": balance = " + getBalance() + ", is"
                + (isForeign() ? "Foreign" : "Domestic");
    }
    public void addInterest(){
        int newBalance = (int) (getBalance() * rate);
        deposit(newBalance);
    }
}
