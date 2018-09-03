package com.imokhonko.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger (getCurrentClassName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace ("This is doGet");
        req.getRequestDispatcher("page.jsp").forward (req, resp);
    }

    private static String getCurrentClassName() {
        try {
            throw new RuntimeException ();
        } catch (RuntimeException e) {
            return e.getStackTrace ()[1].getClassName ();
        }
    }

}
