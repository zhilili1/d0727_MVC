package com.iwb.DAO;

import com.iwb.pojo.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> list();
    boolean add(Category category);
    boolean delete(String id);
    boolean update(Category category);
    Category get(String id);
    boolean verifyUsername(String username);
}
