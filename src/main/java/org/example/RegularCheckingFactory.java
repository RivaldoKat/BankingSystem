package org.example;

public class RegularCheckingFactory implements AccountFactory{
    public BankAccount create(int acctNum){
        return new RegularChecking(acctNum,null);
    }
}
