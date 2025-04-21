
package university.management.sytstem;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class StudentLeave extends JFrame  implements ActionListener{
    Choice crollno, ctime;
    JDateChooser dcdate ;
    JButton submit, cancel;
    
    StudentLeave(){
        
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 250, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
        add(crollno);
     
        try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from students");
                   while(rs.next()){
                       crollno.add(rs.getString("rollno"));
                   }
        }catch(Exception e){
            
        }
        
       JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210, 200, 20);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60,290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 20);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma", Font.BOLD, 10));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 10));
        cancel.addActionListener(this);
        add(cancel);

        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == submit) {
           String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText(); 
            String duration= ctime.getSelectedItem();
            
            String query = "insert into studentleave values('" +rollno+"','"+date+"','"+duration+"')";
            
            try{
               Conn con=  new Conn();
                con.s.executeUpdate(query); 
                JOptionPane.showMessageDialog(null,"Leave confirmed");
                setVisible(false);
            }catch(Exception e){
               e.printStackTrace(); 
            }
            
         }else{
             setVisible(false);
         }
    }
    
    public static void main(String[] args){
        new StudentLeave();
    }
    
}
