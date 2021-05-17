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
     * @param userName the username of the account
     * @param password the password of the account
     */
    public User(String userName, String password) {
        this.password = password;
        this.userName = userName;
        accounts = new ArrayList<Account>();

        CheckingAccount checking = new CheckingAccount(10250.01);
        SavingsAccount savings = new SavingsAccount(12345.67);
        accounts.add(checking);
        accounts.add(savings);
        accounts.add(new Credit(checking));
    }

    /**
     * the list of accounts
     * @return accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * gets the username of the account
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * gets the password of the account
     * @return password
     */
    public String getPassword() {
        return password;
    }

}
