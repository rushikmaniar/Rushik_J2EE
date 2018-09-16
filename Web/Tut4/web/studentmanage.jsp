<%-- 
    Document   : studentmanage
    Created on : 16 Sep, 2018, 12:33:40 PM
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
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Management Page</title>
        <link href="assets/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <link href="assets/DataTables/datatables.min.css" type="text/css" rel="stylesheet">
        <script src="assets/plugins/jquery/jquery.min.js" type="text/javascript"></script>

        <script src="assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="assets/DataTables/datatables.min.js" type="text/javascript"></script>
        <style type="text/css">
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-md-12">
                <h1 align="center">Student Management Page</h1>
                <div class="float-right">
                    <a href="logout.jsp"><button class="btn btn-info">Logout</button></a>
                </div>
            </div>
            <div class="col-md-12">
                <div class="float-left">
                    <a href="editstud.jsp"><button class="btn btn-primary">Add Student</button></a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12" style="margin-top: 50px">
                <table class="table table-bordered table-hover table-light" id="stud_table" style="width: 50%;height: 20%;white-space: nowrap" align="center">
                    <thead>
                        <tr>
                            <th>Student Id</th>
                            <th>Student Email</th>
                            <th>Student Name</th>
                            <th>Address</th>
                            <th>Contact</th>
                            <th>Department Name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <%
                        String stud_selqry = "SELECT sd.*,dm.DeptName FROM studdetail as sd INNER JOIN department_master as dm ON sd.DeptNo = dm.DeptNo  WHERE Type = 'S'";

                        PreparedStatement stud_stmt = conn.prepareStatement(stud_selqry);
                        ResultSet studrecord = stud_stmt.executeQuery();

                    %>
                    <tbody>
                        <% while (studrecord.next()) {%>
                        <tr>
                            <td><%= studrecord.getString("sd.StudId")%></td>
                            <td><%= studrecord.getString("sd.stud_email")%></td>
                            <td><%= studrecord.getString("sd.StudNm")%></td>
                            <td><%= studrecord.getString("sd.Address")%></td>
                            <td><%= studrecord.getString("sd.Contact")%></td>
                            <td><%= studrecord.getString("dm.DeptName")%></td>
                            <td><a href="editstud.jsp?stud_id=<%= studrecord.getString("sd.StudId")%>"><button class="btn btn-primary">Edit</button></a></td>
                            <td><a href="delstud.jsp?stud_id=<%= studrecord.getString("sd.StudId")%>"><button class="btn btn-danger">Delete</button></a></td>

                        </tr>
                        <% } %>
                    </tbody>

                </table>
            </div>
        </div>

        <!-- jquery validation -->
        <script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-validation/js/additional-methods.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#stud_table').DataTable();

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


<%          } else {
                //record not exists.destroy session and redirect to login

                out.print("<script type='text/javascript'>alert('Hey Record Not Found . Try Login Again');</script>");
                session.invalidate();
                response.sendRedirect("http://localhost:8080/Tut4");
            }

        } else {
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

