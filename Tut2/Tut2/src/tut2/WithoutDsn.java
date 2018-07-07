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
public class WithoutDsn {
    public static void main(String[] args) {
        int i;
        Connection conn = null;
        
        //include driver
        try{
            Class.forName("sun.jdbc.odbc.jdbcodbcDriver");
        }catch(Exception e){
            System.out.println(e);
        }
        
        //connect  to Db 
        
        try{
            String con_string = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:\\Rushik\\Rushik_J2EE\\Tut2\\Database\\MyStud.mdb";
                conn = DriverManager.getConnection(con_string,"","");
        }catch(Exception e){
            System.out.println(e);
        }
        
        System.out.println("Connecction Successfull !!");
        
        try {
            String select_query = "SELECT * FROM Student";
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(select_query);
            
            while (rset.next()){
                System.out.println(
                        "Stud ID: " + rset.getInt("Stud_Id") 
                        +"  Stud Name : " + rset.getString("Stud_Name") 
                        + " Birth Date :" + rset.getDate("Birth_Date")
                        + " City :" + rset.getString("City")
                        + " Course : " + rset.getString("Course")
                        + " Semester : " + rset.getString("Semester")
                        + " Division : " + rset.getInt("Division") 
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
