package edu.sjsu.messages;

public class ConfirmWithdrawMessage implements Message {

    double withdrawAmount;

    public ConfirmWithdrawMessage(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }
}
