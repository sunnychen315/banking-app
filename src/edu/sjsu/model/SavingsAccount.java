package edu.sjsu.model;

import java.util.ArrayList;

/**
 * Class used to represent savings account where user accumulates money not ready to use yet
 * user can withdraw and deposit  into a savings account
 */
public class SavingsAccount implements Account {
    private final int THRESHOLD = 1000;
    private double balance, interest;
    private ArrayList<String> transactions;

    /**
     * Constructor to update variables
     *
     * @param balance of the account
     */
    public SavingsAccount(double balance, double interest) {
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
        this.balance -= amountToWithdraw;
        transactions.add("Withdrew $" + amountToWithdraw);
    }

    /**
     * Transfers money to another account
     *
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(Account from, Account to, double amount) {
        //logic goes here
    }

    /**
     * @return the transactions
     */
    public ArrayList<String> getTransactions() {
        return transactions;
    }

    /**
     * deposits to savings account balance and updates balance
     */
    public void deposit(int amountToDeposit) {
        this.balance += amountToDeposit;
        transactions.add("Deposited $" + amountToDeposit);
    }

    /**
     * Checks to see if the user is allowed to deposit
     *
     * @return false if the balance is less than the threshold, true otherwise
     */
    public boolean canWithdraw(double amount) {
        return (amount < THRESHOLD && amount < this.balance);
    }

}
