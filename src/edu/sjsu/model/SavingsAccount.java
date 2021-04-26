package edu.sjsu.model;

/**
 * Class used to represent savings account where user accumulates money not ready to use yet
 * user can withdraw and deposit  into a savings account
 */
public class SavingsAccount extends Account {
    private final int THRESHOLD = 1000;

    /**
     * Constructor to update variables
     *
     * @param balance balance of the savings account
     */
    public SavingsAccount(double balance, double interest) {
		super(balance, interest);
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