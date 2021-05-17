package edu.sjsu.model;

/**
 * Class used to represent checking account where user can use debit card
 * user can withdraw and deposit checking account
 */
public class CheckingAccount implements Account {

    private double balance;

    /**
     * Constructor to update variables
     *
     * @param balance of the account
     */
    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    /**
     * @return balance
     */
    public double getBalance() {
        return this.balance;
    }


    /**
     * updates balance after withdraw
     */
    public void withdraw(double amountToWithdraw) {
        if (amountToWithdraw <= balance) {
            this.balance -= amountToWithdraw;
        }
    }

    /**
     * Transfers money to another account
     *
     * @param from   account
     * @param to     account
     * @param amount to transfer
     */
    public void transfer(Account from, Account to, double amount) {
        if (amount < from.getBalance()) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }
    }

    /**
     * deposits to checking account balance and updates balance
     * @param amountToDeposit the acount to deposit
     */
    public void deposit(double amountToDeposit) {
        this.balance += amountToDeposit;
    }

    /**
     * sets the balance of the account
     * @param balance of account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
