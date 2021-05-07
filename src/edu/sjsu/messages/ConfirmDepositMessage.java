package edu.sjsu.messages;

/**
 * message for confirming deposit
 */
public class ConfirmDepositMessage implements Message {

    double depositAmount;

    public ConfirmDepositMessage(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getDepositAmount() {
        return depositAmount;
    }
}
