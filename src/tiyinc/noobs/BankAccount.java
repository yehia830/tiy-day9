package tiyinc.noobs;

/**
 * Created by Yehia830 on 8/19/16.
 */
public abstract class BankAccount {
    private double balance;
    private String name;
    private double Interest;


    public void printInfo() {
        System.out.println("Account name: " + name);
        System.out.println("Account balance: " + balance);


    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amountToDeposit) {
        balance += amountToDeposit;

        return balance;
    }

    public double withdraw(double amountToWithdraw) {
        balance -= amountToWithdraw;

        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInterest(double balance){
        balance = Interest * balance;
        return balance;
    }
    public void setInterest(double Interest){
       this.Interest = Interest;
    }

}