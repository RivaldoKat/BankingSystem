package org.example;

import java.util.Scanner;

public class SetIsForeignCmd implements InputCommand{
    OwnerStrategy owner = new Foreign();
    public int execute(Scanner sc, Bank bank, int current){
        current = -1;
        bank.setForeign(current, owner.isForeign());
        return current;
    }
}
