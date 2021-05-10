package edu.sjsu.model;

import java.util.ArrayList;

/**
 * Class used to keep track of the credit card balance
 */
public class Credit implements Account {
    private final double spendingLimit = 1000;
    CheckingAccount moneySource;
    private double balance, interest;
    private ArrayList<String> transactions;

    /**
     * Constructor to update variables
     */
    public Credit(CheckingAccount source, double interest) {
        this.interest = interest;
        this.balance = 0 + interest;
        transactions = new ArrayList<>();
        moneySource = source;
    }

    /**
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * @return interest
     */
    public double getInterest() {
        return this.interest;
    }

    public void withdraw(double amount) {
        //do we need this bc you cant withdraw from a credit card
    }

    /**
     * updates balance after withdraw
     */
    public void payCreditCardBill(double amountToPay) {
        if (amountToPay <= balance && isPayableThroughChecking()) {
            double checkingsBalance = moneySource.getBalance();
            checkingsBalance -= amountToPay;
            this.balance -= amountToPay;
        }


        transactions.add("Paid $" + amountToPay);
    }


    /**
     * Returns if the specified balance of money owed can be paid by the checkings account
     *
     * @return whether or not this transaction would be approved
     */
    public boolean isPayableThroughChecking() {
        if (balance <= moneySource.getBalance()) {
            return true;
        }
        return false;
    }
}
