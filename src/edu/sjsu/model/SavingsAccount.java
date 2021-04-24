package edu.sjsu.model;

/**
 * Class used to represent savings account
 * user can withdraw and deposit
 */
public class SavingsAccount extends Account {
    private double amountToDeposit;
    private final int THRESHOLD = 1000;

    /**
     * @param balance
     * @param amountToWithdraw
     * @param amountToDeposit
     */
    public SavingsAccount(double balance, double amountToWithdraw, double amountToDeposit) {
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

    /**
     * Checks to see if the user is allowed to deposit
     *
     * @return false if the balance is less than the threshold, true otherwise
     */
    public boolean canWithdraw() {
        if (this.balance < THRESHOLD) {
            return false;
        } else
            return true;
    }

}
