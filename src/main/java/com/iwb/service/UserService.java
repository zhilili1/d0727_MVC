package com.iwb.service;

import com.iwb.pojo.User;

public interface UserService {
    User login(User user);
    boolean addUser(User user);
}
