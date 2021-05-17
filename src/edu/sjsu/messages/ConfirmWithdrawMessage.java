package edu.sjsu.messages;

import edu.sjsu.model.Account;

/**
 * message for confirming withdraw
 */
public class ConfirmWithdrawMessage implements Message {

    double withdrawAmount;
    Account account;

    /**
     * constructor for confirm withdraw message
     *
     * @param withdrawAmount amount to withdraw
     * @param account        account withdrawing from
     */
    public ConfirmWithdrawMessage(double withdrawAmount, Account account) {
        this.withdrawAmount = withdrawAmount;
        this.account = account;
    }

    /**
     * gets the withdraw amount
     * @return money to withdraw
     */
    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    /**
     * gets the containing account
     * @return account
     */
    public Account getAccount() {
        return account;
    }
}
