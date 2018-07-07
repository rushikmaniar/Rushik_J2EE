/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metadataex;

import java.sql.*;

/**
 *
 * @author admin
 */
public class DbMetaDataEx {

        public static void main(String args[]) {
                try {
                        // Loading database driver
                        Class.forName("com.mysql.jdbc.Driver");

                        // Connecting to the database
                        Connection conn = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/mydb", "root", "");

                        DatabaseMetaData metaData = conn.getMetaData();
                        ResultSet rs = metaData.getTypeInfo();
                        System.out.println("Printing All Premitive DataTypes supported by this Database Applications\n");
                        while (rs.next()) {
                                System.out.println(rs.getString(1));
                        }
                        rs.close();
                        Statement stmt = conn.createStatement();
                        ResultSet resultSet = stmt.executeQuery("SELECT * FROM stud");
                        ResultSetMetaData md = resultSet.getMetaData();
                        System.out.println("\n Fetching Query.............");
                        for (int i = 1; i <= md.getColumnCount(); i++)
                                System.out.print(md.getColumnLabel(i) + " ");
                        System.out.println();
                        while (resultSet.next()) {
                                for (int i = 1; i <= md.getColumnCount(); i++)
                                        System.out.print(resultSet.getString(i) + " ");
                                System.out.println();
                        }
                        resultSet.close();
                        stmt.close();
                        conn.close();
                } catch (SQLException e) {
                        System.out.println(e.toString());
                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}

