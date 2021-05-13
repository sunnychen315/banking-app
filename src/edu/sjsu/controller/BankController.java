package edu.sjsu.controller;

import edu.sjsu.messages.*;
import edu.sjsu.model.*;
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
    private User selectedUser;
    private CheckingAccount cAccount;
    private SavingsAccount sAccount;
    private Credit ccAccount;

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
        valves.add(new CreditMessageValve());
        valves.add(new CreditCardPaymentValve());
        valves.add(new WithdrawValve());
        valves.add(new TransferValve());

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
                    selectedUser = currentUser;
                    setAccounts();

                    view.dispose();
                    view = new HomeViewer(queue, selectedUser);

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
                selectedUser = users.get(users.size() - 1);
                setAccounts();

                view.dispose();
                view = new HomeViewer(queue, selectedUser);

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
            view = new HomeViewer(queue, selectedUser);

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
            view = new CheckingsViewer(queue, selectedUser);

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
            view = new SavingsViewer(queue, selectedUser);

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
            view = new CreditViewer(queue, selectedUser);

            return ValveMessage.EXECUTED;
        }
    }

    private class CreditCardPaymentValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != ConfirmCreditCardPaymentMessage.class) {
                return ValveMessage.MISS;
            }
            ConfirmCreditCardPaymentMessage cMessage = (ConfirmCreditCardPaymentMessage) message;
            double payment = cMessage.getAmountToPay();
            ccAccount.payCreditCardBill(payment);

            try {
                Message msg = new CreditsMessage();
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            return ValveMessage.EXECUTED;
        }
    }

    private class WithdrawValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != ConfirmWithdrawMessage.class) {
                return ValveMessage.MISS;
            }
            ConfirmWithdrawMessage wMessage = (ConfirmWithdrawMessage) message;
            double amount = wMessage.getWithdrawAmount();
            Account account = wMessage.getAccount();

            if (account.getClass() == CheckingAccount.class) {
                cAccount.withdraw(amount);
                try {
                    Message msg = new CheckingMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            } else if (account.getClass() == SavingsAccount.class) {
                sAccount.withdraw(amount);
                try {
                    Message msg = new SavingsMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }

            return ValveMessage.EXECUTED;
        }
    }

    private class TransferValve implements Valve {

        @Override
        public ValveMessage execute(Message message) {
            //check if correct message
            if (message.getClass() != ConfirmTransferMessage.class) {
                return ValveMessage.MISS;
            }
            ConfirmTransferMessage tMessage = (ConfirmTransferMessage) message;
            double amount = tMessage.getTransferAmount();
            Account from = tMessage.getFrom();
            Account to = tMessage.getTo();

            if (from.getClass() == CheckingAccount.class) {
                cAccount.transfer(from, to, amount);
                try {
                    Message msg = new CheckingMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            } else if (from.getClass() == SavingsAccount.class) {
                sAccount.transfer(from, to, amount);
                try {
                    Message msg = new SavingsMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }

            return ValveMessage.EXECUTED;
        }
    }


    private void setAccounts() {
        for (Account a : selectedUser.getAccounts()) {
            if (a.getClass() == CheckingAccount.class) {
                this.cAccount = (CheckingAccount) a;
            }
            if (a.getClass() == SavingsAccount.class) {
                this.sAccount = (SavingsAccount) a;
            }
            if (a.getClass() == Credit.class) {
                this.ccAccount = (Credit) a;
            }
        }
    }
}
