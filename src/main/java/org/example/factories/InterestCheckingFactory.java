package org.example.factories;

import org.example.model.BankAccount;
import org.example.model.InterestChecking;

public class InterestCheckingFactory implements AccountFactory {
    public BankAccount create(int acctNum){
        return new InterestChecking(acctNum, null);
    }
}
