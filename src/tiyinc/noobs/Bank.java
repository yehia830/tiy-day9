package tiyinc.noobs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yehia830 on 8/18/16.
 */
public class Bank   {
    private String name;
    private HashMap<String, BankAccount> bankAccountsByName;


    public Bank() {
        bankAccountsByName = new HashMap<String, BankAccount>();

    }

    public double getTotalInDeposits() {
        double total = 0.0;
        for (BankAccount currAcct : bankAccountsByName.values()) {
            total += currAcct.getBalance();
        }
        return total;
    }

    public void printInfo() {



        System.out.println("###############################");
        System.out.println("Bank Name: " + name);
        System.out.println("Total in deposits: " + getTotalInDeposits());
        System.out.println("###############################");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBankAccount(BankAccount acct) {
        bankAccountsByName.put(acct.getName(), acct);
    }

    public HashMap<String, BankAccount> getBankAccountsByName() {
        return bankAccountsByName;
    }

    public void setBankAccountsByName(HashMap<String, BankAccount> bankAccountsByName) {
        this.bankAccountsByName = bankAccountsByName;
    }

}