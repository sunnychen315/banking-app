package edu.sjsu.model;

import java.util.ArrayList;

/**
 * Class used to represent checking account where user can use debit card
 * user can withdraw and deposit checking account
 */
public class CheckingAccount implements Account {

    private double balance, interest;
    private ArrayList<String> transactions;

    /**
     * Constructor to update variables
     *
     * @param balance of the account
     */
    public CheckingAccount(double balance, double interest) {
        this.balance = balance;
        this.interest = interest;
        transactions = new ArrayList<>();
    }

    /**
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * @return interest
     */
    public double getInterest() {
        return this.interest;
    }

    /**
     * updates balance after withdraw
     */
    public void withdraw(double amountToWithdraw) {
        if (amountToWithdraw <= balance) {
            this.balance -= amountToWithdraw;
            transactions.add("Withdrew $" + amountToWithdraw);
        }
    }

    /**
     * Transfers money to another account
     *
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(Account from, Account to, double amount) {
        if (amount < from.getBalance()) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }
    }

    /**
     * @return the transactions
     */
    public ArrayList<String> getTransactions() {
        return transactions;
    }

    /**
     * deposits to checking account balance and updates balance
     */
    public void deposit(int amountToDeposit) {
        this.balance += amountToDeposit;
        transactions.add("Deposited $" + amountToDeposit);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
