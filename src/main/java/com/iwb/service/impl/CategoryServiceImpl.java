package com.iwb.service.impl;

import com.iwb.DAO.CategoryDAO;
import com.iwb.DAO.ProductDAO;
import com.iwb.DAO.impl.CategoryDAOImpl;
import com.iwb.DAO.impl.ProductDAOImpl;
import com.iwb.pojo.Category;
import com.iwb.service.CategoryService;
import com.iwb.service.ProductService;
import com.iwb.util.UUIDUtil;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO =new CategoryDAOImpl();
    private ProductDAO productDAO =new ProductDAOImpl();

    @Override
    public List<Category> list() {
        return  categoryDAO.list();
    }

    @Override
    public boolean add(Category category) {
        boolean isExist = categoryDAO.verifyUsername(category.getName());
        if (isExist)
        {
            return false;
        }
        else {
        category.setId(UUIDUtil.uuid());
        return categoryDAO.add(category);
        }
    }

    @Override
    public Category get(String id) {
        return categoryDAO.get(id);
    }

    @Override
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public boolean delete(String id) {
        Category c =categoryDAO.get(id);
        String cname =c.getName();
        productDAO.delete(null,cname);
        return categoryDAO.delete(id);
    }


}
