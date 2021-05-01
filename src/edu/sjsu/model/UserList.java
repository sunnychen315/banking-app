package edu.sjsu.model;

import java.util.ArrayList;

/**
 * this class stores a list of all users, allowing for multiple accounts to be made
 */
public class UserList extends ArrayList<User> {

    /**
     * this method adds a user to the list
     *
     * @param userName  of user
     * @param password  of user
     * @param password2 checks if users password is correct
     * @return t/f if user is unique
     */
    public boolean addUser(String userName, String password, String password2) {

        if (!password.equals(password2)) {
            return false;
        }
        if (this.validUsername(userName)) {
            return false;
        }

        this.add(new User(userName, password));
        return true;

    }

    /**
     * this method checks if a uer exists
     *
     * @param userName
     * @return
     */
    public boolean validUsername(String userName) {
        for (User u : this) {
            if (u.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this method checks if a login is valid
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean validLogin(String userName, String password) {
        for (User u : this) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this shows all the users in the list
     */
    public void showUser() {
        for (int i = 0; i < this.size(); i++) {
            this.get(i).toString();
        }
    }

}
