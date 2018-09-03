package com.imokhonko.servlets;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/")
public class HelloServletFilter implements Filter {

    private final static Logger logger = Logger.getLogger (getCurrentClassName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.trace ("This is filter");
        chain.doFilter (request, response);
    }

    @Override
    public void destroy() {

    }

    private static String getCurrentClassName() {
        try {
            throw new RuntimeException ();
        } catch (RuntimeException e) {
            return e.getStackTrace ()[1].getClassName ();
        }
    }

}
