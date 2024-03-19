package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CompareSavingsAccounts {
    public static void main(String... args){
        ArrayList<SavingAccount> accts = initAccts();
        SavingAccount maxAcct1 = findMax(accts);
        SavingAccount maxAcct2 = Collections.max(accts);
        System.out.println("Account with largest balance is: " + maxAcct1);
        System.out.println("Account with largest balance is: " + maxAcct2);
    }
    public static ArrayList<SavingAccount> initAccts(){
        ArrayList<SavingAccount> accts = new ArrayList<>();
        accts.add(new SavingAccount(0));
        accts.get(0).deposit(100);
        accts.add(new SavingAccount(1));
        accts.get(1).deposit(200);
        accts.add(new SavingAccount(3));
        accts.get(2).deposit(50);
        return accts;
    }
    private static SavingAccount findMax(ArrayList<SavingAccount> a){
        SavingAccount  max = a.get(0);
        for (int i=1; i<a.size(); i++){
            if(a.get(i).compareTo(max) > 0){
                max = a.get(i);
            }
        }
        return max;
    }
}
