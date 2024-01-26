/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package udream;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import scrollbar.ScrollBarCustom;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import scrollclspackage.university_pagecls;

public class CoursePage extends javax.swing.JPanel {

    JFrame cls, callcls;
    String Uni_name;
    String C_name;

    public CoursePage(JFrame frame, String s, String s1) {
        initComponents();
        cls = frame;
        Uni_name = s;
        C_name = s1;
        callcls = new HOME();

        OverviewScroll.setVerticalScrollBar(new ScrollBarCustom());
        RequisiteScroll.setVerticalScrollBar(new ScrollBarCustom());
        info();
        read_info();
        add_to_wish_list();

    }

    public void read_info() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            currentDirectory += "\\src\\udream\\unsername.txt";
            File myObj = new File(currentDirectory);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                u_name = data;

            }
            myReader.close();
        } catch (FileNotFoundException e) {

        }
    }

    public void add_to_wish_list() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("SELECT * FROM project.wishlist where User_Name= ?");
            st.setString(1, u_name);
            ResultSet rs = st.executeQuery();
            boolean f = false;
            while (rs.next()) {
                String un = rs.getString("University_Name");
                String cr = rs.getString("Course_Name");
                 System.out.println(un);
                if (un.equals(Uni_name) && cr.equals(C_name)) {
                    jButton1.setText("Remove from wishlist");
                   
                    f = true;
                    break;
                }

            }
            if (f == false) {
                jButton1.setText("Add To WishList");
            }
        } catch (SQLException | ClassNotFoundException ex) {

        }

    }

    public CoursePage(JFrame frame, String s, String s1, JFrame f) {
        initComponents();
        cls = frame;
        Uni_name = s;
        C_name = s1;
        callcls = f;
        OverviewScroll.setVerticalScrollBar(new ScrollBarCustom());
        RequisiteScroll.setVerticalScrollBar(new ScrollBarCustom());
        info();
        read_info();
        add_to_wish_list();

    }
    public String u_name;

    void info() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
            PreparedStatement st = con.prepareStatement("select * from bsc_courses where University_Name = ? AND  Course_Name = ?");
            st.setString(1, Uni_name);
            st.setString(2, C_name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if(rs.getString("Program_Type").equals("Masters Program")){
                  jLabel39.setText("GRE Total");
                  jLabel34.setText("GRE Verbal"); 
                   sat.setText("GRE Quants");
                    jLabel36.setText("GMAT");
                    if (rs.getDouble("GMAT") == 0 || rs.getDouble("GMAT")==801) {
                    jLabel36.setVisible(false);
                } else {
                    ACT.setText(Double.toString(rs.getDouble("GMAT")));
                }
                if (rs.getDouble("GRE_VERBAL") == 0 || rs.getDouble("GRE_VERBAL")== 171) {
                    jLabel34.setVisible(false);
                } else {
                    Satmath.setText(Double.toString(rs.getDouble("GRE_VERBAL")));
                }
                 if (rs.getDouble("GRE_QUANTS") == 0 || rs.getDouble("GRE_QUANTS") == 171) {
                    sat.setVisible(false);
                } else {
                    Sat.setText(Double.toString(rs.getDouble("GRE_QUANTS")));
                }
                 if (rs.getDouble("GRE_AWA") == 0 || rs.getDouble("GRE_AWA") == 6.1) {
                    jLabel40.setVisible(false);
                } else {
                    greTot.setText(Double.toString(rs.getDouble("GRE_AWA")));
                }
                 if(Satmath.getText().isEmpty() &&  Sat.getText().isEmpty() && (rs.getDouble("GRE_TOTAL") != 0 && rs.getDouble("GRE_TOTAL")!= 347)){
                    sat_tot.setText(Double.toString(rs.getDouble("GRE_TOTAL")));
                }
                else{
                    jLabel39.setVisible(false);
                }
                }
                else{
                     jLabel40.setVisible(false);
                     if (rs.getDouble("SAT_MATH") == 0 || rs.getDouble("SAT_MATH")== 801) {
                    jLabel34.setVisible(false);
                } else {
                    Satmath.setText(Double.toString(rs.getDouble("SAT_Math")));
                }
                if (rs.getDouble("SAT_READ_WRITE") == 0 || rs.getDouble("SAT_READ_WRITE") == 801) {
                    sat.setVisible(false);
                } else {
                    Sat.setText(Double.toString(rs.getDouble("SAT_READ_WRITE")));
                }
                if(Satmath.getText().isEmpty() &&  Sat.getText().isEmpty() && (rs.getDouble("SAT_TOTAL") != 0 && rs.getDouble("SAT_TOTAL")!= 1601)){
                    sat_tot.setText(Double.toString(rs.getDouble("SAT_TOTAL")));
                }
                else{
                    jLabel39.setVisible(false);
                }
                 if (rs.getDouble("ACT") == 0 || rs.getDouble("ACT")==37) {
                    jLabel36.setVisible(false);
                } else {
                    ACT.setText(Double.toString(rs.getDouble("ACT")));
                }
                }
                Course.setText(rs.getString("Course_Name"));
                University.setText(rs.getString("University_Name"));
                PreparedStatement st1 = con.prepareStatement("select * from university_info where University_Name = ?");
                st1.setString(1, Uni_name);
                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) {
                    byte[] img = rs1.getBytes("Icon");
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myimg = im.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
                    ImageIcon ni = new ImageIcon(myimg);
                    imageAvatar1.setImage(ni);
                }
                OverviewTextarea.setText(rs.getString("Overview"));
                Duration.setText(rs.getString("Program_Duration"));
                Course_name.setText(rs.getString("Department_name"));
                ProgramName.setText(rs.getString("Program_Type"));
                Credit.setText(Double.toString(rs.getDouble("Credits")));
                Semester.setText(Integer.toString(rs.getInt("Number_Of_Semester")));
                Annual_Tution.setText("$" + Integer.toString(rs.getInt("Tution_Fees")));
                Full_Tution.setText("$" + Integer.toString((rs.getInt("Tution_Fees") * 4)));
                App_fee.setText("$" + Integer.toString(rs.getInt("Application_Fees")));
                RequisiteArea.setText(rs.getString("Application_Pre_Requisites"));
                
                if (rs.getDouble("ILETS") == 0 || rs.getDouble("ILETS") == 10) {
                    jLabel35.setVisible(false);
                } else {
                    IELTS.setText(Double.toString(rs.getDouble("ILETS")));
                }
                if (rs.getDouble("TOFEL") == 0 || rs.getDouble("TOFEL") == 121) {
                    jLabel38.setVisible(false);
                } else {
                    TOFEL.setText(Double.toString(rs.getDouble("TOFEL")));
                }
                if (rs.getDouble("PTE") == 0 || rs.getDouble("PTE") == 91) {
                    jLabel37.setVisible(false);
                } else {
                    PTE.setText(Double.toString(rs.getDouble("PTE")));
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CoursePage.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        Course = new javax.swing.JLabel();
        University = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imageAvatar1 = new main.ImageAvatar();
        ProgramName = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelRound1 = new test.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        OverviewScroll = new javax.swing.JScrollPane();
        OverviewTextarea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        panelRound2 = new test.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Duration = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Course_name = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Credit = new javax.swing.JTextField();
        Semester = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        panelRound3 = new test.PanelRound();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Full_Tution = new javax.swing.JTextField();
        Annual_Tution = new javax.swing.JTextField();
        panelRound4 = new test.PanelRound();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        App_fee = new javax.swing.JTextField();
        panelRound5 = new test.PanelRound();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        RequisiteScroll = new javax.swing.JScrollPane();
        RequisiteArea = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        sat = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Satmath = new javax.swing.JTextField();
        IELTS = new javax.swing.JTextField();
        ACT = new javax.swing.JTextField();
        Sat = new javax.swing.JTextField();
        TOFEL = new javax.swing.JTextField();
        PTE = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        greTot = new javax.swing.JTextField();
        sat_tot = new javax.swing.JTextField();

        setBackground(new java.awt.Color(250, 250, 202));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Course.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N

        University.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        University.setForeground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("View University >>");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        ProgramName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProgramName.setForeground(new java.awt.Color(153, 153, 153));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 102, 0));
        jLabel33.setText("Go Back >>");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 51));
        jButton1.setText("Add To WishList");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ProgramName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(561, 561, 561))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(University, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addComponent(University, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgramName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(24);
        panelRound1.setRoundBottomRight(24);
        panelRound1.setRoundTopLeft(24);
        panelRound1.setRoundTopRight(24);

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 19)); // NOI18N
        jLabel4.setText("Overview");

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("_____________________________________________________________________________________________________________________________________");

        OverviewScroll.setBorder(null);

        OverviewTextarea.setEditable(false);
        OverviewTextarea.setColumns(20);
        OverviewTextarea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OverviewTextarea.setLineWrap(true);
        OverviewTextarea.setRows(5);
        OverviewTextarea.setWrapStyleWord(true);
        OverviewTextarea.setBorder(null);
        OverviewScroll.setViewportView(OverviewTextarea);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("|");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(101, 101, 101))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OverviewScroll))
                .addGap(40, 40, 40))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(OverviewScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(24);
        panelRound2.setRoundBottomRight(24);
        panelRound2.setRoundTopLeft(24);
        panelRound2.setRoundTopRight(24);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("|");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 20)); // NOI18N
        jLabel7.setText("Course Highlights");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Program Duration");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/duration.PNG"))); // NOI18N
        jLabel10.setText("jLabel10");

        Duration.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Duration.setBorder(null);
        Duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DurationActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Course Name");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/course name.PNG"))); // NOI18N

        Course_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Course_name.setBorder(null);
        Course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Course_nameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Course Credit");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/course credit.PNG"))); // NOI18N
        jLabel14.setText("jLabel14");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Number of  Semester");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/semester number.PNG"))); // NOI18N

        Credit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Credit.setBorder(null);

        Semester.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Semester.setBorder(null);

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("_______________________________________________________________________________________________________________________________________");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(Course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17)))
                .addGap(4, 4, 4)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Duration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Credit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setFocusable(false);
        panelRound3.setRoundBottomLeft(24);
        panelRound3.setRoundBottomRight(24);
        panelRound3.setRoundTopLeft(24);
        panelRound3.setRoundTopRight(24);

        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel19.setText("Tuition Fee");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 102, 0));
        jLabel20.setText("|");

        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("_______________________________________________________________________________________________________________________________________");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Full Course Tution Fee (48 Month)");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Annual Tution Fee");

        Full_Tution.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Full_Tution.setForeground(new java.awt.Color(0, 204, 0));
        Full_Tution.setBorder(null);

        Annual_Tution.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Annual_Tution.setForeground(new java.awt.Color(0, 204, 0));
        Annual_Tution.setBorder(null);
        Annual_Tution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Annual_TutionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(Annual_Tution, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(Full_Tution, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19))
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Annual_Tution, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Full_Tution, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(24);
        panelRound4.setRoundBottomRight(24);
        panelRound4.setRoundTopLeft(24);
        panelRound4.setRoundTopRight(24);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 102, 0));
        jLabel23.setText("|");

        jLabel24.setFont(new java.awt.Font("Segoe UI Emoji", 1, 20)); // NOI18N
        jLabel24.setText("Admission");

        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("_______________________________________________________________________________________________________________________________________");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Application Fee");

        App_fee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        App_fee.setForeground(new java.awt.Color(0, 204, 0));
        App_fee.setBorder(null);

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(App_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(App_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(24);
        panelRound5.setRoundBottomRight(24);
        panelRound5.setRoundTopLeft(24);
        panelRound5.setRoundTopRight(24);

        jLabel27.setFont(new java.awt.Font("Segoe UI Emoji", 1, 20)); // NOI18N
        jLabel27.setText("Pre-Requisities");

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 102, 0));
        jLabel28.setText("|");

        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("__________________________________________________________________________________________________________________________________________");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Test Score Requirements");

        RequisiteScroll.setBackground(new java.awt.Color(255, 255, 255));
        RequisiteScroll.setBorder(null);

        RequisiteArea.setColumns(20);
        RequisiteArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RequisiteArea.setLineWrap(true);
        RequisiteArea.setRows(6);
        RequisiteArea.setWrapStyleWord(true);
        RequisiteArea.setBorder(null);
        RequisiteScroll.setViewportView(RequisiteArea);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("Application Pre-Requisities");

        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("_______________________________________________________________________________________________________________________________________");

        sat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sat.setForeground(new java.awt.Color(153, 153, 153));
        sat.setText("SAT Read/Write ");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 153, 153));
        jLabel34.setText("SAT Math");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("IELTS");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 153, 153));
        jLabel36.setText("ACT");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(153, 153, 153));
        jLabel37.setText("PTE");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jLabel38.setText("TOFEL");

        Satmath.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Satmath.setBorder(null);
        Satmath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SatmathActionPerformed(evt);
            }
        });

        IELTS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IELTS.setBorder(null);

        ACT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ACT.setBorder(null);
        ACT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACTActionPerformed(evt);
            }
        });

        Sat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Sat.setBorder(null);

        TOFEL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TOFEL.setBorder(null);

        PTE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PTE.setBorder(null);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(153, 153, 153));
        jLabel39.setText("SAT Total");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jLabel40.setText("GRE AWA");

        greTot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        greTot.setBorder(null);
        greTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greTotActionPerformed(evt);
            }
        });

        sat_tot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sat_tot.setBorder(null);
        sat_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sat_totActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(RequisiteScroll)
                .addGap(40, 40, 40))
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound5Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(ACT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound5Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sat_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound5Layout.createSequentialGroup()
                                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound5Layout.createSequentialGroup()
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(Satmath, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(140, 140, 140)
                                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelRound5Layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(Sat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(panelRound5Layout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(IELTS, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(140, 140, 140)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(TOFEL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(72, 72, 72)
                                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound5Layout.createSequentialGroup()
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(PTE, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRound5Layout.createSequentialGroup()
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(greTot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 74, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(RequisiteScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(sat_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(Satmath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sat)
                    .addComponent(Sat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(greTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(IELTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(TOFEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(PTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(ACT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DurationActionPerformed

    private void Course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Course_nameActionPerformed

    private void Annual_TutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Annual_TutionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Annual_TutionActionPerformed

    private void SatmathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SatmathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SatmathActionPerformed

    private void ACTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ACTActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        university_pagecls ob = new university_pagecls(Uni_name, cls);
        ob.setVisible(true);
        cls.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        callcls.setVisible(true);
        cls.dispose();
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jButton1.getText() == "Add To WishList") {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
                PreparedStatement st = con.prepareStatement("insert into project.wishlist values(?,?,?)");

                st.setString(1, u_name);
                st.setString(2, Uni_name);
                st.setString(3, C_name);
                st.executeUpdate();
                jButton1.setText("Remove from wishlist");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CoursePage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CoursePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(jButton1.getText()=="Remove from wishlist")
        {
              try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "16ani");
                PreparedStatement st = con.prepareStatement("delete from  project.wishlist where User_Name=? and University_Name=? and Course_Name=? ");

                st.setString(1, u_name);
                st.setString(2, Uni_name);
                st.setString(3, C_name);
                st.executeUpdate();
                jButton1.setText("Add To WishList");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CoursePage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CoursePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void greTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_greTotActionPerformed

    private void sat_totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sat_totActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sat_totActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ACT;
    private javax.swing.JTextField Annual_Tution;
    private javax.swing.JTextField App_fee;
    private javax.swing.JLabel Course;
    private javax.swing.JTextField Course_name;
    private javax.swing.JTextField Credit;
    private javax.swing.JTextField Duration;
    private javax.swing.JTextField Full_Tution;
    private javax.swing.JTextField IELTS;
    private javax.swing.JScrollPane OverviewScroll;
    private javax.swing.JTextArea OverviewTextarea;
    private javax.swing.JTextField PTE;
    private javax.swing.JLabel ProgramName;
    private javax.swing.JTextArea RequisiteArea;
    private javax.swing.JScrollPane RequisiteScroll;
    private javax.swing.JTextField Sat;
    private javax.swing.JTextField Satmath;
    private javax.swing.JTextField Semester;
    private javax.swing.JTextField TOFEL;
    private javax.swing.JLabel University;
    private javax.swing.JTextField greTot;
    private main.ImageAvatar imageAvatar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private test.PanelRound panelRound1;
    private test.PanelRound panelRound2;
    private test.PanelRound panelRound3;
    private test.PanelRound panelRound4;
    private test.PanelRound panelRound5;
    private javax.swing.JLabel sat;
    private javax.swing.JTextField sat_tot;
    // End of variables declaration//GEN-END:variables
}
