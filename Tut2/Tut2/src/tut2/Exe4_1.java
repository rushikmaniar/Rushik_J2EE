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
            
            /*String select_query = "INSERT into stud values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(select_query);
            stmt.setInt(1,4);
            stmt.setString(2, "Rushik");
            stmt.setInt(3, 18);*/
            
            String select_query = "SELECT Stud_Id,Stud_Name,Birth_Date,City,Course,Semester,Division FROM student_details";
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(select_query);
           
            
            while (rset.next()){
                System.out.println(
                        "Stud_Id: " + rset.getInt("Stud_Id") 
                        +"  Stud Name : " + rset.getString("Stud_Name") 
                        +"  Birth Date : " + rset.getDate("Birth_Date") 
                        +"  City : " + rset.getString("City")
                        +"  Course : " + rset.getString("Course")
                        +"  Semester : " + rset.getString("Semester")
                        +"  Division : " + rset.getInt("Division")                                              
                );                
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }      
    }
}
