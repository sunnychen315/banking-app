package edu.sjsu.messages;

import edu.sjsu.model.Account;

/**
 * message for confirming transfer
 */
public class ConfirmTransferMessage implements Message {
    double transferAmount;
    Account from;
    Account to;

    /**
     * constructor for transfer message
     *
     * @param transferAmount amount to transfer
     * @param from           account transferring from
     * @param to             account transferring to
     */
    public ConfirmTransferMessage(double transferAmount, Account from, Account to) {
        this.transferAmount = transferAmount;
        this.from = from;
        this.to = to;
    }

    /**
     * gets the transfer value
     * @return money to be transfered
     */
    public double getTransferAmount() {
        return transferAmount;
    }

    /**
     * gets the account to get the money from
     * @return donor account
     */
    public Account getFrom() {
        return from;
    }

    /**
     * gets the account to transfer to
     * @return receiving account
     */
    public Account getTo() {
        return to;
    }
}
