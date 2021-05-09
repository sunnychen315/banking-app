package edu.sjsu;

import edu.sjsu.controller.BankController;
import edu.sjsu.messages.Message;
import edu.sjsu.model.UserList;
import edu.sjsu.view.AccountViewer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Tester {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        new AccountViewer(queue);
        // new CheckingsViewer(queue);
        // Click "account name" to go to login page

        UserList users = new UserList();
        new BankController(queue, users);
    }
}
