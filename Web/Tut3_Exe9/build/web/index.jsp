<%-- 
    Document   : index
    Created on : Aug 9, 2018, 10:29:12 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fetch Data</title>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <h2>Fetch Data Using : </h2>
                </td>
                <td>
                    <form action="DbConn" method="post">
                        <input type="hidden" name="connectivity" value="Oracle">
                        <input type="submit" name="submit" value="Oracle"/>
                    </form>
                </td>
                <td>
                    <form action="DbConn" method="post">
                        <input type="hidden" name="connectivity" value="Access">
                        <input type="submit" name="submit" value="Access"/>
                    </form>
                </td>
                <td>
                    <form action="DbConn" method="post">
                        <input type="hidden" name="connectivity" value="Mysql">
                        <input type="submit" name="submit" value="Mysql"/>
                    </form></td>
            </tr>
        </table>
    </body>
</html>
