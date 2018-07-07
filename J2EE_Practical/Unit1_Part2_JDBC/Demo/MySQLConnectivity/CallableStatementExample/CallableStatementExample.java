/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author admin
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//In This call we use only interfaces to refere objects. JDBC Objects class exist in mysql jar file 
public class CallableStatementExample {
    public static void main(String[] args) {
        // jdbc:mysql is protocol by which can be requested to connect with
        // database and 3306 is port number where my server can listen request
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";// mydb is database in mysql
        Connection conn = null;
        CallableStatement stmt = null;// this is CallableStatement reference
        // variable
        try {
        // STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(dbUrl, "root", ""); //any given passwd

        // STEP 4: Execute a query
        System.out.println("Creating statement...");
        String sql = "{call getSName (?, ?)}";
        stmt = conn.prepareCall(sql);

        // Bind IN parameter first, then bind OUT parameter
        int no = 1;
        stmt.setInt(1, no); // This would set ID as 102
        // Because second parameter is OUT so register it
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

        // Use execute method to run stored procedure.
        System.out.println("Executing stored procedure...");
        stmt.execute();

        // Retrieve employee name with getXXX method
        String sname = stmt.getString(2);
        System.out.println("Name with Roll no.:" + no + " is " + sname);
        stmt.close();
        conn.close();
    } catch (SQLException se) {
        // Handle errors for JDBC
        se.printStackTrace();
    } catch (Exception e) {
        // Handle errors for Class.forName
        e.printStackTrace();
    } finally {
        // finally block used to close resources
        try {
            if (stmt != null)
                stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
        try {
            if (conn != null)
            conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// end  try
        }// end finally try
    System.out.println("Exited....!");
    }// end main
}

