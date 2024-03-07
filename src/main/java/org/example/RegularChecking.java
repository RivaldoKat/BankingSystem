package org.example;

public class RegularChecking extends CheckingAccount{
    public RegularChecking(int accNum){
        super(accNum);
    }
    public String toString(){
        return "Regular checking account " + accNum + " : balance = "
                + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }
    public void addInterest(){

    }
}
