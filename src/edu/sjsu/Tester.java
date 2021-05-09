package edu.sjsu;

import edu.sjsu.controller.BankController;
import edu.sjsu.messages.Message;
import edu.sjsu.model.UserList;
import edu.sjsu.view.CreditViewer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Tester {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        UserList users = new UserList();
        new BankController(queue, users);
        new CreditViewer(queue);
    }
}
