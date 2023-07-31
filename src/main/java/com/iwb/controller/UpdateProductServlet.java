package com.iwb.controller;

import com.iwb.pojo.Product;
import com.iwb.service.ProductService;
import com.iwb.service.impl.ProductServiceImpl;
import com.iwb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    private ProductService ps =new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]> paramMap =req.getParameterMap();
        Product p = FormBeanUtil.formToBean(paramMap,Product.class);
        req.getSession().setAttribute("updatecname",p.getCname());
        boolean isUpdate= ps.update(p);
        if (isUpdate)
        {
            resp.sendRedirect("listProduct");
        }
        else {
            resp.getWriter().write("更新失败！");
        }
    }
}
