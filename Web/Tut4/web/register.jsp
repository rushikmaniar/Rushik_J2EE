<%-- 
    Document   : register
    Created on : 12 Sep, 2018, 7:14:37 PM
    Author     : aakashwin8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                            <td><input type="text" class="form-control" name="password"></td>
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
                        'address': {
                            required: true
                        },
                        'contact': {
                            required: true,
                            regex: '[789]\d{9}'
                        }
                    },
                    messages: {
                        'username': {
                            required: "This field is required"
                        },
                        'password': {
                            required: "This field is required"
                        },
                        'address': {
                            required: "This field is required"
                        },
                        'contact': {
                            regex:  "Mobile No Not valid",
                            required: "This field is required"
                        }
                    }
                });
            });

        </script>
    </body>
</html>
