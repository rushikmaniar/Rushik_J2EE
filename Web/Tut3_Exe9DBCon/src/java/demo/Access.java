/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rushikwin8
 */
public class Access extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //Class.forName("sun.jdbc.odbc.jdbcodbcDriver");
            Class.forName("com.microsoft.sqlserver.jdbc");
            String con_string = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\Bca\\sem5\\J2EE\\Rushik_J2EE\\Web\\Tut3_Exe9DBCon\\Database\\MyStud.mdb";
              Connection  con = DriverManager.getConnection(con_string,"","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Student_Details");
            out.print("<title>Mysql</title>");
            out.print("<h1 align=\"center\">Student Data</h1>");
            out.print("<table border=\"1\" align=\"center\" width=\"50%\"><tr>");
            out.print("<th>Student ID</th>");
            out.print("<th>Student Name</th>");
            out.print("<th>Birth Date</th>");
            out.print("<th>City</th>");
            out.print("<th>Course</th>");
            out.print("<th>Semester</th>");
            out.print("<th>Division</th>");
            out.print("</tr>");
            while (rs.next()) {
                out.print("<tr><td>" + rs.getString("Stud_Id") + "</td>");
                out.print("<td>" + rs.getString("Stud_Name") + "</td>");
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String Birth_Date = formatter.format(rs.getDate("Birth_Date"));
                out.print("<td>" + Birth_Date + "</td>");
                out.print("<td>" + rs.getString("City") + "</td>");
                out.print("<td>" + rs.getString("Course") + "</td>");
                out.print("<td>" + rs.getString("Semester") + "</td>");
                out.print("<td>" + rs.getString("Division") + "</td></tr>");
            }
            out.print("</table>");
            out.print("<p align=\"center\"><a href=\"index.jsp\">Back</a>");
            out.close();
            rs.close();
            con.close();
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Access.class.getName()).log(Level.SEVERE, null, ex);
        }
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
