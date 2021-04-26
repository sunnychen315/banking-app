package edu.sjsu.model;

/**
 * Class used to represent checking account where user can use debit card
 * user can withdraw and deposit checking account
 */
public class CheckingAccount extends Account {

    private double amountToDeposit;

    /**
     * Constructor to update variables
     *
     * @param balance
     * @param amountToWithdraw
     */
    public CheckingAccount(double balance, double amountToWithdraw, double amountToDeposit) {
        super(balance, amountToWithdraw);
        this.amountToDeposit = amountToDeposit;
    }

    /**
     * @return amount to deposit
     */
    public double getAmountToDeposit() {
        return this.amountToDeposit;
    }

    /**
     * deposits to savings account balance and updates balance
     */
    public void deposit() {
        this.balance += this.amountToDeposit;
    }
}
