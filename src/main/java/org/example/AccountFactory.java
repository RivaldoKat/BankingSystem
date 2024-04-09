package org.example;

public interface AccountFactory {
    static BankAccount createSavings(int acctNum){
        return new SavingAccount(acctNum);
    }
}
