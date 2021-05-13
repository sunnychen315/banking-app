package edu.sjsu.model;

/**
 * Class used to keep track of the credit card balance
 */
public class Credit implements Account {
    CheckingAccount moneySource;
    private double balance;

    /**
     * Constructor to update variables
     */
    public Credit(CheckingAccount source) {
        this.balance = 500;
        moneySource = source;
    }

    /**
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }


    public void withdraw(double amount) {
        //do we need this bc you cant withdraw from a credit card
    }

    /**
     * updates balance after withdraw
     */
    public void payCreditCardBill(double amountToPay) {
        if (amountToPay <= balance && isPayableThroughChecking()) {
            double checkingBalance = moneySource.getBalance();
            moneySource.setBalance(checkingBalance - amountToPay);
            this.balance -= amountToPay;
        }

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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
