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

    public double getTransferAmount() {
        return transferAmount;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }
}
