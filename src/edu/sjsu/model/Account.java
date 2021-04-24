package edu.sjsu.model;

public class Account {
    double balance;
    double amountToWithdraw;
    double amountToDeposit;

    public Account(double balance, double amountToWithdraw, double amountToDeposit) {
        this.balance = balance;
        this.amountToWithdraw = amountToWithdraw;
        this.amountToDeposit = amountToDeposit;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAmountToWithdraw() {
        return this.amountToWithdraw;
    }

    public double getAmountToDeposit() {
        return this.amountToDeposit;
    }

    public void withdraw() {
        balance = balance - this.getAmountToWithdraw();
    }

}
