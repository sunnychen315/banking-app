package edu.sjsu.model;

/**
 * Class used to keep track of the credit card balance
 */
public class Credit implements Account {
    CheckingAccount moneySource;
    private double balance;

    /**
     * Constructor to update variables
     * @param source the source account
     */
    public Credit(CheckingAccount source) {
        this.balance = 500;
        moneySource = source;
    }

    /**
     * gets the current balance
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * updates balance after withdraw
     * @param amountToPay the amount to pay off
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

    /**
     * withdraw logic, not completed because it is out of our scope
     * @param amout the amount to take out
     */
	@Override
	public void withdraw(double amount) {
		//to be implemented if we expand on this project
		
	}
}
