/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tut1;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class DsnConn {
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
            conn = DriverManager.getConnection("jdbc:odbc:StudDsn");
        }catch(Exception e){
            System.out.println(e);
        }
        
        System.out.println("Connecction Successfull !!");
        
        try {
            String select_query = "SELECT * FROM Student";
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(select_query);
            
            while (rset.next()){
                System.out.println("Roll no:" + rset.getInt("rollno") + " Name : " + rset.getString("stud_name") + " Age :" + rset.getInt("Age"));                
            }
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
}
