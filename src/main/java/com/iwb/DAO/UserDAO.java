package com.iwb.DAO;

import com.iwb.pojo.User;

public interface UserDAO {
    User login(User user);
    boolean verifyUsername(String username);
    boolean addUser(User user);
}
