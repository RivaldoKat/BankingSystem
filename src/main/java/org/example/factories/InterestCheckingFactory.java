package org.example.factories;

import org.example.bank.BankAccount;
import org.example.accounts.InterestChecking;

public class InterestCheckingFactory implements AccountFactory {
    public BankAccount create(int acctNum){
        return new InterestChecking(acctNum, null);
    }
}
