package com.iwb.service.impl;

import com.iwb.DAO.ProductDAO;
import com.iwb.DAO.impl.ProductDAOImpl;
import com.iwb.pojo.Product;
import com.iwb.service.ProductService;
import com.iwb.util.UUIDUtil;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO =new ProductDAOImpl();
    @Override
    public List<Product> list(String cname) {
        return productDAO.list(cname);
    }

    @Override
    public boolean add(Product product) {
        boolean isExist = productDAO.verifyProductName(product.getName());
        if (isExist)
        {
            return false;
        }
        else {
            product.setId(UUIDUtil.uuid());
            return productDAO.add(product);
        }
    }

    @Override
    public boolean delete(String id,String cname) {

        return productDAO.delete(id,cname);
    }

    @Override
    public Product get(String id) {
        return productDAO.get(id);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }
}
