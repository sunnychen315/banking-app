package edu.sjsu;

import edu.sjsu.messages.Message;
import edu.sjsu.view.CheckingsViewer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Tester {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        new CheckingsViewer(queue);
    }
}
