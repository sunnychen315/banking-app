package edu.sjsu.model;

/**
 * Class used to represent checking account where user can use debit card
 * user can withdraw and deposit checking account
 */
public class CheckingAccount extends Account {
	
	/**
     * Constructor to update variables
     *
     * @param balance of the checking account
     */
    public CheckingAccount(double balance, double interest) {
		super(balance, interest);
	}
    
    /**
     * deposits to checking account balance and updates balance
     */
    public void deposit(int amountToDeposit) {
        this.balance += amountToDeposit;
        transactions.add("Deposited $" + amountToDeposit);
    }
}
