/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scrollclspackage;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;
import udream.University_Page;

public class university_pagecls extends JFrame{
     JScrollPane jp;
     JFrame cls;
    public  university_pagecls(String s){
    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(200, 50, 1397, 700);
        University_Page jpa=new  University_Page( this,s);
        jp=new JScrollPane(jpa);
       ScrollBarCustom sp = new ScrollBarCustom();
         sp.setOrientation(JScrollBar.VERTICAL);
        jp.setVerticalScrollBar(sp);
         ScrollBarCustom sp1 = new ScrollBarCustom();
          sp1.setOrientation(JScrollBar.HORIZONTAL);
        jp.setHorizontalScrollBar(sp1);
          this.add(jp);
         
    }
     public  university_pagecls(String s,JFrame cls){
    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(200, 50, 1397, 700);
        University_Page jpa=new  University_Page( this,s,cls);
        jp=new JScrollPane(jpa);
       ScrollBarCustom sp = new ScrollBarCustom();
         sp.setOrientation(JScrollBar.VERTICAL);
        jp.setVerticalScrollBar(sp);
         ScrollBarCustom sp1 = new ScrollBarCustom();
          sp1.setOrientation(JScrollBar.HORIZONTAL);
        jp.setHorizontalScrollBar(sp1);
          this.add(jp);
         
    }
      public static void main(String ar[])
    {
    university_pagecls ob = new university_pagecls("University of Oulu");
    ob.setVisible(true);  
    }
}
