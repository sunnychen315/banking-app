package edu.sjsu.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserListTest {
    @Test
    public void addUser() {
        UserList ul = new UserList();
        assertFalse(ul.addUser("Bob", "123", "456"));
        assertTrue(ul.addUser("Bob", "123", "123"));

    }

    @Test
    public void validUsername() {
        User u1 = new User("Bob", "123");
        UserList ul = new UserList();
        ul.add(u1);
        assertTrue(ul.validUsername("Bob"));

    }

    @Test
    public void validLogin() {
        User u1 = new User("Bob", "123");
        UserList ul = new UserList();
        ul.add(u1);
        assertTrue(ul.validLogin("Bob", "123"));

    }

}
