package edu.sjsu.messages;

public class ConfirmTransferMessage implements Message {
    double transferAmount;

    public ConfirmTransferMessage(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public double getTransferAmount() {
        return transferAmount;
    }
}
