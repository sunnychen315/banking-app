package edu.sjsu.messages;

public class LoginMessage {
    String user;
    String password;

    public LoginMessage(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}
