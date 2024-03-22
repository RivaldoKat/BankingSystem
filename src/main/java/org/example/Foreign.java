package org.example;

public class Foreign implements OwnerStrategy{
    public boolean isForeign(){
        return true;
    }
    public int fee(){
        return 500;
    }
    public String toString(){
        return "foreign";
    }
}
