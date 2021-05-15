package edu.sjsu.model;

/**
 * Class used to store account information
 */
public interface Account {
    public double getBalance();

    public void withdraw(double amount);

    public void setBalance(double balance);
}
