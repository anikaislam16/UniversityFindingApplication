package udream;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import scrollbar.ScrollBarCustom;

public class Show_Available_courses_for_BSc_Of_university extends javax.swing.JFrame {

    public static String uni_name;

    public Show_Available_courses_for_BSc_Of_university() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().setBackground(Color.WHITE);
        update_combobox();
        jComboBox1.setBackground(new Color(255, 255, 204));
        AutoCompleteDecorator.decorate(jComboBox1);
        jComboBox1.setSelectedIndex(-1);
        jList1.setFixedCellHeight(50);
        jList1.setSelectionBackground(new Color(255, 255, 204));
        jList1.setSelectionForeground(Color.BLACK);
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.VERTICAL);
        ScrollBarCustom sp2 = new ScrollBarCustom();
        sp2.setOrientation(JScrollBar.HORIZONTAL);
        jScrollPane1.setVerticalScrollBar(sp1);
        jScrollPane1.setHorizontalScrollBar(sp2);
        callcls = new Admin_Works();
        this.getContentPane().setBackground(new Color(255, 255, 204));
        this.setLocationRelativeTo(null);
    }
    JFrame callcls;

    public Show_Available_courses_for_BSc_Of_university(JFrame f) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        callcls = f;
        this.getContentPane().setBackground(Color.WHITE);
        update_combobox();
        jComboBox1.setBackground(new Color(255, 255, 204));
        AutoCompleteDecorator.decorate(jComboBox1);
        jComboBox1.setSelectedIndex(-1);
        jList1.setFixedCellHeight(50);
        jList1.setSelectionBackground(new Color(255, 255, 204));
        jList1.setSelectionForeground(Color.BLACK);
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.VERTICAL);
        ScrollBarCustom sp2 = new ScrollBarCustom();
        sp2.setOrientation(JScrollBar.HORIZONTAL);
        jScrollPane1.setVerticalScrollBar(sp1);
        jScrollPane1.setHorizontalScrollBar(sp2);
        this.getContentPane().setBackground(new Color(255, 255, 204));
        this.setLocationRelativeTo(null);
    }

    public void update_combobox() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            String sql = "SELECT * FROM project.university_info ";
            /// where country_name='"+country+"'
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("University_Name"));
            }
        } catch (Exception e) {
            System.out.println("DDD");
        }
    }

    public static void showcourses() {
        try {
            DefaultListModel dm = new DefaultListModel();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            String sql = "select Course_Name from bsc_courses where University_name = '" + uni_name + "'";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String ss;
                ss = rs.getString("Course_Name");
                dm.addElement(ss);

            }
            jList1.setModel(dm);
            System.out.println("KKKK");

        } catch (Exception e) {
            System.out.println("nnnnKKKK");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(825, 589));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setBackground(new java.awt.Color(255, 204, 204));
        jList1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 396, 350));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 29, 419, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("ADD NEW COURSES");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 159, 56));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 30));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 204));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 570, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Select University");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 56, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jComboBox1.getSelectedIndex()!=-1) {
            BSc_Courses_Main frame = new BSc_Courses_Main(this, uni_name);
            frame.setVisible(true);
            dispose();
            System.out.println("DD" + uni_name);
            showcourses();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a university");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        callcls.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        String item = (String) jComboBox1.getSelectedItem();
        uni_name = item;
        showcourses();
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(Show_Available_courses_for_BSc_Of_university.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show_Available_courses_for_BSc_Of_university.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show_Available_courses_for_BSc_Of_university.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show_Available_courses_for_BSc_Of_university.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show_Available_courses_for_BSc_Of_university().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}