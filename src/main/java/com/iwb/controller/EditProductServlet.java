package com.iwb.controller;

import com.iwb.pojo.Product;
import com.iwb.service.ProductService;
import com.iwb.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
    private ProductService ps =new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product p =ps.get(id);
        req.setAttribute("p",p);
        req.getRequestDispatcher("editProduct.jsp").forward(req,resp);
    }



}
