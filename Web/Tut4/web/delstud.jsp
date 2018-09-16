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
            }else{
            
            }
        }
        else{
            
        }
    }else{
    
    }
%>