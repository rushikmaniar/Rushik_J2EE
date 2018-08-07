/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;
import java.io.*;
import javax.servlet.*;

/**
 *
 * @author Admin
 */
public class Tut3_2_GenericServlet extends GenericServlet  {
   public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException{
       res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome to my first generic Web Application</h1>");
            out.println("</body>");
            out.println("</html>");
        }
   }
}
