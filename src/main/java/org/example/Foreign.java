package org.example;

public enum Foreign implements OwnerStrategy{
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
