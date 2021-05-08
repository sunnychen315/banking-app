package edu.sjsu.view;

import edu.sjsu.messages.Message;

import java.util.concurrent.BlockingQueue;

public class AccountViewer extends BankViewer {

    // instance variables

    public AccountViewer(BlockingQueue<Message> queue) {

        // Sets the characteristics of the JFrame
        super(queue);
        this.setTitle("Account Page");

        addAccountName();
        addHomeActionListener();
    }
}
