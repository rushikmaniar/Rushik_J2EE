/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tut2;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class Exe4_1 {
    public static void main(String[] args) {
        int i;
        Connection conn = null;
        
        //include driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
        
        //connect  to Db         
      
            String con_string = "jdbc:mysql://localhost:3306/student";
            conn = DriverManager.getConnection(con_string,"root","");        
            System.out.println("Connection Successfull !!");                
            String select_query = "INSERT into stud values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(select_query);
            stmt.setInt(1,4);
            stmt.setString(2, "Rushik");
            stmt.setInt(3, 18);
            
            int rows = stmt.executeUpdate();
            System.out.println(rows);;
            /*
            while (rset.next()){
                System.out.println(
                        "Stud Rollno: " + rset.getInt("Rollno") 
                        +"  Stud Name : " + rset.getString("Sname") 
                        +"  Stud Age : " + rset.getString("Age") 
                       
                );                
            }*/
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
}
