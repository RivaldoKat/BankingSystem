package org.example.model;

public class Auditor implements BankObserver{
    public Auditor(Bank bank) {
        bank.addObserver(BankEvent.NEW, this);
        bank.addObserver(BankEvent.SetFOREIGN, this);
    }

    public void update(BankEvent e, BankAccount ba, int depositAmt) {
        if (ba.isForeign()) {
            if ( e == BankEvent.NEW)
                System.out.println("New foreign account: " + ba.getAccNum());
            else
                System.out.print("Modified foreign account: " + ba.getAccNum());
        }
    }
}
