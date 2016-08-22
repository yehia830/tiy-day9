package tiyinc.noobs;

import java.util.HashMap;

public class Saving extends BankAccount{
    private HashMap<String, Saving> SavingNames;

    public Saving(){
        SavingNames = new HashMap<String,Saving>();
    }
    public void addCheckingAccount(Saving acct) {
        SavingNames.put(acct.getName(), acct);
    }
    public HashMap<String, Saving> getSavingNames() {
        return SavingNames;
    }

    public void setSavingNames(HashMap<String, Saving> getSavingNames) {
        this.SavingNames = SavingNames;
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

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}