/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tut2;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rushikwin8
 */
public class tut2_2 {

    Connection conn;

    public tut2_2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connect  to Db         
            String con_string = "jdbc:mysql://localhost:3306/student";
            conn = DriverManager.getConnection(con_string, "root", "");
            System.out.println("Connection Successfull !!");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Oops!! " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        tut2_2 obj = new tut2_2();

        int operation = 0;

        while (operation != 5) {
             Scanner sc = new Scanner(System.in);   
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\nStudent Data");
            System.out.println("Select Operation :");

            System.out.println("1.View Record");
            System.out.println("2.Insert Record");
            System.out.println("3.Update Record");
            System.out.println("4.Delete Record");
            System.out.println("5.Exit");
            System.out.print("\u001b[2J");
            System.out.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Operation no:");
                
            try {
                operation = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                System.err.println(e);
            }
            switch (operation) {
                case 1:
                    
                    obj.view_data();
                    System.out.println("Press Enter ");
                    sc.nextLine();
                    break;
                case 2:
                    obj.insert_data();
                    System.out.println("Press Enter ");
                    sc.nextLine();
                    break;
                case 3:
                    obj.update_record();
                    System.out.println("Press Enter ");
                    sc.nextLine();
                    break;
                case 4:
                    obj.delete_record();
                    System.out.println("Press Enter ");
                    sc.nextLine();
                    break;
                case 5:
                    System.exit(0);
                            
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

    }

    public void insert_data() {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Insert Student Data ");

        try {
            System.out.println("Enter StudID :");
            int studid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Stdent Name :");
            String studname = sc.nextLine();
            System.out.println("Enter Birthdate :");
            String birthdate = sc.nextLine();
            System.out.println("Enter City :");
            String city = sc.nextLine();
            System.out.println("Enter Course :");
            String Course = sc.nextLine();
            System.out.println("Enter semester :");
            int sem = sc.nextInt();
            System.out.println("Enter Division :");
            int div = sc.nextInt();

            String insert_query = "INSERT INTO student_details VALUES(" + studid + ",'" + studname + "','" + birthdate + "','" + city + "','" + Course + "'," + sem + "," + div + ")";
            Statement stmt = conn.createStatement();
            Integer rows = stmt.executeUpdate(insert_query);
            if (rows > 0) {
                System.out.println(rows + " Row inserted");
            } else {
                System.out.println("No Rows affected");
            }
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void view_data() {

        try {
            String select_query = "SELECT * FROM student_details";
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(select_query);

            while (rset.next()) {
                System.out.println(
                        "Stud ID: " + rset.getInt("Stud_Id")
                        + "  Stud Name : " + rset.getString("Stud_Name")
                        + " Birth Date :" + rset.getDate("Birth_Date")
                        + " City :" + rset.getString("City")
                        + " Course : " + rset.getString("Course")
                        + " Semester : " + rset.getString("Semester")
                        + " Division : " + rset.getInt("Division")
                );
            }
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }
          
    }

    public void update_record() {

        System.out.println("Enter Studenet Id  To Find :");

        Scanner sc = new Scanner(System.in);

        int rollno = sc.nextInt();

        try {

            String select_query = "SELECT * FROM student_details WHERE Stud_Id = " + rollno;
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(select_query);

            if (rset.next()) {

                System.out.println(
                        "Stud ID: " + rset.getInt("Stud_Id")
                        + "  Stud Name : " + rset.getString("Stud_Name")
                        + " Birth Date :" + rset.getDate("Birth_Date")
                        + " City :" + rset.getString("City")
                        + " Course : " + rset.getString("Course")
                        + " Semester : " + rset.getString("Semester")
                        + " Division : " + rset.getInt("Division")
                );

                System.out.println("Want TO Update this Record ?Yes = 1 No = 0");
                int dec = sc.nextInt();

                if (dec == 1) {
                    System.out.println("Enter StudID :");

                    int studid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Stdent Name :");
                    String studname = sc.nextLine();
                    System.out.println("Enter Birthdate :");
                    String birthdate = sc.nextLine();
                    System.out.println("Enter City :");
                    String city = sc.nextLine();
                    System.out.println("Enter Course :");
                    String Course = sc.nextLine();
                    System.out.println("Enter semester :");
                    int sem = sc.nextInt();
                    System.out.println("Enter Division :");
                    int div = sc.nextInt();

                    String update_query = " UPDATE student_details SET Stud_Id =" + studid + ", Stud_Name = '" + studname + "',Birth_date='" + birthdate + "', City='" + city + "',Course = '" + Course + "', Semester  = " + sem + ", Division = " + div + " WHERE Stud_Id = " + rollno;
                    Statement update_stmt = conn.createStatement();
                    Integer rows = update_stmt.executeUpdate(update_query);
                    if (rows > 0) {
                        System.out.println(rows + " Row update");
                    } else {
                        System.out.println("No Rows affected");
                    }
                } else {
                    // do nothing 
                }

            } else {
                System.out.println(" No Record Found ");
            }
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void delete_record() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Stud_Id To delete :");

        int stud_id = sc.nextInt();

        try {
            String delete_query = "DELETE FROM student_details WHERE Stud_Id = " + stud_id;
            Statement update_stmt = conn.createStatement();
            Integer rows = update_stmt.executeUpdate(delete_query);
            if (rows > 0) {
                System.out.println(rows + " Row Deleted");
            } else {
                System.out.println("No Rows affected");
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
