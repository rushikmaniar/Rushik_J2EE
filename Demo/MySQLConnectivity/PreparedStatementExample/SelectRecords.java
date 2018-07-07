package app;

import java.sql.*;

public class SelectRecords{
	public static void main(String[] args) {
		System.out.println("Select Records Example by using the Prepared Statement!");
		Connection con = null;
		int count = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			try{
				String sql = "SELECT rno,name FROM stud WHERE rno >= ?";
				PreparedStatement prest = con.prepareStatement(sql);
				prest.setInt(1,2); //1=parameter index and 2 is value(rollno)
				//prest.setInt(2,3);
				ResultSet rs = prest.executeQuery();
				while (rs.next()){
					String name = rs.getString(2);
					int no = rs.getInt(1);
					count++;
					System.out.println(no + "\t" + "- " + name);
				}
				System.out.println("Number of records: " + count);
				prest.close();
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