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
     */
    public CheckingAccount(double balance) {
        super(balance);
        this.amountToDeposit = amountToDeposit;
    }

    /**
     * deposits to checking account balance and updates balance
     */
    public void deposit(int amountToDeposit) {
        this.balance += amountToDeposit;
    }
}
