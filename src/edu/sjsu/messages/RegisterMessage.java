package edu.sjsu.messages;

/**
 * message for creating an account
 */
public class RegisterMessage implements Message {
    String user;
    String password;
    String confirmedPassword;

    /**
     * constructor for register message
     *
     * @param user              name
     * @param password          of user
     * @param confirmedPassword of user
     */
    public RegisterMessage(String user, String password, String confirmedPassword) {
        this.user = user;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    /**
     * gets the username
     * @return username
     */
    public String getUser() {
        return user;
    }

    /**
     * gets the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * gets the duplicate password
     * @return password
     */
    public String getConfirmedPassword() {
        return confirmedPassword;
    }
}
