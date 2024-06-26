package org.example;

public enum AccountFactories implements AccountFactory{
    SAVINGS("Savings", SavingAccount::new),
    REGULAR_CHECKING("Regular checking", acctNum -> new RegularChecking(acctNum, null)),
    INTEREST_CHECKING("Interest checking", acctNum -> new InterestChecking(acctNum, null));
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
