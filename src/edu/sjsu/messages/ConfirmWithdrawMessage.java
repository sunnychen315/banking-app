package edu.sjsu.messages;

import edu.sjsu.model.Account;

public class ConfirmWithdrawMessage implements Message {

    double withdrawAmount;
    Account account;

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
