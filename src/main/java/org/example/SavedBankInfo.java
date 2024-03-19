package org.example;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;


public class SavedBankInfo {
    private String fname;
    private Map<Integer,BankAccount> accounts = new HashMap<>();
    private int nextAcc = 0;
    private ByteBuffer bb = ByteBuffer.allocate(16);
    public SavedBankInfo(String fname){
        this.fname = fname;
        if (!new File(fname).exists()){
            return;
        }
        try (InputStream is = new FileInputStream(fname)) {
            readMap(is);
        }
        catch (IOException ex) {
            throw new RuntimeException("file read exception");
        }
    }
    public Map<Integer, BankAccount> getAccounts(){
        return accounts;
    }
    public int nextAccNum() {
        return nextAcc;
    }
    public void saveMap(Map<Integer,BankAccount> map, int nextAcc) {
        try (OutputStream os = new FileOutputStream(fname)) {
            writeMap(os, map, nextAcc);
        }
        catch(IOException ex) {
            throw new RuntimeException("file write exception");
        }
    }
    private void writeMap(OutputStream os, Map<Integer, BankAccount> map, int nextAcc) throws IOException{
        for (BankAccount ba: map.values()) {
            writeAccount(os, ba);
        }
    }
    private void readMap(InputStream is) throws IOException {
        nextAcc = readInt(is);
        BankAccount ba = readAccount(is);
        while(ba != null) {
            accounts.put(ba.getAccNum(), ba);
            ba = readAccount(is);
        }
    }
    private void writeInt(OutputStream os, int n) throws IOException {
        bb.putInt(0, n);
        os.write(bb.array(), 0, 4);
    }
    private int readInt(InputStream is) throws IOException {
        is.read(bb.array(),0,4);
        return bb.getInt(0);
    }
    private void writeAccount(OutputStream os, BankAccount ba) throws IOException {
        int type = (ba instanceof SavingAccount) ? 1 : (ba instanceof RegularChecking) ? 2:3;
        bb.putInt(0,ba.getAccNum());
        bb.putInt(4, type);
        bb.putInt(8, ba.getBalance());
        bb.putInt(12, ba.isForeign() ? 1:2);
        os.write(bb.array());
    }
    private BankAccount readAccount(InputStream is) throws IOException{
        int n = is.read(bb.array());
        if ( n < 0)
            return null;
        int num = bb.getInt(0);
        int type = bb.getInt(4);
        int balance = bb.getInt(8);
        int isForeign = bb.getInt(12);
        BankAccount ba;
        if (type == 1)
            ba = new SavingAccount(num);
        else if (type == 2)
            ba = new RegularChecking(num);
        else
            ba = new InterestChecking(num);
        ba.deposit(balance);
        ba.setForeign(isForeign == 1);
        return ba;
    }
}
