
package udream;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

/**
 *
 * @author User
 */
public class College_Finder_frame extends JFrame{

    public College_Finder_frame() {
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 700, 700);
        JScrollPane jp;
        college_finder_panel jpa = new college_finder_panel(this,callcls);
        jp = new JScrollPane(jpa);
        ScrollBarCustom sp1 = new ScrollBarCustom();
        sp1.setOrientation(JScrollBar.VERTICAL);
        ScrollBarCustom sp2 = new ScrollBarCustom();
        sp2.setOrientation(JScrollBar.HORIZONTAL);

        jp.setVerticalScrollBar(sp1);
        jp.setHorizontalScrollBar(sp2);
      callcls=new HOME();
        this.add(jp);
    }
    JFrame callcls;
      public College_Finder_frame(JFrame f) {
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 700, 700);
        JScrollPane jp;
        callcls=f;
        college_finder_panel jpa = new college_finder_panel(this,callcls);
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
        College_Finder_frame frame = new College_Finder_frame();
        frame.setVisible(true);
    }
    
}
