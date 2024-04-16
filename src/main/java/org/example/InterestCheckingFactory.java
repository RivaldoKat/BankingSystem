package org.example;

public class InterestCheckingFactory implements AccountFactory {
    public BankAccount create(int acctNum){
        return new InterestChecking(acctNum, null);
    }
}
