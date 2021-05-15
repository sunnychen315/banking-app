package edu.sjsu;

import edu.sjsu.controller.BankController;
import edu.sjsu.messages.Message;
import edu.sjsu.model.UserList;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main class used to run the application
 */
public class Tester {
    /**
     * Main method that instantiates blocking queue and objects needed to run program
     */
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        UserList users = new UserList();
        new BankController(queue, users);
    }
}
