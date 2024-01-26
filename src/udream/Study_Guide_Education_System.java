package udream;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import scrollbar.ScrollBarCustom;

public class Study_Guide_Education_System extends javax.swing.JPanel {

    String s;

    public Study_Guide_Education_System(String str) {
        initComponents();
        s = str;
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        this.setBackground(new Color(250, 250, 202));
        jLabel2.setText("Education System In " + str);
        jLabel1.setText("Credit System In " + str);
        info();
    }

    void info() {
        try {
            jTable1.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select degree_name as 'Degree',system_name as 'Education System' from study_destination_degree where country_name =?");
            st.setString(1, s);
            ResultSet rs = st.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.setBackground(new Color(255, 255, 255));
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(new Color(153, 153, 255));
             headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
            jTable1.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
            st = con.prepareStatement("select * from study_guide_main_table where country_name =?");
            st.setString(1, s);
            ResultSet rs1 = st.executeQuery();
            rs1.next();
            jLabel13.setText(rs1.getString("credit_undergraduate_per_course"));
            jLabel11.setText(rs1.getString(("credit_undergraduate_total")));
            jLabel14.setText(rs1.getString("credit_graduate_per_course"));
            jLabel12.setText(rs1.getString(("credit_graduate_total")));
            gpa.setText(rs1.getString("gpa_scale"));
            setBackground(new Color(250, 250, 202));
            gpa.setBackground(new Color(250, 250, 202));
            jScrollPane1.setOpaque(false);
            jScrollPane1.getViewport().setOpaque(false);
            jScrollPane1.setViewportBorder(null);
            jScrollPane1.getViewport().setBorder(null);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Study_Guide_Education_System.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        gpa = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(250, 250, 202));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel2.setText("Education System In ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 595, 47));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel3.setText("Types Of Degrees Offer In ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 105, 519, -1));
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 688, 503, 20));
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 834, 503, 30));
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 634, 503, 24));
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 788, 503, 28));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Bachelor's /Undergraduate");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 581, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Avgerage credit per course :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 634, 222, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Average total credit :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 834, 222, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Master's/Graduate");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 734, 141, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Avgerage credit per course :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 788, 222, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("GPA Scaling : ");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 882, 222, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setText("Credit System In USA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 513, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Average total credit :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 688, 222, -1));

        jScrollPane1.setBackground(new java.awt.Color(242, 242, 242));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(80);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 148, 792, 336));

        jScrollPane2.setBackground(new java.awt.Color(242, 242, 242));
        jScrollPane2.setBorder(null);
        jScrollPane2.setFocusable(false);

        gpa.setEditable(false);
        gpa.setColumns(20);
        gpa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gpa.setLineWrap(true);
        gpa.setRows(5);
        gpa.setWrapStyleWord(true);
        gpa.setBorder(null);
        gpa.setCaretColor(new java.awt.Color(242, 242, 242));
        gpa.setDisabledTextColor(new java.awt.Color(242, 242, 242));
        gpa.setFocusable(false);
        jScrollPane2.setViewportView(gpa);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 882, 503, 180));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea gpa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
