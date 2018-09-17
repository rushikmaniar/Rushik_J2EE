<%-- 
    Document   : studProfile
    Created on : 16 Sep, 2018, 12:32:58 PM
    Author     : aakashwin8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="conn.jsp" %>
<%    if (session.getAttribute("stud_id") != null && session.getAttribute("stud_email") != null && session.getAttribute("Type").equals("S")) {
        //session is running
        String stud_id = session.getAttribute("stud_id").toString();
        String stud_email = session.getAttribute("stud_email").toString();
        String type = session.getAttribute("Type").toString();

        String selqry = "SELECT * FROM studdetail WHERE StudId = " + stud_id + " AND Type = '" + type + "' LIMIT 1";

        PreparedStatement stmt = conn.prepareStatement(selqry);
        ResultSet rset = stmt.executeQuery();

        //check if it is admin or student
        if (rset.next()) {
            //Record Exists
            //check if post data 

            if (request.getParameter("studentprofilefrm_stud_email") != null && request.getParameter("studentprofilefrm_stud_id") != null) {
                //update data

                String studentprofilefrm_stud_id = request.getParameter("studentprofilefrm_stud_id");
                String studentprofilefrm_stud_email = request.getParameter("studentprofilefrm_stud_email");
                String studentprofilefrm_StudNm = request.getParameter("studentprofilefrm_StudNm");
                String studentprofilefrm_Address = request.getParameter("studentprofilefrm_Address");
                String studentprofilefrm_Contact = request.getParameter("studentprofilefrm_Contact");
                String studentprofilefrm_DeptNo = request.getParameter("studentprofilefrm_DeptNo");

                String updateqry = "UPDATE studdetail SET stud_email = '" + studentprofilefrm_stud_email + "' , StudNm = '" + studentprofilefrm_StudNm + "' , Address = '" + studentprofilefrm_Address + "' , Contact = " + studentprofilefrm_Contact + " ,DeptNo = " + studentprofilefrm_DeptNo + " WHERE StudId = " + studentprofilefrm_stud_id;
                //out.println(updateqry);
                PreparedStatement update_stmt = conn.prepareStatement(updateqry);
                int update_rset = update_stmt.executeUpdate();
                response.sendRedirect("http://localhost:8080/Tut4/studprofile.jsp");

            } else {

                //display profile page 
                String dept_selqry = "SELECT * FROM department_master";

                PreparedStatement dept_stmt = conn.prepareStatement(dept_selqry);
                ResultSet dept_rset = dept_stmt.executeQuery();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Profile Page</title>
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
                
                <h1 >Hi <%= rset.getString("StudNm") %></h1><br>
                <h3 align="center"><%= rset.getString("StudNm") %> 's Profile</h3>
                <div class="float-right">
                    <a href="logout.jsp"><button class="btn btn-info">Logout</button></a>
                </div>
            </div>
        </div>
        <form method="post" id="studentprofilefrm" action="">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered table-hover table-light" style="width: 50%;height: 20%;" align="center">
                        <tr>
                            <td>Username</td>
                        <input type="hidden" name="studentprofilefrm_stud_id" value="<% out.print(rset.getString("StudId")); %>">
                        <td><input type="text" class="form-control" name="studentprofilefrm_stud_email" readonly="true" value="<% out.print(rset.getString("stud_email")); %>"></td>
                        </tr>
                        <tr>
                            <td>Student Name</td>
                            <td><input type="text" class="form-control" name="studentprofilefrm_StudNm" value="<% out.print(rset.getString("StudNm")); %>"></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td>
                                <textarea class="form-control"  name="studentprofilefrm_Address"><% out.print(rset.getString("Address")); %></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Contact</td>
                            <td><input type="text" class="form-control" name="studentprofilefrm_Contact" value="<% out.print(rset.getString("Contact")); %>"></td>
                        </tr>
                        <tr>
                            <td>Department</td>
                            <td>
                                <select name="studentprofilefrm_DeptNo" class="form-control">
                                    <option value="">-- Select Department -- </option>
                                    <%
                                        while (dept_rset.next()) {%>
                                    <% if (dept_rset.getString("DeptNo").equals(rset.getString("DeptNo"))) {%>
                                    <option value="<% out.print(dept_rset.getString("DeptNo")); %>" selected="selected"><% out.print(dept_rset.getString("DeptName")); %></option>
                                    <%} else {%>
                                    <option value="<% out.print(dept_rset.getString("DeptNo")); %>"><% out.print(dept_rset.getString("DeptName")); %></option>
                                    <%}
                                        }
                                    %>
                                </select>
                            </td>


                        </tr>

                        <tr>
                            <td colspan="2" align="center"><button type="submit" class="btn btn-success">Save</button></td>
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
                $('#studentprofilefrm').validate({
                    errorclass: 'error',
                    rules: {
                        'studentprofilefrm_StudNm': {
                            required: true
                        },
                        'studentprofilefrm_Address': {
                            required: true
                        },
                        'studentprofilefrm_Contact': {
                            required: true
                        },
                        'studentprofilefrm_DeptNo': {
                            required: true
                        }
                    },
                    messages: {
                        'studentprofilefrm_StudNm': {
                            required: "This field is required"
                        },
                        'studentprofilefrm_Address': {
                            required: "This field is required"
                        },
                        'studentprofilefrm_Contact': {
                            required: "This field is required"
                        },
                        'studentprofilefrm_DeptNo': {
                            required: "This field is required"
                        }
                    }
                });
            });

        </script>
    </body>
</html> 
<%
            }

        } else {
            //record not exists.destroy session and redirect to login

            out.print("<script type='text/javascript'>alert('Hey Record Not Found . Try Login Again');</script>");
            session.invalidate();
            response.sendRedirect("http://localhost:8080/Tut4");
        }
    } else {

        //session is not running , Access Forrbidden Redirect to login 
        out.println("Error 403 Forbidden .");
        out.println("You Will Be Redirect To Login in 3sec");
        Thread.sleep(3000); // sleep 3 seconds
        response.sendRedirect("http://localhost:8080/Tut4");
    }

%>

