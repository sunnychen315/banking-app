package edu.sjsu.model;

import java.util.ArrayList;

/**
 * Class used to keep track of the credit card balance
 */
public class Credit implements Account {
    private final double spendingLimit = 1000;
    CheckingAccount moneySource;
    private double balance, interest;
    private ArrayList<String> transactions;

    /**
     * Constructor to update variables
     */
    public Credit(CheckingAccount source, double interest) {
        this.balance = 0;
        this.interest = interest;
        transactions = new ArrayList<>();
        moneySource = source;
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
     * Returns if the specified amount of money can be taken out of the card
     *
     * @param amount
     * @return whether or not this transaction would be approved
     */
    public boolean isPayableThroughChecking(double amount) {
        if (balance > spendingLimit && amount < moneySource.getBalance()) {
            return true;
        }
        return false;
    }
}
