/*
package com.iwb.fitter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class B_AuthorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest)servletRequest;
        HttpServletResponse resp =(HttpServletResponse)servletResponse;
        String uri =req.getRequestURI();
        if (uri.endsWith("login")|uri.endsWith("login.jsp")|uri.endsWith("register")|uri.endsWith("register.jsp"))
        {
            filterChain.doFilter(req,resp);
            return;
        }
        HttpSession session =req.getSession();
        if (session.getAttribute("user")==null)
        {
            resp.sendRedirect("login.jsp");
        }
        else {
            filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
*/
