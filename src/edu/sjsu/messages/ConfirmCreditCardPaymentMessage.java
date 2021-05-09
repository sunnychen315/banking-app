package edu.sjsu.messages;

public class ConfirmCreditCardPaymentMessage implements Message {
    double amountToPay;

    public ConfirmCreditCardPaymentMessage(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public double getAmountToPay() {
        return amountToPay;
    }
}
