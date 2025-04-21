
package university.management.sytstem;

import java.awt.*;
import javax.swing.*;


public class About extends JFrame {
    About(){
         setSize(700,500);
        setLocation(400,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,300,200);
        add(image);
        
        JLabel heading = new JLabel("<html><i><u><b> UNIVERSITY<br/> MANAGEMENT SYSTEM<br/></></b></i></html> ");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahome",Font.BOLD,30));
        add(heading);
        
         JLabel intro = new JLabel("<html><u>YOUR FUTURE</u><br/> Now is the time to start<br/> thinking about your<br/> options for further study.  ");
        intro.setBounds(70,150,550,180);
        intro.setFont(new Font("Tahome",Font.BOLD,25));
        add(intro);
        
        JLabel name = new JLabel("Developed by Archita Shukla ");
        name.setBounds(300,370,300,25);
        name.setFont(new Font("Tahome",Font.BOLD,20));
        add(name);
        
        JLabel contact = new JLabel("Contact : architashukla21@gmail.com ");
        contact.setBounds(300,400,400,25);
        contact.setFont(new Font("Tahome",Font.BOLD,20));
        add(contact);


        
        
        setVisible(true);
        
    }
    
     
    public static void main(String[] args){
       new About ();
    }
    
    
}
