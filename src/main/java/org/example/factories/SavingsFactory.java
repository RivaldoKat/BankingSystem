package org.example.factories;

import org.example.bank.AbstractBankAccount;
import org.example.bank.BankAccount;
import org.example.accounts.SavingAccount;
import org.example.owner.TypeStrategy;

public class SavingsFactory implements AccountFactory {
    public BankAccount create(int acctNum){
        TypeStrategy ts = new SavingAccount(acctNum);
        return new AbstractBankAccount(acctNum, ts);
    }
}
