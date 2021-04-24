package edu.sjsu.model;

public class SavingsAccount extends Account {

    double amountToDeposit;
    private final int THRESHOLD = 1000;

    public SavingsAccount(double balance, double amountToWithdraw, double amountToDeposit) {
        super(balance, amountToWithdraw);
        this.amountToDeposit = amountToDeposit;
    }

    public double getAmountToDeposit() {
        return this.amountToDeposit;
    }

    public void deposit() {
        this.balance += this.amountToDeposit;
    }

    public boolean canWithdraw() {
        if (this.balance < THRESHOLD) {
            return false;
        } else
            return true;
    }

}
