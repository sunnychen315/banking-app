package edu.sjsu.model;

/**
 * Class used to store account information
 */
public class Account {
    double balance;
    double amountToWithdraw;
    double amountToDeposit;

    /**
     * Constructor to update variables
     *
     * @param balance
     * @param amountToWithdraw
     * @param amountToDeposit
     */
    public Account(double balance, double amountToWithdraw, double amountToDeposit) {
        this.balance = balance;
        this.amountToWithdraw = amountToWithdraw;
        this.amountToDeposit = amountToDeposit;
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
     * @return amount to deposit
     */
    public double getAmountToDeposit() {
        return this.amountToDeposit;
    }

    /**
     * updates balance after withdraw
     */
    public void withdraw() {
        balance = balance - this.getAmountToWithdraw();
    }

}
