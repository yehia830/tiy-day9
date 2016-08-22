package tiyinc.noobs;

import java.util.HashMap;

public class Retirement extends BankAccount implements Runnable{
    private HashMap<String, Retirement> retirementHashMap;

    public void run(){

    }



    public Retirement(){
        retirementHashMap = new HashMap<String,Retirement>();


    }
    public void addRetirementAccount(Retirement acct) {
        retirementHashMap.put(acct.getName(), acct);
    }
    public HashMap<String, Retirement> stringSavingHashMap() {
        return retirementHashMap;
    }

    public void setSavingNames(HashMap<String, Retirement> retirementHashMap) {
        this.retirementHashMap = retirementHashMap;
    }
    public HashMap<String, Retirement> getRetirementHashMap() {
        return retirementHashMap;
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