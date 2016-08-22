package tiyinc.noobs;

import java.util.ArrayList;
import java.util.HashMap;

public class Checking extends BankAccount{
    private String nameOfChecking;
    private HashMap<String, Checking> checkingNames;

    public Checking() {
       checkingNames = new HashMap<String,Checking>();
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public double deposit(double amountToDeposit) {
        return super.deposit(amountToDeposit);
    }

    @Override
    public double withdraw(double amountToWithdraw) {
        return super.withdraw(amountToWithdraw);
    }

    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }
    public void addCheckingAccount(Checking acct) {
        checkingNames.put(acct.getName(), acct);
    }
    public HashMap<String, Checking> getCheckingNames() {
        return checkingNames;
    }

    public void setCheckingName(HashMap<String, Checking> getCheckingNames) {
        this.checkingNames = checkingNames;
    }


}