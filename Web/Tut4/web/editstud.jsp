<%-- 
    Document   : editstud
    Created on : 17 Sep, 2018, 9:05:41 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.security.*" %>
<%@page import="java.util.*" %>
<%@page import="java.math.*" %>
<%@include file="conn.jsp" %>



<html>
    <head>
        <title>Edit | Add student </title>
        <link href="assets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <link href="assets/DataTables/datatables.min.css" type="text/css" rel="stylesheet">
        <style type="text/css">
            .error{
                color: red;
            }
        </style>
        <script src="assets/plugins/jquery/jquery.min.js" type="text/javascript"></script>

        <script src="assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <body>
        <div class="col-md-12">
            <h1 class="h1" align="center">Add / Edit student</h1>
        </div>
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

                        //now check if data in post
                        if (request.getParameter("studentaddeditfrm_stud_email") != null) {
                            //check if add or edit
                            String edit_qry = "";
                            String update_id = request.getParameter("studentaddeditfrm_stud_id");
                            String stud_username = request.getParameter("studentaddeditfrm_stud_email");
                            String stud_pass = "111111";
                            String stud_StudNm = request.getParameter("studentaddeditfrm_StudNm");
                            String stud_Address = request.getParameter("studentaddeditfrm_Address");
                            String stud_Contact = request.getParameter("studentaddeditfrm_Contact");
                            String stud_DeptNo = request.getParameter("studentaddeditfrm_DeptNo");

                            if (request.getParameter("studentaddeditfrm_stud_id") != null) {
                                //edit record check for record exists
                                String checkselqry = "SELECT * FROM studdetail WHERE stud_email = '" + stud_username + "' AND StudId !=" + update_id;

                                PreparedStatement checkstmt = conn.prepareStatement(checkselqry);
                                ResultSet checkrset = checkstmt.executeQuery();
                                if (checkrset.next()) {
                                    //record already Exits
                                    
                                } else {
                                    edit_qry = "UPDATE studdetail "
                                            + "SET stud_email = '" + stud_username + "',"
                                            + " StudNm = '" + stud_StudNm + "',"
                                            + " Address = '" + stud_Address + "',"
                                            + " Contact = " + stud_Contact + ","
                                            + " DeptNo = " + stud_DeptNo
                                            + " WHERE StudId = " + update_id;
                                    PreparedStatement stud_stmt = conn.prepareStatement(edit_qry);
                                    int studrecord = stud_stmt.executeUpdate();
                                }

                            } else {
                                //add record
                                String checkselqry = "SELECT * FROM studdetail WHERE stud_email = '" + stud_username + "'";

                                PreparedStatement checkstmt = conn.prepareStatement(checkselqry);
                                ResultSet checkrset = checkstmt.executeQuery();
                                if (checkrset.next()) {
                                    //record already Exits
                                    
                                } else {
                                    MessageDigest md = MessageDigest.getInstance("MD5");
                                    md.update(stud_pass.getBytes(), 0, stud_pass.length());
                                    stud_pass = new BigInteger(1, md.digest()).toString(16);
                                    String ins_qry = "INSERT INTO studdetail (stud_email,stud_pass,StudNm,Address,Contact,Type,DeptNo)"
                                            + " VALUES ("
                                            + "'" + stud_username + "',"
                                            + "'" + stud_pass + "',"
                                            + "'" + stud_StudNm + "',"
                                            + "'" + stud_Address + "',"
                                            + stud_Contact + ","
                                            + "'S',"
                                            + stud_DeptNo
                                            + ")";
                                    PreparedStatement stud_stmt = conn.prepareStatement(ins_qry);
                                    int studrecord = stud_stmt.executeUpdate();

                                }

                            }

                            response.sendRedirect("http://localhost:8080/Tut4/studentmanage.jsp");
                        } else {
                            //no post data display form 

                            String studid = request.getParameter("stud_id");

                            String dept_selqry = "SELECT * FROM department_master";

                            PreparedStatement dept_stmt = conn.prepareStatement(dept_selqry);
                            ResultSet dept_rset = dept_stmt.executeQuery();

                            ResultSet studrecord = null;
                            //check if edit or update
                            if (studid == null) {
                                //add record

                            } else {
                                //edit record
                                String studselqry = "SELECT * FROM studdetail WHERE StudId = " + studid + " LIMIT 1";

                                PreparedStatement studstmt = conn.prepareStatement(studselqry);
                                studrecord = studstmt.executeQuery();

                                if (studrecord.next()) {
                                    //record found
                                } else {
                                   String error = "Record Not Found !";
                                   
                                     out.print("<script type='text/javascript'>alert('" + error +"');</script>");
                                     response.wait(3000);
                                     response.sendRedirect("http://localhost:8080/Tut4/studentmanage.jsp");
                                }
                            }
        %>
        <form method="post" id="studentaddeditfrm" action="">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered table-hover table-light" style="width: 50%;height: 20%;" align="center">
                        <tr>
                            <td>Username</td>
                            <% if (request.getParameter("stud_id") != null) {%>
                        <input type="hidden" name="studentaddeditfrm_stud_id" value="<% out.print(request.getParameter("stud_id"));%>">                        
                        <% }%>
                        <td><input type="text" class="form-control" name="studentaddeditfrm_stud_email" value="<%= (studrecord != null) ? studrecord.getString("stud_email") : ""%>"></td>
                        </tr>

                        <tr>
                            <td>Student Name</td>
                            <td><input type="text" class="form-control" name="studentaddeditfrm_StudNm" value="<%= (studrecord != null) ? studrecord.getString("StudNm") : ""%>"></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td>
                                <textarea class="form-control"  name="studentaddeditfrm_Address"><%= (studrecord != null) ? studrecord.getString("Address") : ""%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Contact</td>
                            <td><input type="text" class="form-control" name="studentaddeditfrm_Contact" value="<%= (studrecord != null) ? studrecord.getString("Contact") : ""%>"></td>
                        </tr>
                        <tr>
                            <td>Department</td>
                            <td>
                                <select name="studentaddeditfrm_DeptNo" class="form-control">
                                    <option value="">-- Select Department -- </option>
                                    <%
                                        while (dept_rset.next()) {
                                            if (studrecord != null) {
                                                if (dept_rset.getString("DeptNo").equals(studrecord.getString("DeptNo"))) {%>
                                    <option value="<% out.print(dept_rset.getString("DeptNo")); %>" selected="selected"><% out.print(dept_rset.getString("DeptName")); %></option>
                                    <%} else {%>
                                    <option value="<% out.print(dept_rset.getString("DeptNo")); %>"><% out.print(dept_rset.getString("DeptName")); %></option>
                                    <%}
                                    } else {%>
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
        <% }
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
    </body>
    <!-- jquery validation -->
    <script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-validation/js/additional-methods.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#studentaddeditfrm').validate({
                errorclass: 'error',
                rules: {
                    'studentaddeditfrm_StudNm': {
                        required: true
                    },
                    'studentaddeditfrm_stud_pass': {
                        required: true
                    },
                    'studentaddeditfrm_stud_email': {
                        required: true
                    },
                    'studentaddeditfrm_Address': {
                        required: true
                    },
                    'studentaddeditfrm_Contact': {
                        required: true
                    },
                    'studentaddeditfrm_DeptNo': {
                        required: true
                    }
                },
                messages: {
                    'studentaddeditfrm_StudNm': {
                        required: "This field is required"
                    },
                    'studentaddeditfrm_stud_pass': {
                        required: "This field is required"
                    },
                    'studentaddeditfrm_stud_email': {
                        required: "This field is required"
                    },
                    'studentaddeditfrm_Address': {
                        required: "This field is required"
                    },
                    'studentaddeditfrm_Contact': {
                        required: "This field is required"
                    },
                    'studentaddeditfrm_DeptNo': {
                        required: "This field is required"
                    }
                }
            });
        });

    </script>
</head>
</html>
