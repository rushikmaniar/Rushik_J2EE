<%-- 
    Document   : index
    Created on : Aug 18, 2018, 8:40:31 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithetic Operations</title>
    </head>
    <body>
        <h1 align="center">Arithmetic Operations</h1>
        <form name="form1" id="form1" action="">
            <table align="center" border="5">
                <tr><td>Enter No1:</td><td><input type="text" name="no1"></td></tr>
                <tr><td>Enter No2:</td><td><input type="text" name="no2"></td></tr>
                <tr><td colspan="2" align="center"><select name="operation">
                            <option value="+">Add</option>
                            <option value="-">sub</option>
                            <option value="*">Mul</option>
                            <option value="/">div</option>
                        </select></td></tr>
                <tr><td colspan="2" align="center"><input type="submit" value="Calculate"></td></tr>
            </table>
        </form>
    </body>
</html>
