package org.example.factories;

import org.example.bank.BankAccount;

public interface AccountFactory {
    BankAccount create(int acctNum);
    static AccountFactory[] factories = AccountFactories.values();

    static BankAccount createAccount(int type, int acctNum){
        AccountFactory af = factories[type - 1];
        return af.create(acctNum);
    }
}
