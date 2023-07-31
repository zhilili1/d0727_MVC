package com.iwb.controller;

import com.iwb.pojo.Product;
import com.iwb.service.CategoryService;
import com.iwb.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
    private CategoryService cs =new CategoryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean isDelete=cs.delete(id);
        if (isDelete) {
            resp.sendRedirect("listCategory");
        }
        else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("有人修改了id");
        }
    }
}
