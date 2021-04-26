package edu.sjsu.model;

import java.util.ArrayList;

/**
 * Class used to store user information
 */
public class User {
    ArrayList<Account> accounts;
    String password;
    String userName;

    /**
     * Constructor for User class
     */
    public User() {
        accounts = new ArrayList<Account>();
    }

    /**
     * @return accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * @return netbalance
     */
    public double NetWorth() {
        double netBalance = 0;
        for (int i = 0; i < accounts.size(); i++) {
            netBalance = netBalance + accounts.get(i).getBalance();
        }
        return netBalance;
    }

    /**
     * @param name of the user
     */
    public void setUserName(String name) {
        this.userName = name;
    }

    /**
     * @return userName
     */
    public String getName() {
        return userName;
    }

    /**
     * @param pass to set the password
     */
    public void setPassword(String pass) {
        this.password = pass;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

}
