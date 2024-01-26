/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package udream;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author Rayhan
 */
public class Masters_University_Suggesion extends javax.swing.JFrame {

    /**
     * Creates new form Masters_University_Suggesion
     * @param rs
     */
    public Masters_University_Suggesion(double ielts,double toefl,double pte,double grev,double greq, double greaw, double gmat,String program,String cb2,String cb1,boolean mand) {
            initComponents();
            jTable1.getColumn("University Name").setCellRenderer(new myTableCellRenderer());
          jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
            // info();
            try {
          Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
        PreparedStatement st = con.prepareStatement("SELECT  Distinct( bsc_courses.Course_Name) as Course, bsc_courses.University_Name as University FROM bsc_courses,university_info where ((bsc_courses.ILETS <=? or bsc_courses.TOFEL <=? or bsc_courses.pte <=?) and (bsc_courses.GMAT <=? or (bsc_courses.GRE_VERBAL<=? and bsc_courses.GRE_QUANTS<= ? and bsc_courses.GRE_AWA<=?) or bsc_courses.GRE_TOTAL<=? or mandatory=?)) and bsc_courses.Program_Type = ? and bsc_courses.Department_Name= ?  and university_info.Country= ? and university_info.University_Name = bsc_courses.University_Name");
       st.setDouble(1,ielts);
       st.setDouble(2,toefl);
       st.setDouble(3, pte);
       st.setDouble(4, gmat);
       st.setDouble(5,grev);
       st.setDouble(6,greq);
       st.setDouble(7,greaw);
       st.setDouble(8,(grev+greq+greaw));
       st.setBoolean(9, mand);
       st.setString(10, program);
       st.setString(11, cb2);
       st.setString(12,cb1);
        ResultSet rs = st.executeQuery();
         System.out.print(ielts+" "+toefl+" "+pte+" "+grev+" "+greq+ " "+greaw+" "+gmat+" "+program+ " "+ cb2+ " "+cb1);
         int i =0;
         while(rs.next()){
             i++;
                System.out.println(rs.getString("University") + " "+ rs.getString("Course"));
            JLabel University_name= new JLabel();
            University_name.setFont(new Font("Tahome",Font.BOLD,16));
            Class.forName("com.mysql.cj.jdbc.Driver");
        //    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st1 = con.prepareStatement("SELECT Icon,Ranking FROM university_info where University_Name=?");
            st1.setString(1,rs.getString("University"));
            ResultSet rs2 = st1.executeQuery();
            rs2.next();
            byte[] img = rs2.getBytes("Icon");
            ImageIcon image = new ImageIcon(img);
            Image myimg = image.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
            University_name.setIcon(new ImageIcon(myimg));
            University_name.setText(rs.getString("University"));
            String Ranking=String.valueOf(rs2.getInt("Ranking"));
            String Course = rs.getString("Course");
            //  String tdata[]={Ranking,label,University_Name,Country};
            DefaultTableModel tblmodel= (DefaultTableModel)jTable1.getModel();
            tblmodel.addRow(new Object[]{University_name,Ranking,Course});}
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20); DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
           headerRenderer.setBackground(new Color(255, 204, 0));
         jTable1.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
          jTable1.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
           jTable1.getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
            jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
         jScrollPane1.setViewportBorder(null);
        jScrollPane1.getViewport().setBorder(null);
        jLabel2.setText(jLabel2.getText()+i+")");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Masters_University_Suggesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Masters_University_Suggesion(double ielts,double toefl,double pte,double grev,double greq, double gmat,String program,String cb2,String cb1,boolean mand) {
            initComponents();
            jTable1.getColumn("University Name").setCellRenderer(new myTableCellRenderer());
          jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
            // info();
            try {
          Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
        PreparedStatement st = con.prepareStatement("SELECT  Distinct( bsc_courses.Course_Name) as Course, bsc_courses.University_Name as University FROM bsc_courses,university_info where ((bsc_courses.ILETS <=? or bsc_courses.TOFEL <=? or bsc_courses.pte <=?) and (bsc_courses.ACT <=? or (bsc_courses.SAT_MATH<=? and bsc_courses.SAT_READ_WRITE<= ?) or bsc_courses.SAT_TOTAL<=? or mandatory=?)) and bsc_courses.Program_Type = ? and bsc_courses.Department_Name= ?  and university_info.Country= ? and university_info.University_Name = bsc_courses.University_Name");
       st.setDouble(1,ielts);
       st.setDouble(2,toefl);
       st.setDouble(3, pte);
       st.setDouble(4, gmat);
       st.setDouble(5,grev);
       st.setDouble(6,greq);
       st.setDouble(7,(grev+greq));
       st.setBoolean(8, mand);
       st.setString(9, program);
       st.setString(10, cb2);
       st.setString(11,cb1);
        ResultSet rs = st.executeQuery();
  //       System.out.print(ielts+" "+toefl+" "+pte+" "+grev+" "+greq+ " "+greaw+" "+gmat+" "+program+ " "+ cb2+ " "+cb1);
         int i =0;
         while(rs.next()){
             i++;
                System.out.println(rs.getString("University") + " "+ rs.getString("Course"));
            JLabel University_name= new JLabel();
            University_name.setFont(new Font("Tahome",Font.BOLD,16));
            Class.forName("com.mysql.cj.jdbc.Driver");
        //    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st1 = con.prepareStatement("SELECT Icon,Ranking FROM university_info where University_Name=?");
            st1.setString(1,rs.getString("University"));
            ResultSet rs2 = st1.executeQuery();
            rs2.next();
            byte[] img = rs2.getBytes("Icon");
            ImageIcon image = new ImageIcon(img);
            Image myimg = image.getImage().getScaledInstance(70,70,Image.SCALE_SMOOTH);
            University_name.setIcon(new ImageIcon(myimg));
            University_name.setText(rs.getString("University"));
            String Ranking=String.valueOf(rs2.getInt("Ranking"));
            String Course = rs.getString("Course");
            //  String tdata[]={Ranking,label,University_Name,Country};
            DefaultTableModel tblmodel= (DefaultTableModel)jTable1.getModel();
            tblmodel.addRow(new Object[]{University_name,Ranking,Course});}
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20); DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
           headerRenderer.setBackground(new Color(255, 204, 0));
         jTable1.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
          jTable1.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
           jTable1.getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
            jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
         jScrollPane1.setViewportBorder(null);
        jScrollPane1.getViewport().setBorder(null);
        jLabel2.setText(jLabel2.getText()+i+")");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Masters_University_Suggesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Masters_University_Suggesion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Here's your personalized list of universities recommended by our unique algorithm to match your profile. Start exploring and all the best!");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ambitious Universities (");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setFocusable(false);

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "University Name", "World Ranking", "Course Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.setFocusable(false);
        jTable1.setOpaque(false);
        jTable1.setRowHeight(60);
        jTable1.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Masters_University_Suggesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Masters_University_Suggesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Masters_University_Suggesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Masters_University_Suggesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Masters_University_Suggesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
