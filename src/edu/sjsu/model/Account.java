package edu.sjsu.model;

/**
 * Class used to store account information
 */
public interface Account {
	/**
	 * gets the balance of the selected account
	 * @return the amount in the account
	 */
    public double getBalance();

    /**
     * executes a withdraw with specified amount
     * @param amount to be removed
     */
    public void withdraw(double amount);

    /**
     * sets the initial balance of an account
     * @param balance the money in the account
     */
    public void setBalance(double balance);
}
