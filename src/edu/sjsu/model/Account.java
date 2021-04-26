package edu.sjsu.model;

/**
 * Class used to store account information
 */
public interface Account {
    public double getBalance();
    public double getInterest();
    public void withdraw(double amount);
}
