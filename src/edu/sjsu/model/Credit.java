package edu.sjsu.model;

/**
 * Class used to keep track of the credit card balance
 */
public class Credit extends Account {
    private final double spendingLimit = 1000;

    /**
     * Constructor with @param balance
     */
    public Credit(double balance) {
        super(balance);
    }

    /**
     * @return true or false to see if there is enough balance to pay the bill
     */
    public boolean isPayableThroughChecking() {
        if (balance > spendingLimit) {
            return true;
        }
        return false;
    }
}
