package com.iwb.DAO.impl;

import com.iwb.DAO.CategoryDAO;
import com.iwb.pojo.Category;
import com.iwb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Category> list() {
        String sql ="select * from category";
        try {
            List<Category> categoryList =qr.query(sql, new BeanListHandler<>(Category.class));
            return categoryList;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Category category) {
        String sql ="insert into category values(?,?)";
        try {
            int count =qr.update(sql,category.getId(),category.getName());
            return count>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql ="delete from category where id =?";
        try {
            int count =qr.update(sql,id);
            return count>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        String sql ="update category set name=? where id =?";
        try {
            int count =qr.update(sql,category.getName(),category.getId());
            return count>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category get(String id) {
        Category c =null;
        String sql ="select * from category where id=?";
        try {
            c=qr.query(sql,new BeanHandler<>(Category.class),id);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return c;
    }
}
