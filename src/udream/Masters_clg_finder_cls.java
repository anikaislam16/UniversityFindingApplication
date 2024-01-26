package udream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

public class Masters_clg_finder_cls extends JFrame {

    public Masters_clg_finder_cls() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 913, 700);
        JScrollPane jp;
        Masters_clg jpa = new Masters_clg(this);
        jp = new JScrollPane(jpa);
        ScrollBarCustom sp = new ScrollBarCustom();
        jp.setVerticalScrollBar(sp);
        this.add(jp);
        this.setVisible(true);
        callcls=new HOME();
    }
    JFrame callcls;
      public Masters_clg_finder_cls(JFrame f) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 913, 700);
        callcls=f;
        JScrollPane jp;
        Masters_clg jpa = new Masters_clg(this,f);
        jp = new JScrollPane(jpa);
        ScrollBarCustom sp = new ScrollBarCustom();
        jp.setVerticalScrollBar(sp);
        this.add(jp);
        this.setVisible(true);
    }

    public static void main(String ar[]) {
        Masters_clg_finder_cls ob = new Masters_clg_finder_cls();
    }
}
