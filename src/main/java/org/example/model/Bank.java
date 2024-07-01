package org.example.model;

import org.example.decorators.LoanAuthorizer;
import org.example.decorators.SuspiciousAccount;
import org.example.decorators.UnmodifiableBankIterator;
import org.example.factories.AccountFactory;

import java.util.*;


public class Bank implements Iterable<BankAccount>{
    private final HashMap<Integer, BankAccount> accounts;
    private int nextAcc;
    private final Map<BankEvent, List<BankObserver>> observers = new HashMap<>();

    public Bank(HashMap<Integer, BankAccount> accounts, int n) {
        this.accounts = accounts;
        nextAcc = n;
        for (BankEvent e: BankEvent.values())
            observers.put(e, new ArrayList<BankObserver>());
    }

    public void addObserver(BankEvent e, BankObserver obs) {
        observers.get(e).add(obs);
    }

    public void notifyObserver(BankEvent e, BankAccount ba, int depositAmt) {
        for (BankObserver obs: observers.get(e))
            obs.update(e, ba, depositAmt);
    }
    public void removeObserver(BankObserver obs) {
        observers.remove(obs);
    }
    public int newAccount(int type, boolean isForeign){
        int acctNum = nextAcc++;
        BankAccount ba = AccountFactory.createAccount(type,acctNum);
        ba.setForeign(isForeign);
        accounts.put(acctNum, ba);
        notifyObserver(BankEvent.NEW, ba, 0);
        return acctNum;
    }
    public int getBalance(int acctNum){
        BankAccount ba = accounts.get(acctNum);
        return ba.getBalance();
    }
    public void deposit(int acctNum, int amt){
        BankAccount ba = accounts.get(acctNum);
        ba.deposit(amt);
        notifyObserver(BankEvent.DEPOSIT, ba, 0);
    }
    public boolean authorizeLoan(int acctNum, int loanAmt){
        BankAccount ba = accounts.get(acctNum);
        LoanAuthorizer auth = LoanAuthorizer.getAuthorizer(ba);
        return auth.authorizeLoan(loanAmt);
    }
    public void setForeign(int acctNum, boolean isForeign){
        BankAccount ba = accounts.get(acctNum);
        ba.setForeign(isForeign);
        notifyObserver(BankEvent.SetFOREIGN, ba, 0);
    }

    public String toString(){
        StringBuilder result = new StringBuilder("The bank has " + accounts.size() + " accounts.");
        for(BankAccount ba: accounts.values()){
            result.append("\n\t").append(ba.toString());
        }
        return result.toString();
    }
    public void addInterest(){
        forEach(BankAccount::addInterest);
        notifyObserver(BankEvent.INTEREST, null, 0);

    }
    public Iterator<BankAccount> iterator(){
        Iterator<BankAccount> iter = accounts.values().iterator();
        return new UnmodifiableBankIterator(iter);
    }

    public void makeSuspicious(int acctNum) {
        BankAccount ba = accounts.get(acctNum);
        ba = new SuspiciousAccount(ba);
        accounts.put(acctNum, ba);
    }
}
