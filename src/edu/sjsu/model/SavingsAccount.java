package edu.sjsu.model;

/**
 * Class used to represent savings account where user accumulates money not ready to use yet
 * user can withdraw and deposit  into a savings account
 */
public class SavingsAccount implements Account {
    private final int THRESHOLD = 1000;
    private double balance;

    /**
     * Constructor to update variables
     *
     * @param balance of the account
     */
    public SavingsAccount(double balance) {
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
        if (canWithdraw(amountToWithdraw)) {
            this.balance -= amountToWithdraw;
        }
    }

    /**
     * Transfers money to another account
     *
     * @param from   account
     * @param to     account
     * @param amount to transfer
     */
    public void transfer(Account from, Account to, double amount) {
        if (amount < from.getBalance()) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }
    }


    /**
     * deposits to savings account balance and updates balance
     */
    public void deposit(double amountToDeposit) {
        this.balance += amountToDeposit;
    }

    /**
     * Checks to see if the user is allowed to deposit
     *
     * @return false if the balance is less than the threshold, true otherwise
     */
    public boolean canWithdraw(double amount) {
        return (amount < THRESHOLD && amount < this.balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
