/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exe5package;

import demo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "tut3_5_ValidateUser", urlPatterns = {"/tut3_5_ValidateUser"})
public class tut3_5_ValidateUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet tut3_5_ValidateUser</title>");
            out.println("</head>");
            out.println("<body>");
            
            String username, password;
            username = request.getParameter("username");
            password = request.getParameter("password");

            if (username == null || password == null || username.equals("") || password.equals("")) {
                out.println("<h3>enter Username And Passowrd</h3>");
            } else {
                out.println("<h3>Username :" + username + "</h3><br>");
                out.println("<h3>Password :" + password + "</h3><br>");
            }

            out.println("<form method='post' id='form1'>");
            out.println("<table border=5>"
                    + "<tr>"
                    + "<td>UserName</td>"
                    + "<td><input type='text' name='username'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<tr><td>Password :</td>"
                    + "<td><input type='password' name='password'></td>"
                    + "</tr>"
                    + "<td colspan=2 align='center'><input type='submit' value='submit'></td>"
                    + "</table>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
