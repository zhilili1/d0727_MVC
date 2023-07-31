package com.iwb.DAO;

import com.iwb.pojo.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> list(String cname);
    boolean add(Product product);
    boolean delete(String id,String cname);
    boolean verifyProductName(String name);
    Product get(String id);
    boolean update(Product product);


}
