/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rushikwin8
 */
public class Exe6 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("user_name");
            String pass = request.getParameter("password");
            HttpSession sos = request.getSession(true);
            Date one = new Date(sos.getCreationTime());
            Date two = new Date(sos.getLastAccessedTime());
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Session Example</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=\"center\">Servlet session example</h1>");
            out.println("<table border=\"1\" width=\"50%\" align=\"center\">");
            out.println("<tr><th> Name </th><th>Value</th></tr>");
            out.println("<tr><td> Session id </td><td>" + sos.getId() + "</td></tr>");
            out.println("<tr><td> session creation time</td><td>" + one.toString() + "</td></tr>"); //
            out.println("<tr><td> session Last access time</td><td>" + two.toString() + "</td></tr>");
            out.println("<tr><td> User Name : </td><td>" + name + "</td></tr>");
            out.println("<tr><td> Password : </td><td>" + pass + "</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
