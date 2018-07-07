/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcodbcex;

/**
 *
 * @author Dr. Sharon V. Mohtra
 */

import java.sql.*;

public class ConnectWithDSN
{
	public static void main(String[] args)
	{
			int i;
			Connection conn = null;
			// register jdbc driver
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		// connect to DB
		try{
			conn = DriverManager.getConnection("jdbc:odbc:mydsn");
		} catch(SQLException se) {
			System.out.println(se);
		}
		System.out.println("connection is successful!!!");
		try{
			String selectSQL = "select rno, name from stud";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(selectSQL);
			while(rset.next()){
				System.out.println("RNO: " + rset.getInt(1) + " NAME: " + rset.getString(2));
			}
			stmt.close();
			conn.close();
		} catch(SQLException se) {
			System.out.println(se);
		}
	}
}
