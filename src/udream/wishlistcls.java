/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import scrollbar.ScrollBarCustom;

public class wishlistcls extends JFrame {
     public  wishlistcls(String s,String s1){
   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 913, 700);
        JScrollPane jp;
        wishlisted_university_bsc_panel jpa=new wishlisted_university_bsc_panel (this,s,s1);
        jp=new JScrollPane(jpa);
           ScrollBarCustom sp = new ScrollBarCustom();
        jp.setVerticalScrollBar(sp);
        this.add(jp);
         this.setVisible(true);
}
       public  wishlistcls(String s,String s1,JFrame f){
   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add University Information");
        this.setBounds(200, 50, 913, 700);
        JScrollPane jp;
        wishlisted_university_bsc_panel jpa=new wishlisted_university_bsc_panel (this,s,s1,f);
        jp=new JScrollPane(jpa);
           ScrollBarCustom sp = new ScrollBarCustom();
        jp.setVerticalScrollBar(sp);
        this.add(jp);
         this.setVisible(true);
}
       public static void main(String ar[])
    {
    wishlistcls ob = new wishlistcls("Dhaka University","Bsc in Computer Science");
    }
}
