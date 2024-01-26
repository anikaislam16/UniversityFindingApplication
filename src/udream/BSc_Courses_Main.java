/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udream;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author User
 */
public class BSc_Courses_Main extends JFrame {

    public BSc_Courses_Main() {
        init();
    }
    public String uni_name;

    public BSc_Courses_Main(String uni_name) {

        this.uni_name = uni_name;
        System.out.println("DffffffffffD" + uni_name);
        init();
    }
    JFrame callcls;

    public BSc_Courses_Main(JFrame f, String uni_name) {

        this.uni_name = uni_name;
        System.out.println("DffffffffffD" + uni_name);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add Courses Information");
        this.setBounds(200, 50, 913, 700);
        //this.getContentPane().setBackground(new Color(255, 255, 204));
        this.setLocationRelativeTo(null);
        JScrollPane jp;
        Bsc_Courses_Panel jpa = new Bsc_Courses_Panel(this, f, uni_name);
        jp = new JScrollPane(jpa);
        this.add(jp);

    }

    public void init() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add Courses Information");
        this.setBounds(200, 50, 913, 700);
         this.getContentPane().setBackground(new Color(255, 255, 204));
        this.setLocationRelativeTo(null);
        JScrollPane jp;
        Bsc_Courses_Panel jpa = new Bsc_Courses_Panel(this, uni_name);
        jp = new JScrollPane(jpa);
        ScrollBarCustom sp = new ScrollBarCustom();
         sp.setOrientation(JScrollBar.VERTICAL);
        jp.setVerticalScrollBar(sp);
         ScrollBarCustom sp1 = new ScrollBarCustom();
          sp1.setOrientation(JScrollBar.HORIZONTAL);
        jp.setHorizontalScrollBar(sp1);
        this.add(jp);

    }

    public static void main(String ar[]) {

        BSc_Courses_Main ob = new BSc_Courses_Main();
        ob.setVisible(true);

    }
}
