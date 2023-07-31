package com.iwb.service;

import com.iwb.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> list(String cname);
    boolean add(Product product);
    boolean delete(String id,String cname);
    Product get(String id);
    boolean update(Product product);

}
