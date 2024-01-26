package udream;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class college_finder_panel extends javax.swing.JPanel {

    JFrame cls, callcls;

    public college_finder_panel(JFrame frame,JFrame f) {
        initComponents();
        cls = frame;
        info();
        cb1.setSelectedIndex(-1);
        cb2.setSelectedIndex(-1);
        button();
        callcls=f;
    }

    void info() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select * from study_guide_main_table");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cb1.addItem(rs.getString("country_name"));
            }
            st = con.prepareStatement("SELECT Distinct Department_Name FROM university_info,bsc_courses where university_info.University_Name = bsc_courses.University_Name and Department_Name is Not Null and university_info.Country=?");
            st.setString(1, (String) cb1.getSelectedItem());
            ResultSet rs1 = st.executeQuery();
            while (rs1.next()) {
                cb2.addItem(rs1.getString("Department_Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Masters_clg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Masters_clg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void button() {
        il.setVisible(false);
        tl.setVisible(false);
        pl.setVisible(false);
        itxt.setVisible(false);
        ttxt.setVisible(false);
        ptxt.setVisible(false);
        stm.setVisible(false);
        str.setVisible(false);
        al.setVisible(false);
        mtxt.setVisible(false);
        rtxt.setVisible(false);
        atxt.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        mtxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        atxt = new javax.swing.JTextField();
        il = new javax.swing.JLabel();
        tl = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        al = new javax.swing.JLabel();
        stm = new javax.swing.JLabel();
        str = new javax.swing.JLabel();
        rtxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cb1 = new combo_suggestion.ComboBoxSuggestion();
        cb2 = new combo_suggestion.ComboBoxSuggestion();
        clg = new javax.swing.JTextField();
        school = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        itxt = new javax.swing.JTextField();
        ttxt = new javax.swing.JTextField();
        ptxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Which aptitude test did you take? ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 240, 43));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel2.setText("TAKE US THROUGH YOUR DREAM EDUCATION");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 450, 43));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Where do you want to study? ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 205, 43));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("What are you planning to study? ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 326, 43));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("What is the name of your school? ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 326, 43));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 30, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("What is the name of your College? ");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 326, 43));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("*");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 30, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setText("ACT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 770, 140, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 102, 102));
        jButton2.setText("FInd Universities");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 960, 200, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setText("SAT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 770, 140, 30));

        mtxt.setForeground(new java.awt.Color(102, 102, 102));
        mtxt.setText("Out of 800");
        mtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mtxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mtxtFocusLost(evt);
            }
        });
        mtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mtxtKeyReleased(evt);
            }
        });
        add(mtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 870, 140, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Which English test did you take?");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 230, 43));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("*");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 20, 30));

        atxt.setForeground(new java.awt.Color(102, 102, 102));
        atxt.setText("Out of 36");
        atxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                atxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                atxtFocusLost(evt);
            }
        });
        atxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                atxtKeyReleased(evt);
            }
        });
        add(atxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 870, 140, -1));

        il.setForeground(new java.awt.Color(153, 153, 153));
        il.setText("Score");
        add(il, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 50, -1));

        tl.setForeground(new java.awt.Color(153, 153, 153));
        tl.setText("Score");
        add(tl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 640, 50, -1));

        pl.setForeground(new java.awt.Color(153, 153, 153));
        pl.setText("Score");
        add(pl, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 640, 50, -1));

        al.setForeground(new java.awt.Color(153, 153, 153));
        al.setText("SCORE");
        add(al, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 830, 70, -1));

        stm.setForeground(new java.awt.Color(153, 153, 153));
        stm.setText("MATH SCORE");
        add(stm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 830, 100, -1));

        str.setForeground(new java.awt.Color(153, 153, 153));
        str.setText("READ WRITE SCORE");
        add(str, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 830, 150, -1));

        rtxt.setForeground(new java.awt.Color(102, 102, 102));
        rtxt.setText("Out of 800");
        rtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rtxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rtxtFocusLost(evt);
            }
        });
        rtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rtxtKeyReleased(evt);
            }
        });
        add(rtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 870, 140, -1));

        jLabel12.setText("jLabel12");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 990, -1, -1));
        add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 510, -1));
        add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 510, -1));
        add(clg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 510, 40));
        add(school, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 510, 40));

        jButton4.setBackground(new java.awt.Color(255, 255, 204));
        jButton4.setText("IELTS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 143, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 204));
        jButton5.setText("TOEFL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 143, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 204));
        jButton6.setText("PTE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 144, -1));

        itxt.setForeground(new java.awt.Color(102, 102, 102));
        itxt.setText("Out of 9");
        itxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                itxtFocusLost(evt);
            }
        });
        itxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itxtActionPerformed(evt);
            }
        });
        itxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itxtKeyReleased(evt);
            }
        });
        add(itxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 140, 30));

        ttxt.setForeground(new java.awt.Color(102, 102, 102));
        ttxt.setText("Out of 120");
        ttxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ttxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ttxtFocusLost(evt);
            }
        });
        ttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttxtActionPerformed(evt);
            }
        });
        ttxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ttxtKeyReleased(evt);
            }
        });
        add(ttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 670, 140, 30));

        ptxt.setForeground(new java.awt.Color(102, 102, 102));
        ptxt.setText("Out of 90");
        ptxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ptxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ptxtFocusLost(evt);
            }
        });
        ptxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptxtActionPerformed(evt);
            }
        });
        ptxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ptxtKeyReleased(evt);
            }
        });
        add(ptxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 730, 10, 20));

        jButton7.setBackground(new java.awt.Color(255, 255, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 102, 102));
        jButton7.setText("Go Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 970, 200, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        al.setVisible(true);
        atxt.setVisible(true);
        stm.setVisible(false);
        mtxt.setVisible(false);
        rtxt.setVisible(false);
        str.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    double ielts, toefl, pte, grev, greq, greaw, gretot, gmat;
    boolean mand;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cb1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Select Country that you want to Study");
        } else if (cb2.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Select Course that you want to Study");
        } else if (school.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select your Current University");
        } else if (clg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select the Course that you are Studying");
        } else if (itxt.getText().contains("Out of") && ttxt.getText().contains("Out of") && ptxt.getText().contains("Out of")) {
            JOptionPane.showMessageDialog(null, "Complete Atleast One of your English Score");
        } else {
            if (itxt.getText().contains("Out of")) {
                ielts = -.1;
            } else {
                ielts = Double.parseDouble(itxt.getText());
            }
            if (ttxt.getText().contains("Out of")) {
                toefl = -.1;
            } else {
                toefl = Double.parseDouble(ttxt.getText());
            }
            if (ptxt.getText().contains("Out of")) {
                pte = -.1;
            } else {
                pte = Double.parseDouble(ptxt.getText());
            }
            if (mtxt.getText().contains("Out of")) {
                grev = -.1;
            } else {
                grev = Double.parseDouble(mtxt.getText());
            }
            if (rtxt.getText().contains("Out of")) {
                greq = -.1;
            } else {
                greq = Double.parseDouble(rtxt.getText());
            }
            if (atxt.getText().contains("Out of")) {
                gmat = -.1;
            } else {
                gmat = Double.parseDouble(atxt.getText());
            }
            mand = true;
            System.out.print(ielts + " " + toefl + " " + pte + " " + grev + " " + greq + " " + gmat);
            Masters_University_Suggesion ob = new Masters_University_Suggesion(ielts, toefl, pte, grev, greq, gmat, "Bachelors Program", (String) cb2.getSelectedItem(), (String) cb1.getSelectedItem(), mand);
            ob.setVisible(true);
            cls.dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        stm.setVisible(true);
        mtxt.setVisible(true);
        rtxt.setVisible(true);
        str.setVisible(true);
        al.setVisible(false);
        atxt.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void mtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mtxtKeyReleased
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != 8) {
            JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 800");
            mtxt.setText("");
        } else {
            if (!mtxt.getText().isEmpty()) {
                double d = Double.parseDouble(mtxt.getText());
                if (d < 0 || d > 800) {
                    JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 800");
                    mtxt.setText("");
                }
            }
        }
    }//GEN-LAST:event_mtxtKeyReleased

    private void rtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rtxtKeyReleased
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != 8) {
            JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 800");
            rtxt.setText("");
        } else {
            if (!rtxt.getText().isEmpty()) {
                double d = Double.parseDouble(rtxt.getText());
                if (d < 0 || d > 800) {
                    JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 800");
                    rtxt.setText("");
                }
            }
        }
    }//GEN-LAST:event_rtxtKeyReleased

    private void atxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atxtKeyReleased
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != 8) {
            JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 36");
            atxt.setText("");
        } else {
            if (!atxt.getText().isEmpty()) {
                double d = Double.parseDouble(atxt.getText());
                if (d < 0 || d > 36) {
                    JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 36");
                    atxt.setText("");
                }
            }
        }
    }//GEN-LAST:event_atxtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        il.setVisible(true);
        tl.setVisible(false);
        pl.setVisible(false);
        itxt.setVisible(true);
        ttxt.setVisible(false);
        ptxt.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        il.setVisible(false);
        tl.setVisible(true);
        pl.setVisible(false);
        itxt.setVisible(false);
        ttxt.setVisible(true);
        ptxt.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        il.setVisible(false);
        tl.setVisible(false);
        pl.setVisible(true);
        itxt.setVisible(false);
        ttxt.setVisible(false);
        ptxt.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void itxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itxtFocusGained
        itxt.setText("");
        itxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_itxtFocusGained

    private void itxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itxtFocusLost
        if (itxt.getText().isEmpty()) {
            itxt.setText("Out of 9");
            itxt.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_itxtFocusLost

    private void itxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itxtActionPerformed

    }//GEN-LAST:event_itxtActionPerformed

    private void itxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itxtKeyReleased
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && (c != 8 && c != 46)) {
            JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 9");
            itxt.setText("");
        } else {
            if (!itxt.getText().isEmpty()) {
                double d = Double.parseDouble(itxt.getText());
                if (d < 0 || d > 9) {
                    JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 9");
                    itxt.setText("");
                }
            }
        }
    }//GEN-LAST:event_itxtKeyReleased

    private void ttxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ttxtFocusGained
        ttxt.setText("");
        ttxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_ttxtFocusGained

    private void ttxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ttxtFocusLost
        if (ttxt.getText().isEmpty()) {
            ttxt.setText("Out of 120");
            ttxt.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_ttxtFocusLost

    private void ttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttxtActionPerformed

    }//GEN-LAST:event_ttxtActionPerformed

    private void ttxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttxtKeyReleased
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != 8) {
            JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 120");
            ttxt.setText("");
        } else {
            if (!ttxt.getText().isEmpty()) {
                double d = Double.parseDouble(ttxt.getText());
                if (d < 0 || d > 120) {
                    JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 120");
                    ttxt.setText("");
                }
            }
        }
    }//GEN-LAST:event_ttxtKeyReleased

    private void ptxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ptxtFocusGained
        ptxt.setText("");
        ptxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_ptxtFocusGained

    private void ptxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ptxtFocusLost
        if (ptxt.getText().isEmpty()) {
            ptxt.setText("Out of 90");
            ptxt.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_ptxtFocusLost

    private void ptxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptxtActionPerformed

    }//GEN-LAST:event_ptxtActionPerformed

    private void ptxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ptxtKeyReleased
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != 8) {
            JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 90");
            ptxt.setText("");
        } else {
            if (!ptxt.getText().isEmpty()) {
                double d = Double.parseDouble(ptxt.getText());
                if (d < 0 || d > 90) {
                    JOptionPane.showMessageDialog(null, "Numeric characters from 0 to 90");
                    ptxt.setText("");
                }
            }
        }
    }//GEN-LAST:event_ptxtKeyReleased

    private void mtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mtxtFocusGained
        mtxt.setText("");
        mtxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_mtxtFocusGained

    private void rtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rtxtFocusGained
        rtxt.setText("");
        rtxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_rtxtFocusGained

    private void atxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_atxtFocusGained
        atxt.setText("");
        atxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_atxtFocusGained

    private void mtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mtxtFocusLost
        if (mtxt.getText().isEmpty()) {
            mtxt.setText("Out of 90");
            mtxt.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_mtxtFocusLost

    private void rtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rtxtFocusLost
        if (rtxt.getText().isEmpty()) {
            rtxt.setText("Out of 90");
            rtxt.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_rtxtFocusLost

    private void atxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_atxtFocusLost
        if (atxt.getText().isEmpty()) {
            atxt.setText("Out of 90");
            atxt.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_atxtFocusLost

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
          callcls.setVisible(true);
        cls.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel al;
    private javax.swing.JTextField atxt;
    private combo_suggestion.ComboBoxSuggestion cb1;
    private combo_suggestion.ComboBoxSuggestion cb2;
    private javax.swing.JTextField clg;
    private javax.swing.JLabel il;
    private javax.swing.JTextField itxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mtxt;
    private javax.swing.JLabel pl;
    private javax.swing.JTextField ptxt;
    private javax.swing.JTextField rtxt;
    private javax.swing.JTextField school;
    private javax.swing.JLabel stm;
    private javax.swing.JLabel str;
    private javax.swing.JLabel tl;
    private javax.swing.JTextField ttxt;
    // End of variables declaration//GEN-END:variables
}
