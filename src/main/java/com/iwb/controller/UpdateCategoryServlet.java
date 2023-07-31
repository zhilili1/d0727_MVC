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

@WebServlet("/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {

    private CategoryService cs =new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        Map<String,String[]> paramMap =req.getParameterMap();
        Category c = FormBeanUtil.formToBean(paramMap,Category.class);
        boolean isUpdate =cs.update(c);
        if (isUpdate)
        {
            resp.sendRedirect("listCategory");
        }
        else {
            resp.getWriter().write("更新失败！");
        }
    }
}
