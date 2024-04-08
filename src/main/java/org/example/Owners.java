package org.example;

public enum Owners implements OwnerStrategy{
    DOMESTIC(false,0,"domestic"), FOREIGN(true,500,"foreign");
    private final boolean isForeign;
    private final int fee;
    private final String name;

    private Owners(boolean isForeign, int fee, String name){
        this.isForeign = isForeign;
        this.fee = fee;
        this.name = name;
    }
    public boolean isForeign(){
        return isForeign;
    }
    public int fee(){
        return fee;
    }
    public String toString(){
        return name;
    }
}
