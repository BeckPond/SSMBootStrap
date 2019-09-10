package com.example;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class servlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("第一个");
        PrintWriter pw = servletResponse.getWriter();
        pw.println("hello,world");
    }

    @Override
    public String getServletInfo() {
        return "abcd";
    }

    @Override
    public void destroy() {

    }
}
