package com.iwb.controller;

import com.iwb.pojo.User;
import com.iwb.service.UserService;
import com.iwb.service.impl.UserServiceImpl;
import com.iwb.util.FormBeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService =new UserServiceImpl();
    boolean ishaveUser;
    boolean addSuccess;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> paramMap=req.getParameterMap();
        User user= FormBeanUtil.formToBean(paramMap,User.class);
        if (user.getUsername().equals("")||user.getPassword().equals(""))
        {
            req.getSession().setAttribute("registera","用户输入为空");
            resp.sendRedirect("register.jsp");
            return;
        }
        else {
            ishaveUser =userService.addUser(user);
        if (ishaveUser)
        {
            req.getSession().removeAttribute("registera");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            return;
        }
        else {
            req.getSession().setAttribute("registera","用户已存在，请重修注册");
            resp.sendRedirect("register.jsp");
        }
        }

    }
}
