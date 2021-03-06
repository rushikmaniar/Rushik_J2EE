/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tut2;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author rushikwin8
 */
public class Tut2_Exe3 extends javax.swing.JFrame {

    /**
     * Creates new form Tut1_Exe7
     */
    Connection conn;

    public Tut2_Exe3() {
        initComponents();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Rollno = new javax.swing.JLabel();
        jTextField_Rollno = new javax.swing.JTextField();
        jLabel_student_name = new javax.swing.JLabel();
        jTextField_Student_Name = new javax.swing.JTextField();
        jLabel_student_name1 = new javax.swing.JLabel();
        jComboBox_year = new javax.swing.JComboBox<>();
        jComboBox_Month = new javax.swing.JComboBox<>();
        jComboBox_Date = new javax.swing.JComboBox<>();
        jLabel_city = new javax.swing.JLabel();
        jTextField_City = new javax.swing.JTextField();
        jLabel_course = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Course = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_Semester = new javax.swing.JList<>();
        jLabel_Semester = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_Division = new javax.swing.JList<>();
        jLabel_division = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_output = new javax.swing.JTextArea();
        jButton_VIEW = new javax.swing.JButton();
        jButton_DELETE = new javax.swing.JButton();
        jButton_ADD2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_Rollno.setText("Rollno :");

        jLabel_student_name.setText("Student Name :");

        jLabel_student_name1.setText("Birth Date:");

        jComboBox_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1998", "1999", "2000", "2001", "2002" }));

        jComboBox_Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jComboBox_Date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel_city.setText("City :");

        jLabel_course.setText("Course :");

        jList_Course.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "BCA", "MCA", "Msc.iT" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_Course.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList_Course);

        jList_Semester.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5", "6" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_Semester.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList_Semester);

        jLabel_Semester.setText("Semester :");

        jList_Division.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2", "3", "4", "5", "6" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList_Division.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jList_Division);

        jLabel_division.setText("Division:");

        jTextArea_output.setColumns(20);
        jTextArea_output.setRows(5);
        jScrollPane4.setViewportView(jTextArea_output);

        jButton_VIEW.setText("VIEW");
        jButton_VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VIEWActionPerformed(evt);
            }
        });

        jButton_DELETE.setText("DELETE");
        jButton_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DELETEActionPerformed(evt);
            }
        });

        jButton_ADD2.setText("ADD");
        jButton_ADD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ADD2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_student_name1)
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_student_name)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_Rollno)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Rollno, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Student_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_course)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_ADD2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_DELETE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_VIEW))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_Semester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_division)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_city)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_City, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Rollno)
                    .addComponent(jTextField_Rollno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_student_name)
                    .addComponent(jTextField_Student_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_student_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Date)
                    .addComponent(jComboBox_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_city)
                    .addComponent(jTextField_City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_course)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_Semester)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_division)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_VIEW)
                    .addComponent(jButton_DELETE)
                    .addComponent(jButton_ADD2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_VIEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VIEWActionPerformed
        // TODO add your handling code here:

        Integer rollno = Integer.parseInt(JOptionPane.showInputDialog("Enter Rollno "));

        try {
            String select_query = "SELECT sd.Stud_Id,sd.Stud_Name,sd.Birth_Date,sd.City,sd.Course,sd.Semester,sd.Division FROM student_details as sd WHERE sd.Stud_Id = ? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(select_query);

            stmt.setInt(1, rollno);
            System.out.println(stmt);
            ResultSet rset = stmt.executeQuery();

            if (rset.next()) {
                //rset.next();
                String textarea_output = "Stud_Id: " + rset.getInt("Stud_Id")
                        + "\nStud Name : " + rset.getString("Stud_Name")
                        + "\nBirth Date : " + rset.getDate("Birth_Date")
                        + "\nCity : " + rset.getString("City")
                        + "\nCourse : " + rset.getString("Course")
                        + "\nSemester : " + rset.getString("Semester")
                        + "\nDivision : " + rset.getInt("Division");

                jTextArea_output.setText(textarea_output);

            } else {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton_VIEWActionPerformed

    private void jButton_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DELETEActionPerformed
        // TODO add your handling code here:

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure.This will Not revert?", "Warning", dialogButton);

        if (dialogResult == JOptionPane.YES_OPTION) {
            Integer rollno = Integer.parseInt(JOptionPane.showInputDialog("Enter Rollno "));
            System.out.println("Yes");
            // Saving code here
            try {
                String delete_query = "DELETE FROM student_details WHERE  Stud_Id = ?";
                PreparedStatement stmt = conn.prepareStatement(delete_query);
                stmt.setInt(1, rollno);
                System.out.println(stmt);
                Integer result = stmt.executeUpdate();
                System.out.println(result);
                if (result != 0) {
                    JOptionPane.showMessageDialog(null, result.toString() + " Record Deleted", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Deleted", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            //do nothing
        }


    }//GEN-LAST:event_jButton_DELETEActionPerformed

    private void jButton_ADD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ADD2ActionPerformed
        // TODO add your handling code here:
        Integer rollno = Integer.parseInt(jTextField_Rollno.getText());
        String studname = jTextField_Student_Name.getText();
        String birthdate = jComboBox_year.getSelectedItem() + "-" + jComboBox_Month.getSelectedItem() + "-" + jComboBox_Date.getSelectedItem();
        String city = jTextField_City.getText();
        String Course = jList_Course.getSelectedValue();
        Integer semester = Integer.parseInt(jList_Semester.getSelectedValue());
        Integer division = Integer.parseInt(jList_Division.getSelectedValue());

        try {
            String insert_query = "INSERT INTO `student_details` (`Stud_Id`, `Stud_Name`, `Birth_Date`, `City`, `Course`, `Semester`, `Division`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insert_query);
            stmt = conn.prepareStatement(insert_query);
            //bind values 
            stmt.setInt(1, rollno);
            stmt.setString(2, studname);
            stmt.setString(3, birthdate);
            stmt.setString(4, city);
            stmt.setString(5, Course);
            stmt.setInt(6, semester);
            stmt.setInt(7, division);
            String msg = " Row Added";

            Integer result = stmt.executeUpdate();
            System.out.println(result);
            if (result != 0) {
                String outputString = "Rollno: " + jTextField_Rollno.getText();
                outputString += "\n" + "Student Name: " + jTextField_Student_Name.getText();
                outputString += "\n" + "BirthDate: " + jComboBox_Date.getSelectedItem() + "-" + jComboBox_Month.getSelectedItem() + "-" + jComboBox_year.getSelectedItem();
                outputString += "\n" + "City: " + jTextField_City.getText();
                outputString += "\n" + "Course: " + jList_Course.getSelectedValue();
                outputString += "\n" + "Semester: " + jList_Semester.getSelectedValue();
                outputString += "\n" + "Division: " + jList_Division.getSelectedValue();

                jTextArea_output.setText(outputString);
                JOptionPane.showMessageDialog(null, result.toString() + msg, "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No row Update", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops!! " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton_ADD2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tut2_Exe3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tut2_Exe3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tut2_Exe3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tut2_Exe3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tut2_Exe3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ADD2;
    private javax.swing.JButton jButton_DELETE;
    private javax.swing.JButton jButton_VIEW;
    private javax.swing.JComboBox<String> jComboBox_Date;
    private javax.swing.JComboBox<String> jComboBox_Month;
    private javax.swing.JComboBox<String> jComboBox_year;
    private javax.swing.JLabel jLabel_Rollno;
    private javax.swing.JLabel jLabel_Semester;
    private javax.swing.JLabel jLabel_city;
    private javax.swing.JLabel jLabel_course;
    private javax.swing.JLabel jLabel_division;
    private javax.swing.JLabel jLabel_student_name;
    private javax.swing.JLabel jLabel_student_name1;
    private javax.swing.JList<String> jList_Course;
    private javax.swing.JList<String> jList_Division;
    private javax.swing.JList<String> jList_Semester;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea_output;
    private javax.swing.JTextField jTextField_City;
    private javax.swing.JTextField jTextField_Rollno;
    private javax.swing.JTextField jTextField_Student_Name;
    // End of variables declaration//GEN-END:variables
}
