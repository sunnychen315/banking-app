package edu.sjsu.messages;

import edu.sjsu.model.Account;

/**
 * message for confirming deposit
 */
public class ConfirmDepositMessage implements Message {

    double depositAmount;
    Account account;

    /**
     * constructor for message
     *
     * @param depositAmount amount to deposit
     * @param account       account user is depositing in
     */
    public ConfirmDepositMessage(double depositAmount, Account account) {
        this.depositAmount = depositAmount;
        this.account = account;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public Account getAccount() {
        return account;
    }
}
