<%-- 
    Document   : logout
    Created on : 16 Sep, 2018, 3:19:43 PM
    Author     : aakashwin8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    session.invalidate();
    response.sendRedirect("http://localhost:8080/Tut4");
%>