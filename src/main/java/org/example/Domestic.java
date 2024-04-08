package org.example;

public enum Domestic implements OwnerStrategy{
    INSTANCE;
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
