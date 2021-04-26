package edu.sjsu.model;

import java.util.ArrayList;

/**
 * Class used to store account information
 */
public class Account {
    protected double balance;
    protected double interest;
    protected ArrayList<String> transactions;

    /**
     * Constructor to update variables
     *
     * @param balance of the account
     */
    public Account(double balance, double interest) {
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
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(Account from, Account to, double amount) {
    	//logic goes here
    }
}
