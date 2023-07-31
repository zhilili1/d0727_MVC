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
import java.util.List;
import java.util.Map;

@WebServlet("/listProduct")
public class SelectProductServlet extends HttpServlet {
    private ProductService ps =new ProductServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname =req.getParameter("name");
        String addCname =(String)req.getSession().getAttribute("addcname");
        String deleteCname =(String)req.getSession().getAttribute("deletecname");
        String updateCname =(String)req.getSession().getAttribute("updatecname");
        if (cname==null)
        {
            if (addCname!=null)
            {
                cname=addCname;
            }
            else if (deleteCname!=null)
            {
                cname =deleteCname;
            }
            else if(updateCname!=null){
                cname = updateCname;
            }
        }
        req.getSession().removeAttribute("addcname");
        req.getSession().removeAttribute("deletecname");
        req.getSession().removeAttribute("updatecname");
        List<Product> p =ps.list(cname);
        req.setAttribute("plist",p);
        req.getRequestDispatcher("listProduct.jsp").forward(req,resp);

    }
}
