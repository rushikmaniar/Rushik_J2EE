<%-- 
    Document   : register
    Created on : 12 Sep, 2018, 7:14:37 PM
    Author     : aakashwin8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.security.*" %>
<%@page import="java.util.*" %>
<%@page import="java.math.*" %>
<%@include file="conn.jsp" %>
<%    if (session.getAttribute("stud_id") != null && session.getAttribute("stud_email") != null && session.getAttribute("Type") != null) {
        //session is running
        String type = session.getAttribute("Type").toString();

        //check if it is admin or student
        if (type.equals("A")) {
            //it is admin
            response.sendRedirect("http://localhost:8080/Tut4/studentmanage.jsp");
        } else if (type.equals("S")) {
            //it is student
            response.sendRedirect("http://localhost:8080/Tut4/studprofile.jsp");
        } else {
            out.print("<script type='text/javascript'>alert('Something Went Wrong . Try Later');</script>");
        }
    } else {
        //session is not running , check for post data
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            //there is post data .check to database and set session
            String username = request.getParameter("username");
            String pas = request.getParameter("password");
            String StudNm = request.getParameter("StudNm");
            String address = request.getParameter("address");
            String contact = request.getParameter("contact");
            String DeptNo = request.getParameter("DeptNo");

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pas.getBytes(), 0, pas.length());
            pas = new BigInteger(1, md.digest()).toString(16);

            String selqry = "SELECT * FROM studdetail WHERE stud_email = '" + username + "'";

            PreparedStatement stmt = conn.prepareStatement(selqry);
            ResultSet rset = stmt.executeQuery();

            if (rset.next()) {

                //record already exists
                out.print("<script type='text/javascript'>alert('Record Already Exists .Try Other username !');</script>");
                
            } else {

                //no record found . continue to insert data
                String insert_qry = "INSERT INTO studdetail (stud_email,stud_pass,StudNm,Address,Contact,Type,DeptNo)"
                        + " VALUES ("
                        + "'" + username + "',"
                        + "'" + pas + "',"
                        + "'" + StudNm + "',"
                        + "'" + address + "',"
                        + contact + ","
                        + "'S',"
                        + DeptNo
                        + ")";
                PreparedStatement stud_stmt = conn.prepareStatement(insert_qry);
                int studrecord = stud_stmt.executeUpdate();
                response.sendRedirect("http://localhost:8080/Tut4");        
            }
        } else {
            //nothing

        }

    }
    String dept_selqry = "SELECT * FROM department_master";

    PreparedStatement dept_stmt = conn.prepareStatement(dept_selqry);
    ResultSet dept_rset = dept_stmt.executeQuery();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
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
            <div class="col-md-12"><h1 align="center">Register Page</h1></div>
        </div>
        <form method="post" id="signupfrm" action="">

            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered table-hover table-light" style="width: 50%;height: 20%;" align="center">
                        <tr>
                            <td>Enter Username</td>
                            <td><input type="text" class="form-control" name="username"></td>
                        </tr>
                        <tr>
                            <td>Enter Password</td>
                            <td><input type="password" class="form-control" name="password"></td>
                        </tr>
                        <tr>
                            <td>Enter First Name</td>
                            <td><input type="text" class="form-control" name="StudNm"></td>
                        </tr>
                        <tr>
                            <td>Enter Address</td>
                            <td><textarea class="form-control" name="address"></textarea></td>
                        </tr>
                        <tr>
                            <td>Enter Contact</td>
                            <td><input class="form-control" type="text" name="contact"></td>
                        </tr>
                        <tr>
                            <td>Department</td>
                            <td>
                                <select name="DeptNo" class="form-control">
                                    <option value="">-- Select Department -- </option>
                                    <%
                                        while (dept_rset.next()) {  %>  

                                    <option value="<% out.print(dept_rset.getString("DeptNo")); %>"><% out.print(dept_rset.getString("DeptName")); %></option>

                                    <% }%>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><button type="submit" class="btn btn-primary">Sign up</button></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">Already User ? <a href="index.jsp">Login</a></td>
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
                $('#signupfrm').validate({
                    errorclass: 'error',
                    rules: {
                        'username': {
                            required: true
                        },
                        'password': {
                            required: true
                        },
                        'StudNm': {
                            required: true
                        },
                        'address': {
                            required: true
                        },
                        'DeptNo': {
                            required: true
                        },
                        'contact': {
                            required: true,
                            regex: '^[789]\\d{9}$'
                        }
                    },
                    messages: {
                        'username': {
                            required: "This field is required"
                        },
                        'password': {
                            required: "This field is required"
                        },
                        'StudNm': {
                            required: "This field is required"
                        },
                        'address': {
                            required: "This field is required"
                        },
                        'DeptNo': {
                            required: "This field is required"
                        },
                        'contact': {
                            regex: "Mobile No Not valid",
                            required: "This field is required"
                        }
                    }
                });
            });

        </script>
    </body>
</html>
