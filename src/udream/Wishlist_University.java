package udream;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import scrollbar.ScrollBarCustom;
import scrollclspackage.CourseCls;

public class Wishlist_University extends javax.swing.JFrame {

    String user, pass, fname, lname;

    public Wishlist_University() {
        initComponents();

        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jTable1.getColumn("University Name").setCellRenderer(new myTableCellRenderer());
        jScrollPane1.setBorder(createEmptyBorder());
        callcls = new HOME();
     
        this.getContentPane().setBackground(new Color(255, 255, 204));
        this.setLocationRelativeTo(null);
       read_info();
        info();

    }
    public String u_name;

   public void read_info() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            currentDirectory += "\\src\\udream\\unsername.txt";
            File myObj = new File(currentDirectory );
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                u_name=data;
                 
            }
            myReader.close();
        } catch (FileNotFoundException e) {

        }
    }

    public Wishlist_University(JFrame f) {
        initComponents();
        
        callcls = f;
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jTable1.getColumn("University Name").setCellRenderer(new myTableCellRenderer());
        jScrollPane1.setBorder(createEmptyBorder());
       
        this.getContentPane().setBackground(new Color(255, 255, 204));
        this.setLocationRelativeTo(null);
        read_info();
        info();
        

    }
    JFrame callcls;

    void info() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select wishlist.University_Name, wishlist.Course_Name , university_info.Ranking, university_info.Icon from wishlist,university_info where wishlist.University_Name = university_info.University_Name and wishlist.User_Name = ? Order by university_info.Ranking");
            st.setString(1, u_name);
            System.out.println(u_name);
            ResultSet rs = st.executeQuery();
           
            int i = 0;
            while (rs.next()) {
                i++;
                 JLabel University_name = new JLabel();
            University_name.setFont(new Font("Tahome", Font.BOLD, 16));
                if (rs.getBytes("Icon") != null) {
                    byte[] img = rs.getBytes("Icon");
                    ImageIcon image = new ImageIcon(img);
                    Image myimg = image.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                    University_name.setIcon(new ImageIcon(myimg));
                }
                University_name.setText(rs.getString("University_Name"));
                String Ranking = String.valueOf(rs.getInt("Ranking"));
                String Course = rs.getString("Course_Name");
                //  String tdata[]={Ranking,label,University_Name,Country};
                DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
                tblmodel.addRow(new Object[]{University_name, Ranking, Course});
            }
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(new Color(255, 204, 0));
            jTable1.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
            jTable1.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
            jTable1.getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
            jScrollPane1.setOpaque(false);
            jScrollPane1.getViewport().setOpaque(false);
            jScrollPane1.setViewportBorder(null);
            jScrollPane1.getViewport().setBorder(null);
            jLabel2.setText(jLabel2.getText() + i + ")");
        } catch (Exception ex) {
            System.out.println("SSS");
            Logger.getLogger(Wishlist_University.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel15.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 255));
        jLabel15.setText("Go To HomePage>>");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Wishlist Universities (");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

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
        jTable1.setCellSelectionEnabled(true);
        jTable1.setFocusable(false);
        jTable1.setOpaque(false);
        jTable1.setRowHeight(60);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        Object obj2 = jTable1.getModel().getValueAt(i, 0);
        JLabel ob = new JLabel();
        ob = (JLabel) obj2;
        String s = ob.getText();
        obj2 = jTable1.getModel().getValueAt(i, 2);
        String s1 = (String) obj2;
       wishlistcls a = new wishlistcls(s, s1, this);
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        callcls.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wishlist_University().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
