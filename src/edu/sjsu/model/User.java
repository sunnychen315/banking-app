package edu.sjsu.model;

import java.util.ArrayList;

/**
 * Class used to store user information
 */
public class User {
    ArrayList<Account> accounts; //list of account user has
    String password;
    String userName;

    /**
     * Constructor for User class
     */
    public User(String userName, String password) {
        this.password = password;
        this.userName = userName;
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
    public String getUserName() {
        return userName;
    }


    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

}
