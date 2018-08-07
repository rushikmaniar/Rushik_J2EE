/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Admin
 */
public class Tut3_3_lifecycle extends HttpServlet {

    public static int count = 0;

    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        count = 0;
        getServletContext().log("init() called");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().log("service() called");
        count++;
        response.getWriter().write("Incrementing the count: Count = " + count);
    }

    public void destroy() {
        getServletContext().log("destroyed() called");
    }
}
