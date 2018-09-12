<%-- 
    Document   : index
    Created on : 12 Sep, 2018, 7:08:53 PM
    Author     : aakashwin8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <td><input type="text" class="form-control" name="password"></td>
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
