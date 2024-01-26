package scrollclspackage;

import udream.CoursePage;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;//200,50,944,700

public class CourseCls extends JFrame {

    public CourseCls(String s, String s1) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 1144, 700);
        JScrollPane jp;
        CoursePage jpa = new CoursePage(this, s, s1);
        jp = new JScrollPane(jpa);
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.VERTICAL);
        jp.setVerticalScrollBar(sp);
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.HORIZONTAL);
        jp.setHorizontalScrollBar(sp1);
        this.add(jp);

    }
     public CourseCls(String s, String s1,JFrame f) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 1144, 700);
        JScrollPane jp;
        CoursePage jpa = new CoursePage(this, s, s1,f);
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
        CourseCls ob = new CourseCls("Dhaka University", "Bsc in Computer Science");
        ob.setVisible(true);
    }
}
