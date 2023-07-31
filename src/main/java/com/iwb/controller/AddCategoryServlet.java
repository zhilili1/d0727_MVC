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


@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    private CategoryService cs = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String,String[]> paramMap=req.getParameterMap();
        Category c = FormBeanUtil.formToBean(paramMap,Category.class);
        if (c.getName().equals(""))
        {
            req.getSession().setAttribute("categorya","不能增加空值");
            resp.sendRedirect("listCategory");
            return;
        }
        else {
            boolean isadd =cs.add(c);
            if (isadd)
            {
            req.getSession().removeAttribute("categorya");
            resp.sendRedirect("listCategory");
            }
            else {
                req.getSession().setAttribute("categorya","分类已存在");
                resp.sendRedirect("listCategory");


            }
        }

    }
}
