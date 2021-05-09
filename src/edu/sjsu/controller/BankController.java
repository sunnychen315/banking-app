package edu.sjsu.controller;

import edu.sjsu.messages.*;
import edu.sjsu.model.User;
import edu.sjsu.model.UserList;
import edu.sjsu.view.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class BankController {
    // instance variables
    private BlockingQueue<Message> queue;
    private List<Valve> valves;
    private UserList users;
    private BankViewer view;

    /**
     * Creates a Controller object
     *
     * @param queue: the blocking queue needed for sending and receiving messages
     * @param users: the model of the program
     */
    public BankController(BlockingQueue<Message> queue, UserList users) {
        this.queue = queue;
        this.users = users;
        valves = new LinkedList<>();

        view = new LoginViewer(queue);

        //valves
        valves.add(new LoginMessageValve());
        valves.add(new RegisterMessageValve());
        valves.add(new SignOutMessageValve());
        valves.add(new HomeMessageValve());
        valves.add(new CheckingMessageValve());
        valves.add(new SavingsMessageValve());

        mainLoop();
    }

    /**
     * Executes operations that are sent through the queue. Each message is sent to valves until one responds
     */
    public void mainLoop() {
        ValveMessage response = ValveMessage.EXECUTED;
        Message message = null;
        while (response != ValveMessage.FINISH) {
            try {
                message = queue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("!");
            for (Valve valve : valves) {
                response = valve.execute(message);
                if (response != ValveMessage.MISS) {
                    break;
                }
            }
        }
    }


    private interface Valve {
        /**
         * Performs operation, returns enum
         */
        public ValveMessage execute(Message message);
    }

    private class LoginMessageValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != LoginMessage.class) {
                return ValveMessage.MISS;
            }
            //look for user in userlist
            LoginMessage loginInfo = (LoginMessage) message;
            User currentUser = null;
            for (User u : users) {
                if (u.getUserName().equalsIgnoreCase(loginInfo.getUser()) && u.getUserName().length() != 0) {
                    currentUser = u;
                    break;
                }
            }
            //If user is not found, do nothing
            if (currentUser != null) {
                //Check if passwords match
                if (currentUser.getPassword().equals(loginInfo.getPassword()) && currentUser.getPassword().length() != 0) {
                    view.dispose();
                    view = new HomeViewer(queue);

                    System.out.println("logged in!");
                }
            }
            return ValveMessage.EXECUTED;
        }

    }

    private class RegisterMessageValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != RegisterMessage.class) {
                return ValveMessage.MISS;
            }
            RegisterMessage registerInfo = (RegisterMessage) message;

            //Validity checks are done through UserList
            if (users.addUser(registerInfo.getUser(), registerInfo.getPassword(), registerInfo.getConfirmedPassword())) {
                //log in with newly created user
                view.dispose();
                view = new HomeViewer(queue);

                System.out.println("created user!");
            }

            return ValveMessage.EXECUTED;
        }

    }

    private class SignOutMessageValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != SignOutMessage.class) {
                return ValveMessage.MISS;
            }
            view.dispose();
            view = new LoginViewer(queue);

            return ValveMessage.EXECUTED;
        }

    }

    private class HomeMessageValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != HomeMessage.class) {
                return ValveMessage.MISS;
            }
            view.dispose();
            view = new HomeViewer(queue);

            return ValveMessage.EXECUTED;
        }
    }

    private class CheckingMessageValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != CheckingMessage.class) {
                return ValveMessage.MISS;
            }
            view.dispose();
            view = new CheckingsViewer(queue);

            return ValveMessage.EXECUTED;
        }
    }

    private class SavingsMessageValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != SavingsMessage.class) {
                return ValveMessage.MISS;
            }
            view.dispose();
            view = new SavingsViewer(queue);

            return ValveMessage.EXECUTED;
        }
    }
    private class CreditMessageValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != CreditsMessage.class) {
                return ValveMessage.MISS;
            }
            view.dispose();
            view = new CreditViewer(queue);

            return ValveMessage.EXECUTED;
        }
    }
}
