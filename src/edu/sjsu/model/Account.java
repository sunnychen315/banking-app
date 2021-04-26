package edu.sjsu.model;

/**
 * Class used to store account information
 */
public class Account {
    double balance;

    /**
     * Constructor to update variables
     *
     * @param balance of the account
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * updates balance after withdraw
     */
    public void withdraw(double amountToWithdraw) {
        this.balance -= amountToWithdraw;
    }

}
