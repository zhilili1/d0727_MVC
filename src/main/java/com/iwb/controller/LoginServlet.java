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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String[]>paramMap=req.getParameterMap();
        User user=FormBeanUtil.formToBean(paramMap,User.class);
        if (user.getUsername().equals("")||user.getPassword().equals(""))
        {
            req.getSession().setAttribute("errMsg","用户输入为空");
            resp.sendRedirect("login.jsp");
            return;
        }
        else {
            user=userService.login(user);
            if (user==null)
            {
                req.getSession().setAttribute("errMsg","你的账户密码有错");
                resp.sendRedirect("login.jsp");
                return;
            }
            else
            {

                req.getRequestDispatcher("main.jsp").forward(req,resp);
            }
        }


    }
}
