package com.iwb.DAO.impl;

import com.iwb.DAO.UserDAO;
import com.iwb.pojo.User;
import com.iwb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    //根据数据源，建立语句执行器
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public User login(User user) {
        String sql ="select * from user where username=? and password=?";
        try{
            user = qr.query(sql,new BeanHandler<>(User.class),user.getUserName(),
                    user.getPassword());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean verifyUsername(String username) {
        return false;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }
}
