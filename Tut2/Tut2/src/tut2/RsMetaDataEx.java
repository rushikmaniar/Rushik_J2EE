/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tut2;

import java.sql.*;

/**
 *
 * @author admin
 */
public class RsMetaDataEx {

    public static void main(String[] args) {
        System.out.println("Getting Column Names Example!");
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/student";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "";
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            try{
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM student_details");
                ResultSetMetaData md = rs.getMetaData();
                int col = md.getColumnCount();
                System.out.println("Number of Column : "+ col);
                System.out.println("Columns Name: ");
                for (int i = 1; i <= col; i++){
                String col_name = md.getColumnName(i);
                System.out.println(col_name);
            }
        }
        catch (SQLException s){
            System.out.println("SQL statement is not executed!");
        }
        }
        catch (Exception e){
        e.printStackTrace();
        }
    }
}

