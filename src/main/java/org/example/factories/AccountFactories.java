package org.example.factories;

import org.example.model.BankAccount;
import org.example.model.InterestChecking;
import org.example.model.RegularChecking;
import org.example.model.SavingAccount;

public enum AccountFactories implements AccountFactory{
    SAVINGS("Savings", SavingAccount::new),
    REGULAR_CHECKING("Regular checking", acctNum -> new RegularChecking(acctNum, null)),
    INTEREST_CHECKING("Interest checking", acctNum -> new InterestChecking(acctNum, null)),
    NEW_CUSTOMER("New Customer Savings", acctNum -> {
       BankAccount result = new SavingAccount(acctNum);
       result.deposit(1000);
       return result;
    });
    private final String name;
    private final AccountFactory af;
    private AccountFactories(String name, AccountFactory af){
        this.name = name;
        this.af = af;
    }
    public BankAccount create(int acctNum){
        return af.create(acctNum);
    }
    public String toString(){
        return name;
    }
}
