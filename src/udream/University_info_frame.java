
package udream;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;


public class University_info_frame extends JFrame
        

{

    public University_info_frame() {
          this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 1070, 700);
        JScrollPane jp;
          University_info_jpanel jpa=new University_info_jpanel(this);
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
        University_info_frame frame=new University_info_frame();
         frame.setVisible(true);
      
        
        
    }
}
