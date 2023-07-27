package com.iwb.service.impl;

import com.iwb.DAO.CategoryDAO;
import com.iwb.DAO.impl.CategoryDAOImpl;
import com.iwb.pojo.Category;
import com.iwb.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO =new CategoryDAOImpl();

    @Override
    public List<Category> list() {
        return  categoryDAO.list();
    }
}
