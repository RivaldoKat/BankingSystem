package org.example;

import org.example.bank.BankAccount;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class SavedBankInfo {
    private final String fileName;
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private final int nextAcc;
    public SavedBankInfo(String fileName){
        this.fileName = fileName;
        File f = new File(fileName);
        if (!f.exists()) {
            accounts = new HashMap<Integer, BankAccount>();
            nextAcc = 0;
        }else {
            try (InputStream is = new FileInputStream(fileName);
                 ObjectInput ois = new ObjectInputStream(is)) {
                accounts = ((Map<Integer, BankAccount>) ois.readObject());
                nextAcc = ois.readInt();
            }catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException("file read exception");
            }
        }

    }
    public Map<Integer, BankAccount> getAccounts(){
        return accounts;
    }
    public int nextAccNum() {
        return nextAcc;
    }
    public void saveMap(Map<Integer,BankAccount> map, int nextAcc) {
        try (OutputStream os = new FileOutputStream(fileName);
             ObjectOutput oos = new ObjectOutputStream(os)) {
            oos.writeObject(map);
            oos.writeInt(nextAcc);
        }
        catch(IOException ex) {
            throw new RuntimeException("file write exception");
        }
    }

}
