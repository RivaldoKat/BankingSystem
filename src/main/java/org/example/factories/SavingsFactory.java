package org.example.factories;

import org.example.model.AbstractBankAccount;
import org.example.model.BankAccount;
import org.example.model.SavingAccount;
import org.example.owner.TypeStrategy;

public class SavingsFactory implements AccountFactory {
    public BankAccount create(int acctNum){
        TypeStrategy ts = new SavingAccount(acctNum);
        return new AbstractBankAccount(acctNum, ts);
    }
}
