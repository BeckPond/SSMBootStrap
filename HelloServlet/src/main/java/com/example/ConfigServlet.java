package com.example;

import javax.servlet.*;
import java.io.IOException;

public class ConfigServlet implements Servlet {
    private ServletConfig config ;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String servletName = config.getServletName();
        System.out.println(servletName);
        String username = config.getInitParameter("username");
        System.out.println(username);
        ServletContext context = config.getServletContext();
        System.out.println(context);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
