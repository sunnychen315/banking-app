package edu.sjsu.messages;

public class ConfirmTransferButton implements Message {
    double transferAmount;

    public ConfirmTransferButton(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public double getTransferAmount() {
        return transferAmount;
    }
}
