<%-- 
    Document   : delstud
    Created on : 17 Sep, 2018, 12:13:32 AM
    Author     : aakashwin8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="conn.jsp" %>
<%    if (session.getAttribute("stud_id") != null && session.getAttribute("stud_email") != null && session.getAttribute("Type") != null) {
        //session is running
        String type = session.getAttribute("Type").toString();
        String stud_id = session.getAttribute("stud_id").toString();
        String stud_email = session.getAttribute("stud_email").toString();
        //check if it is admin or student
        if (type.equals("A")) {
            //it is admin

            String selqry = "SELECT * FROM studdetail WHERE StudId = " + stud_id + " AND Type = '" + type + "' LIMIT 1";

            PreparedStatement stmt = conn.prepareStatement(selqry);
            ResultSet adminrecord = stmt.executeQuery();

            if (adminrecord.next()) {
                //Got Admin Record Continue.
                String studid = request.getParameter("stud_id");
                String del_selqry = "DELETE FROM studdetail WHERE StudId = " + studid;

                PreparedStatement stud_stmt = conn.prepareStatement(del_selqry);
                int studrecord = stud_stmt.executeUpdate();
                response.sendRedirect("http://localhost:8080/Tut4/studentmanage.jsp");

            } else {
                //record not exists.destroy session and redirect to login

                out.print("<script type='text/javascript'>alert('Hey Record Not Found . Try Login Again');</script>");
                session.invalidate();
                response.sendRedirect("http://localhost:8080/Tut4");
            }
        } else {
            //not admin . logout 
            //it is student
            out.println("Error 403 . Access Forbidden");
            out.println("You Will Be Redirect To Login in 3sec");
            Thread.sleep(3000); // sleep 3 seconds
            response.sendRedirect("http://localhost:8080/Tut4/logout.jsp");
        }
    } else {

        //session is not running . logout
        out.println("Error 403 . Access Forbidden");
        out.println("You Will Be Redirect To Login in 3sec");
        Thread.sleep(3000); // sleep 3 seconds
        response.sendRedirect("http://localhost:8080/Tut4/logout.jsp");
    }
%>