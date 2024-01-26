/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package udream;

import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class wishlisted_university_bsc_panel extends javax.swing.JPanel {

    String u, c, p_n;
    JFrame cls, callcls;

    public wishlisted_university_bsc_panel(JFrame fr, String uni, String course) {
        initComponents();
        u = uni;
        c = course;
        cls = fr;
        info();
        application_deadline();
        English_test();
        Apptitude_test();
        jScrollPane1.setBorder(createEmptyBorder());
        jScrollPane2.setBorder(createEmptyBorder());
        jScrollPane3.setBorder(createEmptyBorder());
        callcls = new HOME();
       
    }

   

    public wishlisted_university_bsc_panel(JFrame fr, String uni, String course, JFrame f) {
        initComponents();
        u = uni;
        c = course;
        cls = fr;
        info();
        application_deadline();
        English_test();
        Apptitude_test();
        jScrollPane1.setBorder(createEmptyBorder());
        jScrollPane2.setBorder(createEmptyBorder());
        jScrollPane3.setBorder(createEmptyBorder());
        callcls = f;
    }

    void info() {
        try {
            u_name.setText(u);
            c_name.setText(c);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select Program_Type from bsc_courses where University_Name =? and Course_Name = ? ");
            st.setString(1, u);
            st.setString(2, c);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p_name.setText(rs.getString("Program_Type"));
            }
            p_n = rs.getString("Program_Type");
        } catch (SQLException ex) {
            Logger.getLogger(wishlisted_university_bsc_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String s;
    Date fall = null, spring = null, summer = null;
    int[] a = {0, 0, 0};

    void application_deadline() {
        jTable1.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select * from semester_table where University_Name =? and Course_name = ? ");
            st.setString(1, u);
            st.setString(2, c);
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getString("Fall_Final_Date") != null) {
                System.out.println("dfgfdgDDDDDD");
                Calendar cal = Calendar.getInstance();
                Date today = (Date) cal.getTime();
                if (today.compareTo(rs.getDate("Fall_Final_Date")) > 0) {
                    a[0] = 1;
                    s = "Date is Already Expired For Application.\nStay with us for next year Information update";
                    fall = rs.getDate("Fall_Final_Date");
                } else {
                    a[0] = 2;
                    s = dateFormat.format(rs.getDate("Fall_Final_Date"));
                    fall = rs.getDate("Fall_Final_Date");
                    if (rs.getBoolean("Fall_Estimated_Date") == true) {
                        s = s + "(Estimated Date)";
                    }
                }
                DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
                tblmodel.addRow(new Object[]{"Fall Semester", s});
            }
            if (rs.getString("Spring_Final_Date") != null) {
                Calendar cal = Calendar.getInstance();
                Date today = (Date) cal.getTime();
                spring = rs.getDate("Spring_Final_Date");
                if (today.compareTo(rs.getDate("Spring_Final_Date")) > 0) {
                    a[1] = 1;
                    s = "Date is Already Expired For Application.\nStay with us for next year Information update";
                } else {
                    a[1] = 2;
                    s = dateFormat.format(rs.getDate("Spring_Final_Date"));
                    if (rs.getBoolean("Spring_Estimated_Date") == true) {
                        s = s + "(Estimated Date)";
                    }
                }
                DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
                tblmodel.addRow(new Object[]{"Spring Semester", s});
            }
            if (rs.getString("Summer_Final_Date") != null) {
                Calendar cal = Calendar.getInstance();
                Date today = (Date) cal.getTime();
                summer = rs.getDate("Summer_Final_Date");
                if (today.compareTo(rs.getDate("Summer_Final_Date")) > 0) {
                    a[2] = 1;
                    s = "Date is Already Expired For Application.\nStay with us for next year Information update";
                } else {
                    a[2] = 2;
                    s = dateFormat.format(rs.getDate("Summer_Final_Date"));
                    if (rs.getBoolean("Summer_Estimated_Date") == true) {
                        s = s + "(Estimated Date)";
                    }
                }
                DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
                tblmodel.addRow(new Object[]{"Summer Semester", s});
            }
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(new Color(255, 204, 0));
            jTable1.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
            jTable1.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
        } catch (Exception ex) {
            System.out.println("DDDDDDDDDDD");
            Logger.getLogger(wishlisted_university_bsc_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int i;

    void English_test() {
        try {
            String p;
            jTable3.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select * from bsc_courses where University_Name =? and Course_Name = ? ");
            st.setString(1, u);
            st.setString(2, c);
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getDouble("ILETS") != 10) {
                if (rs.getDouble("ILETS") == 0) {
                    p = "Not Mentioned";
                } else {
                    p = Double.toString(rs.getDouble("ILETS"));
                }
                String safe = "";
                Calendar cal = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String ilf = "", ilsp = "", ils = "";
                if (fall != null) {
                    cal.setTime(fall);
                    cal.add(Calendar.DATE, -15);
                    Date il = cal.getTime();
                    ilf = dateFormat.format(il);
                }
                Calendar cal1 = Calendar.getInstance();
                if (spring != null) {
                    cal1.setTime(spring);
                    cal1.add(Calendar.DATE, -15);
                    Date il = cal1.getTime();
                    ilsp = dateFormat.format(il);
                }
                Calendar cal2 = Calendar.getInstance();
                if (summer != null) {
                    cal2.setTime(summer);
                    cal2.add(Calendar.DATE, -15);
                    Date il = cal2.getTime();
                    ils = dateFormat.format(il);
                }
                for (i = 0; i < 3; i++) {
                    if (a[i] == 2) {
                        if (i == 0) {
                            safe = "Fall Session: " + ilf + "\n";
                        }
                        if (i == 1) {
                            safe = safe + "Spring Session: " + ilsp + "\n";
                        }
                        if (i == 2) {
                            safe = safe + "Summer Session: " + ils;
                        }
                    }
                }
                String res = "Paper Based Result: 13 days\nComputer Based Result: 22 days";
                DefaultTableModel tblmodel = (DefaultTableModel) jTable3.getModel();
                tblmodel.addRow(new Object[]{"IELTS", p, res, safe});
            }
            if (rs.getDouble("TOFEL") != 121) {
                if (rs.getDouble("TOFEL") == 0) {
                    p = "Not Mentioned";
                } else {
                    p = Double.toString(rs.getDouble("TOFEL"));
                }
                String safe = "";
                Calendar cal = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String ilf = "", ilsp = "", ils = "";
                if (fall != null) {
                    cal.setTime(fall);
                    cal.add(Calendar.DATE, -15);
                    Date il = cal.getTime();
                    ilf = dateFormat.format(il);
                }
                Calendar cal1 = Calendar.getInstance();
                if (spring != null) {
                    cal1.setTime(spring);
                    cal1.add(Calendar.DATE, -15);
                    Date il = cal1.getTime();
                    ilsp = dateFormat.format(il);
                }
                Calendar cal2 = Calendar.getInstance();
                if (summer != null) {
                    cal2.setTime(summer);
                    cal2.add(Calendar.DATE, -15);
                    Date il = cal2.getTime();
                    ils = dateFormat.format(il);
                }
                for (i = 0; i < 3; i++) {
                    if (a[i] == 2) {
                        if (i == 0) {
                            safe = "Fall Session: " + ilf + "\n";
                        }
                        if (i == 1) {
                            safe = safe + "Spring Session: " + ilsp + "\n";
                        }
                        if (i == 2) {
                            safe = safe + "Summer Session: " + ils;
                        }
                    }
                }
                String res = "15 days";
                DefaultTableModel tblmodel = (DefaultTableModel) jTable3.getModel();
                tblmodel.addRow(new Object[]{"TOEFL", p, res, safe});
            }
            if (rs.getDouble("PTE") != 91) {
                if (rs.getDouble("PTE") == 0) {
                    p = "Not Mentioned";
                } else {
                    p = Double.toString(rs.getDouble("PTE"));
                }
                String safe = "";
                Calendar cal = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String ilf = "", ilsp = "", ils = "";
                if (fall != null) {
                    cal.setTime(fall);
                    cal.add(Calendar.DATE, -15);
                    Date il = cal.getTime();
                    ilf = dateFormat.format(il);
                }
                Calendar cal1 = Calendar.getInstance();
                if (spring != null) {
                    cal1.setTime(spring);
                    cal1.add(Calendar.DATE, -15);
                    Date il = cal1.getTime();
                    ilsp = dateFormat.format(il);
                }
                Calendar cal2 = Calendar.getInstance();
                if (summer != null) {
                    cal2.setTime(summer);
                    cal2.add(Calendar.DATE, -15);
                    Date il = cal2.getTime();
                    ils = dateFormat.format(il);
                }
                for (i = 0; i < 3; i++) {
                    if (a[i] == 2) {
                        if (i == 0) {
                            safe = "Fall Session: " + ilf + "\n";
                        }
                        if (i == 1) {
                            safe = safe + "Spring Session: " + ilsp + "\n";
                        }
                        if (i == 2) {
                            safe = safe + "Summer Session: " + ils;
                        }
                    }
                }
                String res = "2 days";
                DefaultTableModel tblmodel = (DefaultTableModel) jTable3.getModel();
                tblmodel.addRow(new Object[]{"PTE", p, res, safe});
            }
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(new Color(255, 204, 0));
            jTable3.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
            jTable3.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
            jTable3.getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
            jTable3.getColumnModel().getColumn(3).setHeaderRenderer(headerRenderer);

        } catch (SQLException ex) {
            Logger.getLogger(wishlisted_university_bsc_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Apptitude_test() {
        try {
            jTable2.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select * from bsc_courses where University_Name =? and Course_Name = ? ");
            st.setString(1, u);
            st.setString(2, c);
            ResultSet rs = st.executeQuery();
            rs.next();
            if (rs.getBoolean("Mandatory") == true) {
                jLabel12.setVisible(false);
                jScrollPane2.setVisible(false);
                jLabel4.setVisible(false);
            } else {
                String p;
                if (p_n.equals("Bachelors Program")) {
                    if (rs.getDouble("SAT_TOTAL") != 1601) {
                        if (rs.getDouble("SAT_TOTAL") == 0) {
                            p = "Not Mentioned";
                        } else {
                            // System.out.print(rs.getDouble("SAT_MATH"));  
                            if (rs.getDouble("SAT_MATH") != 0 || rs.getDouble("SAT_READ_WRITE") != 0) {
                                p = "SAT Math = " + Double.toString(rs.getDouble("SAT_MATH")) + "\n" + "SAT Read/Write = " + Double.toString(rs.getDouble("SAT_READ_WRITE")) + "\n" + "SAT Total = " + Double.toString(rs.getDouble("SAT_TOTAL"));
                            } else {
                                p = "SAT Total = " + Double.toString(rs.getDouble("SAT_TOTAL"));
                            }
                        }
                        String safe = "";
                        Calendar cal = Calendar.getInstance();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String ilf = "", ilsp = "", ils = "";
                        if (fall != null) {
                            cal.setTime(fall);
                            cal.add(Calendar.DATE, -29);
                            Date il = cal.getTime();
                            ilf = dateFormat.format(il);
                        }
                        Calendar cal1 = Calendar.getInstance();
                        if (spring != null) {
                            cal1.setTime(spring);
                            cal1.add(Calendar.DATE, -29);
                            Date il = cal1.getTime();
                            ilsp = dateFormat.format(il);
                        }
                        Calendar cal2 = Calendar.getInstance();
                        if (summer != null) {
                            cal2.setTime(summer);
                            cal2.add(Calendar.DATE, -29);
                            Date il = cal2.getTime();
                            ils = dateFormat.format(il);
                        }
                        for (i = 0; i < 3; i++) {
                            if (a[i] == 2) {
                                if (i == 0) {
                                    safe = "Fall Session: " + ilf + "\n";
                                }
                                if (i == 1) {
                                    safe = safe + "Spring Session: " + ilsp + "\n";
                                }
                                if (i == 2) {
                                    safe = safe + "Summer Session: " + ils;
                                }
                            }
                        }
                        String res = "2-4 Weeks";
                        DefaultTableModel tblmodel = (DefaultTableModel) jTable2.getModel();
                        tblmodel.addRow(new Object[]{"SAT", p, res, safe});
                    }
                    if (rs.getDouble("ACT") != 37) {
                        if (rs.getDouble("ACT") == 0) {
                            p = "Not Mentioned";
                        } else {
                            p = Double.toString(rs.getDouble("ACT"));
                        }
                        String safe = "";
                        Calendar cal = Calendar.getInstance();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String ilf = "", ilsp = "", ils = "";
                        if (fall != null) {
                            cal.setTime(fall);
                            cal.add(Calendar.DATE, -56);
                            Date il = cal.getTime();
                            ilf = dateFormat.format(il);
                        }
                        Calendar cal1 = Calendar.getInstance();
                        if (spring != null) {
                            cal1.setTime(spring);
                            cal1.add(Calendar.DATE, -56);
                            Date il = cal1.getTime();
                            ilsp = dateFormat.format(il);
                        }
                        Calendar cal2 = Calendar.getInstance();
                        if (summer != null) {
                            cal2.setTime(summer);
                            cal2.add(Calendar.DATE, -56);
                            Date il = cal2.getTime();
                            ils = dateFormat.format(il);
                        }
                        for (i = 0; i < 3; i++) {
                            if (a[i] == 2) {
                                if (i == 0) {
                                    safe = "Fall Session: " + ilf + "\n";
                                }
                                if (i == 1) {
                                    safe = safe + "Spring Session: " + ilsp + "\n";
                                }
                                if (i == 2) {
                                    safe = safe + "Summer Session: " + ils;
                                }
                            }
                        }
                        String res = "3-8 Week";
                        DefaultTableModel tblmodel = (DefaultTableModel) jTable2.getModel();
                        tblmodel.addRow(new Object[]{"ACT", p, res, safe});
                    }
                } else {
                    if (rs.getDouble("GRE_TOTAL") != 347) {
                        if (rs.getDouble("GRE_TOTAL") == 0) {
                            p = "Not Mentioned";
                        } else {
                            // System.out.print(rs.getDouble("SAT_MATH"));  
                            if (rs.getDouble("GRE_VERBAL") != 0 || rs.getDouble("GRE_QUANTS") != 0 || rs.getDouble("GRE_AWA") != 0) {
                                p = "GRE Verbal = " + Double.toString(rs.getDouble("GRE_VERBAL")) + "\n" + "GRE QUANTS = " + Double.toString(rs.getDouble("GRE_QUANTS")) + "\n" + "GRE_AWA = " + Double.toString(rs.getDouble("GRE_AWA"));
                            } else {
                                p = "GRE TOTAL = " + Double.toString(rs.getDouble("GRE_TOTAL"));
                            }
                        }
                        String safe = "";
                        Calendar cal = Calendar.getInstance();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String ilf = "", ilsp = "", ils = "";
                        if (fall != null) {
                            cal.setTime(fall);
                            cal.add(Calendar.DATE, -17);
                            Date il = cal.getTime();
                            ilf = dateFormat.format(il);
                        }
                        Calendar cal1 = Calendar.getInstance();
                        if (spring != null) {
                            cal1.setTime(spring);
                            cal1.add(Calendar.DATE, -17);
                            Date il = cal1.getTime();
                            ilsp = dateFormat.format(il);
                        }
                        Calendar cal2 = Calendar.getInstance();
                        if (summer != null) {
                            cal2.setTime(summer);
                            cal2.add(Calendar.DATE, -17);
                            Date il = cal2.getTime();
                            ils = dateFormat.format(il);
                        }
                        for (i = 0; i < 3; i++) {
                            if (a[i] == 2) {
                                if (i == 0) {
                                    safe = "Fall Session: " + ilf + "\n";
                                }
                                if (i == 1) {
                                    safe = safe + "Spring Session: " + ilsp + "\n";
                                }
                                if (i == 2) {
                                    safe = safe + "Summer Session: " + ils;
                                }
                            }
                        }
                        String res = "10-15 Days";
                        DefaultTableModel tblmodel = (DefaultTableModel) jTable2.getModel();
                        tblmodel.addRow(new Object[]{"GRE", p, res, safe});
                    }
                    if (rs.getDouble("GMAT") != 801) {
                        if (rs.getDouble("GMAT") == 0) {
                            p = "Not Mentioned";
                        } else {
                            p = Double.toString(rs.getDouble("GMAT"));
                        }
                        String safe = "";
                        Calendar cal = Calendar.getInstance();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String ilf = "", ilsp = "", ils = "";
                        if (fall != null) {
                            cal.setTime(fall);
                            cal.add(Calendar.DATE, -22);
                            Date il = cal.getTime();
                            ilf = dateFormat.format(il);
                        }
                        Calendar cal1 = Calendar.getInstance();
                        if (spring != null) {
                            cal1.setTime(spring);
                            cal1.add(Calendar.DATE, -22);
                            Date il = cal1.getTime();
                            ilsp = dateFormat.format(il);
                        }
                        Calendar cal2 = Calendar.getInstance();
                        if (summer != null) {
                            cal2.setTime(summer);
                            cal2.add(Calendar.DATE, -22);
                            Date il = cal2.getTime();
                            ils = dateFormat.format(il);
                        }
                        for (i = 0; i < 3; i++) {
                            if (a[i] == 2) {
                                if (i == 0) {
                                    safe = "Fall Session: " + ilf + "\n";
                                }
                                if (i == 1) {
                                    safe = safe + "Spring Session: " + ilsp + "\n";
                                }
                                if (i == 2) {
                                    safe = safe + "Summer Session: " + ils;
                                }
                            }
                        }
                        String res = "20 Days";
                        DefaultTableModel tblmodel = (DefaultTableModel) jTable2.getModel();
                        tblmodel.addRow(new Object[]{"GMAT", p, res, safe});
                    }
                }
                DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
                headerRenderer.setBackground(new Color(255, 204, 0));
                jTable2.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
                jTable2.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
                jTable2.getColumnModel().getColumn(2).setHeaderRenderer(headerRenderer);
                jTable2.getColumnModel().getColumn(3).setHeaderRenderer(headerRenderer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(wishlisted_university_bsc_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        p_name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        u_name = new javax.swing.JLabel();
        c_name = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel10.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 255));
        jLabel10.setText("Application Deadline");

        p_name.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        p_name.setForeground(new java.awt.Color(204, 0, 255));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 255));
        jLabel2.setText("Course Name:");

        jLabel3.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 255));
        jLabel3.setText("Program Type:");

        jScrollPane1.setBackground(new java.awt.Color(242, 242, 242));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Semester", "Application Deadline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRowHeight(50);
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 255));
        jLabel12.setText("Aptitute Test Requirements");

        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test", "Required Score", "Result", "Safe Date to Complete"
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
        jTable2.setOpaque(false);
        jTable2.setRowHeight(65);
        jTable2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel13.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 255));
        jLabel13.setText("English Test Requirments");

        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test", "Requied Score", "Result", "Safe Date To Complete"
            }
        ));
        jTable3.setFocusable(false);
        jTable3.setRowHeight(65);
        jTable3.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        u_name.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        u_name.setForeground(new java.awt.Color(204, 0, 255));

        c_name.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        c_name.setForeground(new java.awt.Color(204, 0, 255));

        jLabel17.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 255));
        jLabel17.setText("University Name: ");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*Atleast One of the above English Test criteria should be fullfilled");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*Atleast One of the above Apptitude Test criteria should be fullfilled");

        jLabel15.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 255));
        jLabel15.setText("Go Back>>");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(p_name, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(c_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(p_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        Wishlist_University ob = new Wishlist_University();
        ob.setVisible(true);
        cls.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel c_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel p_name;
    private javax.swing.JLabel u_name;
    // End of variables declaration//GEN-END:variables
}
