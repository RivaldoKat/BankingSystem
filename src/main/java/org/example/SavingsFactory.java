package org.example;

public class SavingsFactory implements AccountFactory{
    public BankAccount create(int acctNum){
        return new SavingAccount(acctNum);
    }
}
