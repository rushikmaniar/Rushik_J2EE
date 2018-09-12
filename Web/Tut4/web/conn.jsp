<%-- 
    Document   : conn
    Created on : 12 Sep, 2018, 10:53:29 PM
    Author     : aakashwin8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<% 
//connect to database

 Connection conn = null;
try {
            Class.forName("com.mysql.jdbc.Driver");

            String con_string = "jdbc:mysql://localhost:3306/studentmanagement";
            conn = DriverManager.getConnection(con_string, "root", "");
}catch(Exception e){
    out.println(e);
}


%>
