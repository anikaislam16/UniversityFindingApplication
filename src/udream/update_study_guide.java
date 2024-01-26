/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udream;

/**
 *
 * @author Asus
 */
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;
public class update_study_guide extends JFrame{
    public update_study_guide() {
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Update Course Information");
        this.setBounds(200, 50, 913, 700);
        JScrollPane jp;
        update_study_guide_jpanel  jpa = new  update_study_guide_jpanel(this);
        jp = new JScrollPane(jpa);
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.VERTICAL);
        ScrollBarCustom sp2 = new ScrollBarCustom();
        sp2.setOrientation(JScrollBar.HORIZONTAL);

        jp.setVerticalScrollBar(sp1);
        jp.setHorizontalScrollBar(sp2);

        this.add(jp);
    }
    JFrame cls;
     public update_study_guide(JFrame f) {
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Update Course Information");
        this.setBounds(200, 50, 913, 700);
        JScrollPane jp;
        cls=f;
        update_study_guide_jpanel  jpa = new  update_study_guide_jpanel(this,cls);
        jp = new JScrollPane(jpa);
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.VERTICAL);
        ScrollBarCustom sp2 = new ScrollBarCustom();
        sp2.setOrientation(JScrollBar.HORIZONTAL);

        jp.setVerticalScrollBar(sp1);
        jp.setHorizontalScrollBar(sp2);

        this.add(jp);
    }
    public static void main(String ar[]) {
         update_study_guide frame = new  update_study_guide();
        frame.setVisible(true);
    }
    
}
