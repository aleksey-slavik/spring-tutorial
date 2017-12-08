package com.globallogic.spring.service;

import com.globallogic.spring.model.Login;
import com.globallogic.spring.model.User;

import java.util.ArrayList;

/**
 * Class with list of registered users
 *
 * @author oleksii.slavik
 */
public class UserService {

    /**
     * List of registered users
     */
    private static ArrayList<User> users = new ArrayList<User>();

    /**
     * Check that user input correct data
     *
     * @param login input data from login page
     * @return user if data is correct, null otherwise
     */
    public static User validateUser(Login login) {
        for (User user : users) {
            if (user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }

        return null;
    }

    /**
     * Add new user to registered users list
     *
     * @param user new user
     */
    public static void registerUser(User user) {
        users.add(user);
    }
}