package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorBankAccounts {
    public static void main(String... args){
        List<BankAccount> accts = initAccts();
        Comparator<BankAccount> minbal = new AcctByMinBal();
        Comparator<BankAccount> maxbal = innerClassComp();
        Comparator<BankAccount> minnum = lambdaExpComp1();
        Comparator<BankAccount> maxnum = lambdaExpComp2();

        BankAccount a1 = findMax(accts, minbal);
        BankAccount a2 = findMax(accts, maxbal);
        BankAccount a3 = Collections.max(accts, minnum);
        BankAccount a4 = Collections.max(accts, maxnum);

        System.out.println("Acct with smallest bal is " + a1);
        System.out.println("Acct with largest bal is " + a2);
        System.out.println("Acct with smallest num is " + a3);
        System.out.println("Acct with largest num is " + a4);
    }
    public static ArrayList<BankAccount> initAccts(){
        ArrayList<BankAccount> accts = new ArrayList<>();
        accts.add(new SavingAccount(0));
        accts.get(0).deposit(100);
        accts.add(new SavingAccount(1));
        accts.get(1).deposit(200);
        accts.add(new SavingAccount(3));
        accts.get(2).deposit(50);
        return accts;
    }
    private static BankAccount findMax(List<BankAccount> a, Comparator<BankAccount> cmp){
        BankAccount max = a.get(0);
        for(int i = 1; i < a.size(); i++){
            if(cmp.compare(a.get(i), max) > 0){
                max = a.get(i);
            }
        }
        return max;
    }
    private static Comparator<BankAccount> innerClassComp(){
        Comparator<BankAccount> result = new Comparator<BankAccount>() {
            @Override
            public int compare(BankAccount ba1, BankAccount ba2) {
                int bal1 = ba1.getBalance();
                int bal2 = ba2.getBalance();
                if(bal1 == bal2){
                    return ba1.getAccNum() - ba2.getAccNum();
                }else{
                    return bal1 - bal2;
                }
            }

        };
        return result;
    }
    private static Comparator<BankAccount> lambdaExpComp1(){
        Comparator<BankAccount> result = (BankAccount ba1, BankAccount ba2) ->{
            return ba2.getAccNum() - ba1.getAccNum();
        };
        return result;
    }
    private static Comparator<BankAccount> lambdaExpComp2(){
        Comparator<BankAccount> result = (ba1, ba2) -> ba1.getAccNum() - ba2.getAccNum();
        return result;
    }
}
