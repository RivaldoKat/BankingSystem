package org.example.factories;

import org.example.bank.BankAccount;
import org.example.accounts.RegularChecking;

public class RegularCheckingFactory implements AccountFactory{
    public BankAccount create(int acctNum){
        return new RegularChecking(acctNum,null);
    }
}
