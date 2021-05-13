package edu.sjsu.messages;

import edu.sjsu.model.Account;

public class ConfirmTransferMessage implements Message {
    double transferAmount;
    Account from;
    Account to;

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
