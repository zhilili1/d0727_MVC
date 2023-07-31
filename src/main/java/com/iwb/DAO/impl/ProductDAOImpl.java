package com.iwb.DAO.impl;

import com.iwb.DAO.ProductDAO;
import com.iwb.pojo.Category;
import com.iwb.pojo.Product;
import com.iwb.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;


public class ProductDAOImpl implements ProductDAO {
    private QueryRunner qr =new QueryRunner(DruidUtil.getDataSource());
    @Override
    public List<Product> list(String cname) {
        String sql ="select * from product where cname=?";
        try{
            List<Product> productList =qr.query(sql,new BeanListHandler<>(Product.class),cname);
            return productList;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Product product) {
        String sql ="insert into product values(?,?,?,?,?)";
        try{
            int count =qr.update(sql,product.getId(),product.getName(),product.getPrice(),product.getStock(),product.getCname());
            return count>0;
        }
        catch (SQLException e)
        {e.printStackTrace();}
        return false;
    }

    @Override
    public boolean delete(String id,String cname) {
        String sql="delete from product where 1=1";
        if (cname==null){
            sql=sql+" and id=?";
        try{
            int count =qr.update(sql,id);
            return count>0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        }
        else if(id==null);
        {
            sql=sql+" and cname=?";
            try{
                int count =qr.update(sql,cname);
                return count>0;
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return  false;
    }

    @Override
    public boolean verifyProductName(String name) {
        String  sql ="select count(*) from product where name =?";
        try {
            Number number = (Number)qr.query(sql,new ScalarHandler<>(),name);
            return number.intValue()>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product get(String id) {
        Product c =null;
        String sql ="select * from product where id=?";
        try {
            c=qr.query(sql,new BeanHandler<>(Product.class),id);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean update(Product product) {
        String sql="update product set name=?,price=?,stock=?,cname=? where id=?";
        try{
            int count =qr.update(sql,product.getName(),product.getPrice(),product.getStock()
            ,product.getCname(),product.getId());
            return count>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }


}
