package edu.sjsu.messages;

/**
 * Message used when user confirms credit card payment
 */
public class ConfirmCreditCardPaymentMessage implements Message {
    double amountToPay;

    /**
     * @param amountToPay amount to pay credit card balance
     */
    public ConfirmCreditCardPaymentMessage(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public double getAmountToPay() {
        return amountToPay;
    }
}
