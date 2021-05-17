package edu.sjsu.messages;

/**
 * message for logging in
 */
public class LoginMessage implements Message {
    String user;
    String password;

    /**
     * constructor for login message
     *
     * @param user     name
     * @param password of user
     */
    public LoginMessage(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    /**
     * gets the username
     * @return username
     */
    public String getUser() {
        return user;
    }

    /**
     * gets the password entered for the account
     * @return password
     */
    public String getPassword() {
        return password;
    }

}
