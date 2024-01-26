package udream;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

public class Update_University_info_frame extends JFrame {

    public Update_University_info_frame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 1000, 700);
        JScrollPane jp;
        Update_University_Form_Panel jpa = new Update_University_Form_Panel(this);
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
        Update_University_info_frame frame = new Update_University_info_frame();
        frame.setVisible(true);
    }
}
