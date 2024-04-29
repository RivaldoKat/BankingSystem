package org.example.owner;

public enum Domestic implements OwnerStrategy {
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
