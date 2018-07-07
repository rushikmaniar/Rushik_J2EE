package app;

import java.io.*;
import java.sql.*;

public class InsertRecords{
	public static void main(String[] args) {
		System.out.println("Insert records example using prepared statement!");
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			try{
				String sql = "INSERT table1 VALUES(?,?)";
				PreparedStatement prest = con.prepareStatement(sql);
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter roll no:");
				int no = Integer.parseInt(bf.readLine());
				prest.setInt(1, no);
				
				System.out.println("Enter name:");
				String nm = bf.readLine();
				prest.setString(2, nm);
				
				int count = prest.executeUpdate();
				System.out.println(count + "row(s) affected");
				con.close();
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