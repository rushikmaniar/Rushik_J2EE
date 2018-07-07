/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author admin
 */

//STEP 1. Import required packages
import java.sql.*;

public class DeleteRecords {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/mydb";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   PreparedStatement stmt = null; //Statement stmt;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      //stmt = conn.prepareStatement(); for Statement
      String sql = "DELETE FROM table1 " +
                   "WHERE rno = 3";
      stmt = conn.prepareStatement(sql);
      
      //Bind values into the parameters.
      //stmt.setInt(2, 1);  // This would set rno
      stmt.executeUpdate(sql);

      // Now you can extract all the records
      // to see the remaining records
      sql = "SELECT rno, sname FROM table1";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("rno");
         String first = rs.getString("sname");
         
         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Name: " + first);
         
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Exited!");
}//end main
}//end JDBCExample    
