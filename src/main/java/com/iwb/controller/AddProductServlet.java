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

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    private ProductService ps =new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Map<String,String[]> paramMap =req.getParameterMap();
        Product p = FormBeanUtil.formToBean(paramMap,Product.class);
//        req.getSession().setAttribute("addcname",p.getCname());
        String pcname=p.getCname();
        if (p.getName().equals("")||p.getCname().equals("")||p.getPrice().equals("")||p.getStock()==null)
        {
            req.getSession().setAttribute("producta","不能增加空值");
            return;
        }
        else
        {
            boolean flag =ps.add(p);
            if (flag)
            {
                req.getSession().removeAttribute("producta");
                resp.sendRedirect("listProduct?name="+pcname);
            }
            else {
                req.getSession().setAttribute("producta","该商品已存在");
                resp.sendRedirect("listProduct");

            }
        }

    }
}
