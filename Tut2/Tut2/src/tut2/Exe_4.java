/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tut2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.sql.*;

/**
 *
 * @author rushikwin8
 */
public class Exe_4 implements ActionListener {

    JButton btn_delete, btn_insert, btn_update, btn_view;
    JLabel lbl_mark1, lbl_mark2, lbl_mark3, lbl_roll_no, lbl_s_name;
    JTextArea txt_area_view;
    JTextField txt_mark1, txt_mark2, txt_mark3, txt_roll_no, txt_s_name;
    int count = 0, stud_no, m1, m2, m3, sum;
    double per;

    String s = "", grd;
    Connection con = null;
    ResultSet rs = null;

    public static void main(String args[]) {
        Exe_4 obj = new Exe_4();
        obj.createGUI();
    }

    public void createGUI() {
        JFrame frame = new JFrame("Student Result Form");
//Layout Of Main Window
        Container c = frame.getContentPane();
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        c.setLayout(new DefaultMenuLayout(c, DefaultMenuLayout.Y_AXIS));
        lbl_roll_no = new JLabel("Roll No : ");
        lbl_s_name = new JLabel("Student Name : ");
        lbl_mark1 = new JLabel("Mark 1 : ");
        lbl_mark2 = new JLabel("Mark 2 : ");
        lbl_mark3 = new JLabel("Mark 3 : ");
        txt_roll_no = new JTextField("", 15);
        txt_roll_no.setEditable(false);
        txt_s_name = new JTextField("", 30);
        txt_s_name.setEditable(false);
        txt_mark1 = new JTextField("", 30);
        txt_mark2 = new JTextField("", 30);
        txt_mark3 = new JTextField("", 30);
        JPanel pnlInput = new JPanel(new GridLayout(5, 2));
        pnlInput.add(lbl_roll_no);
        pnlInput.add(txt_roll_no);
        pnlInput.add(lbl_s_name);
        pnlInput.add(txt_s_name);
        pnlInput.add(lbl_mark1);
        pnlInput.add(txt_mark1);
        pnlInput.add(lbl_mark2);
        pnlInput.add(txt_mark2);
        pnlInput.add(lbl_mark3);
        pnlInput.add(txt_mark3);
        btn_insert = new JButton("Insert");
        btn_insert.addActionListener(this);
        btn_update = new JButton("Update");
        btn_update.addActionListener(this);
        btn_delete = new JButton("Delete");
        btn_delete.addActionListener(this);
        btn_view = new JButton("View");
        btn_view.addActionListener(this);
        JPanel pnlBut = new JPanel(new GridLayout(1, 4));
        pnlBut.add(btn_insert);
        pnlBut.add(btn_update);
        pnlBut.add(btn_delete);
        pnlBut.add(btn_view);
        txt_area_view = new JTextArea(10, 30);
        txt_area_view.setEditable(false);
        JPanel pnlView = new JPanel(new GridLayout(1, 2));
        pnlView.add(txt_area_view);
        frame.add(pnlInput);
        frame.add(pnlBut);
        frame.add(pnlView);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Insert")) {
            insertData();
        } else if (cmd.equals("Update")) {
            updateData();
        } else if (cmd.equals("Delete")) {
            deleteData();
        } else if (cmd.equals("View")) {
            viewData();
        }
    }

    public void databaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
        } catch (Exception e) {
            txt_area_view.setText("Database Not Connected!!!!");
        }
    }

    public void markPerGrd() {
        m1 = Integer.valueOf(txt_mark1.getText()).intValue();
        m2 = Integer.valueOf(txt_mark2.getText()).intValue();
        m3 = Integer.valueOf(txt_mark3.getText()).intValue();
        sum = m1 + m2 + m3;
        per = sum / 3;
        if (m1 >= 35 && m2 >= 35 && m3 >= 35) {
            if (per >= 90) {
                grd = "A+";
            } else if (per >= 80 && per <= 90) {
                grd = "A";
            } else if (per >= 70 && per <= 80) {
                grd = "B";
            } else if (per >= 60 && per <= 70) {
                grd = "C";
            } else if (per >= 50 && per <= 60) {
                grd = "D";
            } else {
                grd = "E";
            }
        } else {
            per = 0;
            grd = "Fail";
        }
    }

    public void printDetails(int param) {
        if (param == 1) {
            s += "\nStudent Roll No : " + txt_roll_no.getText();
            s += "\nStudent Name : " + txt_s_name.getText();
            s += "\nMark 1 : " + txt_mark1.getText();
            s += "\nMark 2 : " + txt_mark2.getText();
            s += "\nMark 3 : " + txt_mark3.getText();
            s += "\nTotal : " + sum;
            s += "\nPersentage : " + per + "%";
            s += "\nGrade : " + grd;
        }
        if (param == 2) {
            try {
                s += "\nStudent Roll No : " + rs.getString(1);
                s += "\nStudent Name : " + rs.getString(2);
                s += "\nMark 1 : " + rs.getString(3);
                s += "\nMark 2 : " + rs.getString(4);
                s += "\nMark 3 : " + rs.getString(5);
                s += "\nTotal : " + rs.getString(6);
                s += "\nPersentage : " + rs.getString(7) + "%";
                s += "\nGrade : " + rs.getString(8);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        txt_area_view.setText(s);
    }

    public void emptyControls() {
        txt_roll_no.setText("");
        txt_s_name.setText("");
        txt_mark1.setText("");
        txt_mark2.setText("");
        txt_mark3.setText("");
    }

    public void insertData() {
        txt_area_view.setText("");
        databaseConnection();
        if (count == 0) {
            try {
                String sql = "select * from student_details where stud_id = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                stud_no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student Roll Number : "));
                prest.setInt(1, stud_no);
                rs = prest.executeQuery();
                if(rs.next()){
                    txt_roll_no.setText(rs.getString(1));
                    txt_s_name.setText(rs.getString(2));
                
                }else{
                    txt_area_view.setText("Roll Number Not Found!!!!");
                }
                prest.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (count == 1) {
            try {
                String sql = "insert into student_marksheet values(?,?,?,?,?,?,?)";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setInt(1, stud_no);
                prest.setInt(2, Integer.parseInt(txt_mark1.getText()));
                prest.setInt(3, Integer.parseInt(txt_mark2.getText()));
                prest.setInt(4, Integer.parseInt(txt_mark3.getText()));
                markPerGrd();
                prest.setInt(5, sum);
                prest.setDouble(6, per);
                prest.setString(7, grd);
                int in_count = prest.executeUpdate();
                if (in_count == 1) {
                    s = "Inserted Record Is : ";
                    printDetails(1);
                }
                prest.close();
                con.close();
            } catch (SQLException ie) {
                ie.printStackTrace();
                txt_area_view.setText("Student Roll No is Already Excites !");
            } catch (NumberFormatException ine) {
                ine.printStackTrace();
                txt_area_view.setText("Please Insert Values !!!! ");
            }
            count = 2;
        }
        if (count == 0) {
            count = 1;
        }
        if (count == 2) {
            count = 0;
            emptyControls();
        }
    }

    public void updateData() {
        txt_area_view.setText("");
        databaseConnection();
        if (count == 0) {
            try {
                String sql = "SELECT sm.stud_id,sd.stud_name,sm.mark1,sm.mark2,sm.mark3 FROM `student_marksheet` as sm left join `student_details` as sd on sm.stud_id = sd.stud_id where sm.stud_id = ?";
                PreparedStatement prest = con.prepareStatement(sql);
                stud_no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student Roll Number : "));
                prest.setInt(1, stud_no);
                rs = prest.executeQuery();
                while (rs.next()) {
                    txt_roll_no.setText(rs.getString(1));
                    txt_s_name.setText(rs.getString(2));
                    txt_mark1.setText(rs.getString(3));
                    txt_mark2.setText(rs.getString(4));
                    txt_mark3.setText(rs.getString(5));
                }
                prest.close();
                con.close();
            } catch (Exception ue) {
                ue.printStackTrace();
                txt_area_view.setText("Roll Number Not Found!!!!");
            }
        } else if (count == 1) {
            try {
                String sql = "UPDATE `student_marksheet` SET `mark1`=?,`mark2`=?,`mark3`=?,"
                        + "`total`=?,`percentage`=?,`grade`=? WHERE `stud_id` = ? ";
                PreparedStatement prest = con.prepareStatement(sql);
                prest.setInt(1, Integer.parseInt(txt_mark1.getText()));
                prest.setInt(2, Integer.parseInt(txt_mark2.getText()));
                prest.setInt(3, Integer.parseInt(txt_mark3.getText()));
                markPerGrd();
                prest.setInt(4, sum);
                prest.setDouble(5, per);
                prest.setString(6, grd);
                prest.setInt(7, stud_no);
                int in_count = prest.executeUpdate();
                if (in_count == 1) {
                    s = "Updated Record Is : ";
                    printDetails(1);
                }
                prest.close();
                con.close();
            } catch (SQLException upe) {
                upe.printStackTrace();
                txt_area_view.setText("Student Roll No is Already Excites !");
            } catch (NumberFormatException upde) {
                upde.printStackTrace();
                txt_area_view.setText("Please Insert Values !!!! ");
            }
            count = 2;
        }
        if (count == 0) {
            count = 1;
        }
        if (count == 2) {
            count = 0;
            emptyControls();
        }
    }

    public void deleteData() {
        txt_area_view.setText("");
        databaseConnection();
        try {
            String sql = "SELECT sm.stud_id,sd.stud_name,sm.mark1,sm.mark2,sm.mark3,sm.total,sm.percentage,sm.grade FROM `student_marksheet` as sm left join `student_details` as sd on sm.stud_id = sd.stud_id where sm.stud_id = ?";
            PreparedStatement prest = con.prepareStatement(sql);
            stud_no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student Roll Number : "));
            prest.setInt(1, stud_no);
            rs = prest.executeQuery();
            while (rs.next()) {
                s = "Deleted Record Is : ";
                printDetails(2);
            }
            String del_sql = "DELETE FROM `student_marksheet` WHERE stud_id = ?";
            prest = con.prepareStatement(del_sql);
            prest.setInt(1, stud_no);
            prest.executeUpdate();
            prest.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            txt_area_view.setText("Student Roll Number Not Excites !!!!");
        }
    }

    public void viewData() {
        txt_area_view.setText("");
        databaseConnection();
        try {
            String sql = "SELECT sm.stud_id,sd.stud_name,sm.mark1,sm.mark2,sm.mark3,sm.total,sm.percentage,sm.grade "
                    + "FROM `student_marksheet` as sm  join `student_details` as sd on sm.stud_id = sd.stud_id "
                    + "where sd.stud_id = ?";
            PreparedStatement prest = con.prepareStatement(sql);
            stud_no = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student Roll Number : "));
            prest.setInt(1, stud_no);
            rs = prest.executeQuery();
            while (rs.next()) {
                s = "Selected Record Is : ";
                printDetails(2);
            }
            prest.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
            txt_area_view.setText("Student Roll Number Not Excites !!!!");
        }
    }
}
