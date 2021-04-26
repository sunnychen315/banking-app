package edu.sjsu.model;
/**
 * Class used to keep track of the credit card balance
 */
public class Credit extends Account {
    private final double spendingLimit = 1000;
    CheckingAccount moneySource;
    
    /**
     * Credit card constructor
     * @param interest: the interest of the card
     * @param moneySource: the associated checking account that will pay off debt
     */
    public Credit(double interest, CheckingAccount moneySource) {
		super(0, interest);
		this.moneySource = moneySource;
	}
    
    /**
     * Returns if the specified amount of money can be taken out of the card
     * @param amount
     * @return whether or not this transaction would be approved
     */
    public boolean isPayableThroughChecking(double amount){
        if(balance > spendingLimit && amount < moneySource.getBalance()){
            return true;
        }
        return false;
    }
}
