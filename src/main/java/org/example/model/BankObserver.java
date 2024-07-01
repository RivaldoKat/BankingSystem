package org.example.model;

public interface BankObserver {
    void update(BankEvent e,BankAccount ba, int depositAmt);
}
