package edu.sjsu.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckingsTest {
    @Test
    public void getbalance() {
        CheckingAccount ca = new CheckingAccount(1000);
        double balance = 1000;
        assertEquals(ca.getBalance(), balance, 0.0);
    }

    @Test
    public void withdraw() {
        CheckingAccount ca = new CheckingAccount(1000);
        ca.withdraw(500);
        double balance = 500;
        assertEquals(ca.getBalance(), balance, 0.0);
    }

    @Test
    public void deposit() {
        CheckingAccount ca = new CheckingAccount(1000);
        ca.deposit(500);
        double balance = 1500;
        assertEquals(ca.getBalance(), balance, 0.0);
    }

    @Test
    public void transfer() {
        CheckingAccount ca = new CheckingAccount(1000);
        SavingsAccount sa = new SavingsAccount(1000);
        ca.transfer(ca, sa, 500);
        double caBalance = 500;
        double saBalance = 1500;
        assertEquals(ca.getBalance(), caBalance, 0.0);
        assertEquals(sa.getBalance(), saBalance, 0.0);
    }

    @Test
    public void setBalance() {
        CheckingAccount ca = new CheckingAccount(1000);
        ca.setBalance(500);
        double newBalance = 500;
        assertEquals(ca.getBalance(), newBalance, 0.0);
    }
}
