package com.example;

import javax.servlet.*;
import java.io.IOException;

public class ContextServlet implements Servlet {
    ServletConfig config ;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext servletContext=config.getServletContext();
        String user=config.getInitParameter("username");
        String username=servletContext.getInitParameter("username");
        System.out.println(user+username);

        String path = servletContext.getContextPath();
        System.out.println(path);

        String realpath = servletContext.getRealPath("/index.jsp");
        System.out.println(realpath);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
