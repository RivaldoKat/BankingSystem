package org.example.decorators;

import org.example.model.BankAccount;

import java.util.Iterator;

public class UnmodifiableBankIterator implements Iterator<BankAccount>{

    private final Iterator<BankAccount> iter;

    public UnmodifiableBankIterator(Iterator<BankAccount> iter) {
        this.iter = iter;
    }

    public boolean hasNext() {
        return iter.hasNext();
    }

    public BankAccount next() {
        BankAccount ba = iter.next();
        return new UnmodifiableAccount(ba);
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
