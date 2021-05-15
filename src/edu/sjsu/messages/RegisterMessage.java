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

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }
}
