package edu.sjsu.model;

/**
 * Class used to store account information
 */
public class Account {
    private double balance;
    private double amountToWithdraw;

    /**
     * Constructor to update variables
     *
     * @param balance
     * @param amountToWithdraw
     */
    public Account(double balance, double amountToWithdraw) {
        this.balance = balance;
        this.amountToWithdraw = amountToWithdraw;
    }

    /**
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * @return amount to withdraw
     */
    public double getAmountToWithdraw() {
        return this.amountToWithdraw;
    }

    /**
     * updates balance after withdraw
     */
    public void withdraw() {
        this.balance -= this.amountToWithdraw;
    }

}
