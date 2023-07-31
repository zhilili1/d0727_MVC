package com.iwb.service.impl;

import com.iwb.DAO.UserDAO;
import com.iwb.DAO.impl.UserDAOImpl;
import com.iwb.pojo.User;
import com.iwb.service.UserService;
import com.iwb.util.MD5Util;
import com.iwb.util.UUIDUtil;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO =new UserDAOImpl();
    @Override
    public User login(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userDAO.login(user);
    }



    @Override
    public boolean addUser(User user) {
        boolean isExist =userDAO.verifyUsername(user.getUsername());
        if (isExist)
        {
            return false;
        }
        else {
        user.setId(UUIDUtil.uuid());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userDAO.addUser(user);
    }}
}
