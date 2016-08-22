package tiyinc.noobs;

import javafx.beans.binding.DoubleExpression;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Yehia830 on 8/18/16.
 */
public class BankRunner {
    public static void main(String[] args) {
        System.out.println("Running ... with " + args.length + " arguments");

        String commandLineBankName = "Backend Bank";
        String commandLineAcctName = "Default Account Name";
        double commandLineInitBalance = 0.0;
        if (args.length == 3) {
            commandLineBankName = args[0];
            commandLineAcctName = args[1];
            commandLineInitBalance = Double.valueOf(args[2]);
        }
        Scanner inputScanner = new Scanner(System.in);
        Bank myBank = new Bank();
        Checking checking = new Checking();
        Saving saving = new Saving();
        Retirement retirement = new Retirement();
        BankCustomer customer = new BankCustomer();
        myBank.setName(commandLineBankName);
        System.out.println("Please choose one");
        System.out.println("Are you a new or existing user?");
        System.out.println("1.New");
        System.out.println("2.Existing");
        int choice = Integer.valueOf(inputScanner.nextLine());

        if (choice == 1) {
            System.out.println("What is your first name?");
            String name = inputScanner.nextLine();
            customer.addCustomer(name);
            System.out.println("Which type of bank account would you like to create?");
            System.out.println("1.Checking");
            System.out.println("2.Saving");
            System.out.println("3.Retirement");
            System.out.println("0.Exit");
            int choice1 = Integer.valueOf(inputScanner.nextLine());
            if (choice1 == 1) {
                System.out.println("How many checking accounts do you have?");
                int numBankAccounts = Integer.valueOf(inputScanner.nextLine());
                for (int accountIndex = 0; accountIndex < numBankAccounts; accountIndex++) {
                    System.out.println("Enter information for Account " + (accountIndex + 1));
                    System.out.println("Account Name please: ");
                    String checkingAccountName = inputScanner.nextLine();
                    System.out.println("Initial Balance please: ");
                    double initCheckingBalance = Double.valueOf(inputScanner.nextLine());

                    checking.setName(checkingAccountName);
                    checking.setBalance(initCheckingBalance);
                    checking.addCheckingAccount(checking);
                }

            }
            if (choice1 == 2) {
                System.out.println("How many Saving accounts do you have? ");
                int numBankAccounts = Integer.valueOf(inputScanner.nextLine());
                for (int accountIndex = 0; accountIndex < numBankAccounts; accountIndex++) {
                    System.out.println("Enter information for Account " + (accountIndex + 1));
                    System.out.println("Account Name please: ");
                    String savingAccountName = inputScanner.nextLine();
                    System.out.println("Initial Balance please: ");
                    double initSavingBalance = Double.valueOf(inputScanner.nextLine());

                    saving.setName(savingAccountName);
                    saving.setBalance(initSavingBalance);
                    saving.addCheckingAccount(saving);

                }
                if (choice1 == 3) {
                    System.out.println("How many Retirement accounts do you have?");
                    numBankAccounts = Integer.valueOf(inputScanner.nextLine());
                    for (int accountIndex = 0; accountIndex < numBankAccounts; accountIndex++) {
                        System.out.println("Enter information for Account " + (accountIndex + 1));

                        System.out.println("Account Name please: ");
                        String savingAccountName = inputScanner.nextLine();
                        System.out.println("Initial Balance please: ");
                        double initRetirementBalance = Double.valueOf(inputScanner.nextLine());

                        retirement.setName(savingAccountName);
                        retirement.setBalance(initRetirementBalance);
                        retirement.addRetirementAccount(retirement);
                    }


                }


            }


            System.out.println("My Bank Info: ");
            myBank.printInfo();


            while (true) {

                System.out.println("Enter the name of the account you would like to use: ");
                System.out.println("(Enter exit to exit ;-)");
                for (String accountKey : checking.getCheckingNames().keySet()) {
                    System.out.println(accountKey);
                }
                for (String accountKey : saving.getSavingNames().keySet()) {
                    System.out.println(accountKey);
                }
                for (String accountKey : retirement.getRetirementHashMap().keySet()) {
                    System.out.println(accountKey);
                }


                String userChoice = inputScanner.nextLine();
                System.out.println("The user chose: " + userChoice);

                if (userChoice == null || userChoice.equals("exit")) {
                    break;
                }

                Checking userChosenAccount = checking.getCheckingNames().get(userChoice);
                Saving userChosenAccount1 = saving.getSavingNames().get(userChoice);
                Retirement userChosenAccount2 = retirement.getRetirementHashMap().get(userChoice);


                if (userChosenAccount == null && userChosenAccount1 == null && userChosenAccount2 == null) {
                    System.out.println("Unknown account");
                } else {

                    while (true) {

                        System.out.println("What would you like to do: ");
                        System.out.println("0. Exit");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Print Info");
                        System.out.println("4. Transfer");
                        System.out.println("5. Choose new Account");


                        int actionChoice = Integer.valueOf(inputScanner.nextLine());
                        if (actionChoice == 1) {
                            System.out.println("Enter deposit amount");
                            double amount = Double.valueOf(inputScanner.nextLine());
                            userChosenAccount.deposit(amount);
                        } else if (actionChoice == 2) {
                            System.out.println("Enter withdrawal amount");
                            double amount = Double.valueOf(inputScanner.nextLine());
                            userChosenAccount.withdraw(amount);
                        } else if (actionChoice == 3) {
                            userChosenAccount.printInfo();
                        } else if (actionChoice == 0) {
                            break;
                        } else if (actionChoice == 5) {
                            createAcctMenu();
                        } else if (actionChoice == 4) {
                            System.out.println("How much money would you like to transfer?");
                            double amountToTransfer = Double.valueOf(inputScanner.nextLine());
                            System.out.println("What account would you like to transfer this money to?");


                            for (String accountKey : myBank.getBankAccountsByName().keySet()) {
                                System.out.println(accountKey);
                            }

                            String transferChoice = inputScanner.nextLine();
                            System.out.println("We will transfer to your " + transferChoice + " account");

                            Checking transferAccount = checking.getCheckingNames().get(transferChoice);
                            Saving transferAccount1 = saving.getSavingNames().get(transferChoice);
                            Retirement transferAccount2 = retirement.getRetirementHashMap().get(transferChoice);
                            if (transferAccount == null && transferAccount1 == null && transferAccount2 == null) {
                                System.out.println("Invalid account");
                                break;
                            } else {
                                userChosenAccount.withdraw(amountToTransfer);
                                transferAccount.deposit(amountToTransfer);
                            }
                        }
                    }
                }
            }


        }
        if (choice == 2){
            System.out.println("please select your name");




        }


    }

    public static void createAcctMenu() {
        Scanner inputScanner = new Scanner(System.in);
        Bank myBank = new Bank();
        Checking checking = new Checking();
        Saving saving = new Saving();
        Retirement retirement = new Retirement();
        boolean boo = true;
        System.out.println("Please choose one");
        System.out.println("Are you a new or existing user?");
        System.out.println("1.New");
        System.out.println("2.Existing");
        int choice = Integer.valueOf(inputScanner.nextLine());
        if (choice == 1) {
            System.out.println("Which type of bank account would you like to create?");
            System.out.println("1.Checking");
            System.out.println("2.Saving");
            System.out.println("3.Retirement");
            System.out.println("0.Exit");
            int choice1 = Integer.valueOf(inputScanner.nextLine());
            if (choice1 == 1) {
                System.out.println("How many checking accounts would you like to add?");
                int numBankAccounts = Integer.valueOf(inputScanner.nextLine());
                for (int accountIndex = 0; accountIndex < numBankAccounts; accountIndex++) {
                    System.out.println("Enter information for Account " + (accountIndex + 1));
                    System.out.println("Account Name please: ");
                    String checkingAccountName = inputScanner.nextLine();
                    System.out.println("Initial Balance please: ");
                    double initCheckingBalance = Double.valueOf(inputScanner.nextLine());

                    checking.setName(checkingAccountName);
                    checking.setBalance(initCheckingBalance);
                    checking.addCheckingAccount(checking);
                }

            }
            if (choice1 == 2) {
                System.out.println("How many Saving accounts would you like to add? ");
                int numBankAccounts = Integer.valueOf(inputScanner.nextLine());
                for (int accountIndex = 0; accountIndex < numBankAccounts; accountIndex++) {
                    System.out.println("Enter information for Account " + (accountIndex + 1));
                    System.out.println("Account Name please: ");
                    String savingAccountName = inputScanner.nextLine();
                    System.out.println("Initial Balance please: ");
                    double initSavingBalance = Double.valueOf(inputScanner.nextLine());

                    saving.setName(savingAccountName);
                    saving.setBalance(initSavingBalance);
                    saving.addCheckingAccount(saving);

                }
                if (choice1 == 3) {
                    System.out.println("How many Retirement accounts would you like to add?");
                    numBankAccounts = Integer.valueOf(inputScanner.nextLine());
                    for (int accountIndex = 0; accountIndex < numBankAccounts; accountIndex++) {
                        System.out.println("Enter information for Account " + (accountIndex + 1));

                        System.out.println("Account Name please: ");
                        String savingAccountName = inputScanner.nextLine();
                        System.out.println("Initial Balance please: ");
                        double initRetirementBalance = Double.valueOf(inputScanner.nextLine());

                        retirement.setName(savingAccountName);
                        retirement.setBalance(initRetirementBalance);
                        retirement.addRetirementAccount(retirement);
                    }


                }

                while (boo == true) {
                    System.out.println("Enter the name of the account you would like to use: ");
                    System.out.println("(Enter exit to exit ;-)");
                    for (String accountKey : checking.getCheckingNames().keySet()) {
                        System.out.println(accountKey);
                    }
                    for (String accountKey : saving.getSavingNames().keySet()) {
                        System.out.println(accountKey);
                    }
                    for (String accountKey : retirement.getRetirementHashMap().keySet()) {
                        System.out.println(accountKey);
                    }


                    String userChoice = inputScanner.nextLine();
                    System.out.println("The user chose: " + userChoice);

                    if (userChoice == null || userChoice.equals("exit")) {
                        boo = false;
                        break;

                    }

                    Checking userChosenAccount = checking.getCheckingNames().get(userChoice);
                    Saving userChosenAccount1 = saving.getSavingNames().get(userChoice);
                    Retirement userChosenAccount2 = retirement.getRetirementHashMap().get(userChoice);


                    if (userChosenAccount == null && userChosenAccount1 == null && userChosenAccount2 == null) {
                        System.out.println("Unknown account");
                    }


                }

            }


        }
    }
}


