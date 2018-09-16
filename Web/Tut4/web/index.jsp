<%-- 
    Document   : index
    Created on : 12 Sep, 2018, 7:08:53 PM
    Author     : aakashwin8
--%>


<%@page import="java.security.*" %>
<%@page import="java.util.*" %>
<%@page import="java.math.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="conn.jsp" %>
<%    if (session.getAttribute("stud_id") != null && session.getAttribute("stud_email") != null &&  session.getAttribute("Type") != null)  {
        //session is running
        String type = session.getAttribute("Type").toString();
    
        //check if it is admin or student
        if(type.equals("A")){
            //it is admin
            response.sendRedirect("http://localhost:8080/Tut4/studentmanage.jsp");
        }
        else if (type.equals("S")){
            //it is student
            response.sendRedirect("http://localhost:8080/Tut4/studprofile.jsp");
        }
        else{
            out.print("<script type='text/javascript'>alert('Something Went Wrong . Try Later');</script>");
        }
    } else {
        //session is not running , check for post data
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            //there is post data .check to database and set session
            String username = request.getParameter("username");
            String pas = request.getParameter("password");
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pas.getBytes(),0,pas.length());
            pas = new BigInteger(1,md.digest()).toString(16);
            
            String selqry = "SELECT * FROM studdetail WHERE stud_email = '" + username + "' AND stud_pass = '" + pas + "' LIMIT 1";
            
            PreparedStatement stmt = conn.prepareStatement(selqry);
            ResultSet rset = stmt.executeQuery();
            
            if (rset.next()) {
                
                //record found set it to session
                session.setAttribute("stud_id", rset.getString("StudId"));
                session.setAttribute("stud_email", rset.getString("stud_email"));
                session.setAttribute("Type", rset.getString("Type"));
                response.sendRedirect("http://localhost:8080/Tut4");
            } else {
                
                //no record found username or passowrd incorrect
                out.print("<script type='text/javascript'>alert('UserName or Password Wrong !');</script>");
            }
        } else {
            //nothing
            
        }
        
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="assets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <script src="assets/plugins/jquery/jquery.min.js" type="text/javascript"></script>

        <script src="assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <style type="text/css">
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-md-12">
                <h1 align="center">Login Page</h1>
            </div>
        </div>
        <form method="post" id="loginfrm" action="">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered table-hover table-light" style="width: 50%;height: 20%;" align="center">
                        <tr>
                            <td>Username</td>
                            <td><input type="text" class="form-control" name="username"></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" class="form-control" name="password"></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><button type="submit" class="btn btn-primary">Sign In</button></td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">Not User ? <a href="register.jsp">Sign Up</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
        <!-- jquery validation -->
        <script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-validation/js/additional-methods.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#loginfrm').validate({
                    errorclass: 'error',
                    rules: {
                        'username': {
                            required: true
                        },
                        'password': {
                            required: true
                        }
                    },
                    messages: {
                        'username': {
                            required: "This field is required"
                        },
                        'password': {
                            required: "This field is required"
                        }
                    }
                });
            });
            
        </script>
    </body>
</html>
