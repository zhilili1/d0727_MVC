package com.iwb.controller;

import com.iwb.pojo.Category;
import com.iwb.service.CategoryService;
import com.iwb.service.impl.CategoryServiceImpl;
import com.iwb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/editCategory")
public class EditCategoryServlet extends HttpServlet {
    CategoryService cs =new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        Category c =cs.get(id);
        req.setAttribute("c",c);
        req.getRequestDispatcher("editCategory.jsp").forward(req,resp);
    }
}
