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

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public Account getAccount() {
        return account;
    }
}
