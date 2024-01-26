package scrollclspackage;

import java.awt.Color;
import udream.Update_Ranking;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

public class UpdateRankingCls extends JFrame  {
  public  UpdateRankingCls(){
    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 913, 700);
         this.getContentPane().setBackground(new Color(255, 255, 204));
        this.setLocationRelativeTo(null);
        JScrollPane jp;
        Update_Ranking jpa=new Update_Ranking(this);
        jp=new JScrollPane(jpa);
       ScrollBarCustom sp = new ScrollBarCustom();
         sp.setOrientation(JScrollBar.VERTICAL);
        jp.setVerticalScrollBar(sp);
         ScrollBarCustom sp1 = new ScrollBarCustom();
          sp1.setOrientation(JScrollBar.HORIZONTAL);
        jp.setHorizontalScrollBar(sp1);
        this.add(jp);
        this.setVisible(true);  
    }
    public static void main(String ar[])
    {
    UpdateRankingCls ob = new UpdateRankingCls();
    }
}
