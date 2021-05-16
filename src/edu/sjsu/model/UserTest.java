package edu.sjsu.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void getAccounts() {
        User u1 = new User("Bob", "123");
        ArrayList<Account> accounts = u1.getAccounts();
        assertEquals(u1.getAccounts(), accounts);
    }

    @Test
    public void getUser() {
        User u1 = new User("Bob", "123");
        String userName = "Bob";
        assertEquals(u1.getUserName(), userName);
    }

    @Test
    public void getPass() {
        User u1 = new User("Bob", "123");
        String pass = "123";
        assertEquals(u1.getPassword(), pass);
    }

}
