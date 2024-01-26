
package udream;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author User
 */
public class Add_study_guide extends JFrame {
    public Add_study_guide() {
          this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 981, 700);
        JScrollPane jp;
         Add_Study_guide_information jpa=new Add_Study_guide_information(this);
         jp=new JScrollPane(jpa);
         ScrollBarCustom sp1 = new ScrollBarCustom();
           sp1.setOrientation(JScrollBar.VERTICAL);
             ScrollBarCustom sp2 = new ScrollBarCustom();
           sp2.setOrientation(JScrollBar.HORIZONTAL);
          
        jp.setVerticalScrollBar(sp1);
           jp.setHorizontalScrollBar(sp2);
      
       
        this.add(jp);

    }
    JFrame callcls;
     public Add_study_guide(JFrame f) {
          this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 981, 700);
        JScrollPane jp;
        callcls=f;
         Add_Study_guide_information jpa=new Add_Study_guide_information(this);
         jp=new JScrollPane(jpa);
         ScrollBarCustom sp1 = new ScrollBarCustom();
           sp1.setOrientation(JScrollBar.VERTICAL);
             ScrollBarCustom sp2 = new ScrollBarCustom();
           sp2.setOrientation(JScrollBar.HORIZONTAL);
          
        jp.setVerticalScrollBar(sp1);
           jp.setHorizontalScrollBar(sp2);
      
       
        this.add(jp);

    }
     public static void main(String ar[])
    {
        Add_study_guide frame=new Add_study_guide();
         frame.setVisible(true);
      
        
        
    }
}
