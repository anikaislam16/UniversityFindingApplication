
package udream;

import java.awt.Color;
import scrollbar.ScrollBarCustom;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Study_guide_cost extends javax.swing.JPanel {

  String s;
    public Study_guide_cost(String str) {
        initComponents();
       s=str;
         jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
         info();
    }
    void info(){
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
          PreparedStatement st1 = con.prepareStatement("select particular,avg_cost_per_year from study_destination_cost_of_living where country_name =?");
        st1.setString(1,s);
        ResultSet rs1 = st1.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs1));
       jTable2.setBackground(new Color(255,255,255));
         DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
           headerRenderer.setBackground(new Color(153,153,255)); 
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
         jTable2.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
          jTable2.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
          jTable2.getColumnModel().getColumn(1).setHeaderValue("Avarage Cost per Year");
          jTable2.getTableHeader().repaint();
           DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
             headerRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
             
                jTable2.getColumnModel().getColumn(1).setCellRenderer(headerRenderer1);
                   jTable2.getColumnModel().getColumn(0).setCellRenderer(headerRenderer1);
                   //jTable2.getColumnModel().getColumn(1).setMaxWidth(11000);
            jScrollPane2.setOpaque(false);
            jScrollPane2.getViewport().setOpaque(false);
            jScrollPane2.setViewportBorder(null);
            jScrollPane2.getViewport().setBorder(null);
            //  
          
      } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(Study_guide_cost.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(250, 250, 202));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel2.setText("Cost of Living");

        jScrollPane2.setBorder(null);
        jScrollPane2.setFocusable(false);

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setRowHeight(70);
        jTable2.setRowSelectionAllowed(false);
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addGap(328, 328, 328))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
