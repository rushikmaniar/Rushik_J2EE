/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rushikwin8
 */
public class Login extends HttpServlet {

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
            if (!name.equals("")) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Hidden Form Field And URLRewriting</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 align=\"center\">Hidden Form Field And URLRewriting Example</h1>");
                out.println("<table border=\"1\" width=\"50%\" align=\"center\">");
                out.println("<tr><th> Name </th><th>Value</th><th>Change Value</th></tr>");
                out.println("<tr><td> User Name : </td><td>" + name + "</td><td align=\"center\"><a href=\"Change_name_password?user_name='" + name + "'\">Click Me!</a></td></tr>");
                out.println("<tr><td> Password : </td><td>" + name + "</td><td align=\"center\"><a href=\"Change_name_password?user_name='" + name + "'\">Click Me!</a></td></tr>");
                out.println("</table>");
                out.print("<p align=\"center\"><a href=\"index.jsp\">Back</a></p>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.print("Please Enter Username Or Password !!!");
            }
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
