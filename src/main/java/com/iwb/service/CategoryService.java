package com.iwb.service;

import com.iwb.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    boolean add(Category category);
    boolean delete(String id);
    boolean update(Category category);
    Category get(String id);



}
