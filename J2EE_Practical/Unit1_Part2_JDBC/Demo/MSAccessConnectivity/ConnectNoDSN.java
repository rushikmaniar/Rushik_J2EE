package demo;
/**
 *
 * @author Dr. Sharon V. Mohtra
 */
import java.sql.*;
public class ConnectNoDSN {
    //JDBC-ODBC Dsn less connection package demo;  
    public static void main(String[] args)  
    {   
        int i;
        Connection conn = null;   
        // register jdbc driver   
        try{    
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
        } 
        catch(ClassNotFoundException e) 
        {   System.out.println(e);             
        }             
        // connect to DB             
        try{                     
            String myDB ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:/MyDb.mdb";
            conn = DriverManager.getConnection(myDB,"","");              
        } 
        catch(SQLException se) {                     
            System.out.println(se);             
        }             
        System.out.println("connection is successful!!!");             
        try{                     
            String selectSQL = "select ID, name from stud";                     
            Statement stmt = conn.createStatement();                       
            ResultSet rset = stmt.executeQuery(selectSQL);          
            while(rset.next()){                             
                System.out.println("RNO: " + rset.getInt(1) + " NAME: " + rset.getString(2));                     
            }                     
            stmt.close();             
        } 
        catch(SQLException se) {                     
                System.out.println(se);             
        }   
    }
}
