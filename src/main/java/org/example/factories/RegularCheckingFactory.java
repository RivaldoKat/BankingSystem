package org.example.factories;

import org.example.model.BankAccount;
import org.example.model.RegularChecking;

public class RegularCheckingFactory implements AccountFactory{
    public BankAccount create(int acctNum){
        return new RegularChecking(acctNum,null);
    }
}
