
package university.management.sytstem;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import javax.swing.*;

public class StudentFeeForm extends JFrame implements ActionListener{
    Choice crollno;
    JComboBox cbbranch , cbcourse , cbsemester;
    JLabel labeltotal;
    JButton update, pay, back;
    StudentFeeForm(){
        
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,450,250);
        add(image);
        
        JLabel lbllrollno = new JLabel("Select Roll No.");
        lbllrollno.setBounds(40, 60, 150, 20);
          lbllrollno.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbllrollno);
        
        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);
     
        try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from students");
                   while(rs.next()){
                       crollno.add(rs.getString("rollno"));
                   }
        }catch(Exception e){
            
        }
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);
       
        //fathers name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
         labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfname);
        
         try{
          Conn c = new Conn();
          String query = "select * from students where rollno = '" + crollno.getSelectedItem() + "'";
          ResultSet rs= c.s.executeQuery(query);
         while(rs.next()){
          labelname.setText(rs.getString("name"));  
          labelfname.setText(rs.getString("fname"));  
          
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         crollno.addItemListener(new ItemListener() {
            public void itemStateChanged( ItemEvent ie){
               try{
          Conn c = new Conn();
          String query = "select * from students where rollno = '" + crollno.getSelectedItem() + "'";
          ResultSet rs= c.s.executeQuery(query);
         while(rs.next()){
          labelname.setText(rs.getString("name"));  
          labelfname.setText(rs.getString("fname"));  
          
        }
        }catch(Exception e){
            e.printStackTrace();
        }
          
            }
        });
         
         
        //course
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);
      
        String course[]= {"B.Tech", "BBA", "BCA", "BSc.", "BCOM", "BA", "MSc", "MBA", "MCA", "M.Tech", "MCOM", "MA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        //branch
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblbranch); 
        
        String Branch[]= {"Computer Science", "Electronics", "Machanical", "Civil.", "IT"};
        cbbranch = new JComboBox(Branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 260, 150, 20);
         lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);
        
        String semester[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Fee");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);
        
         labeltotal = new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labeltotal);
        
        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
   
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
 
        back.addActionListener(this);
        add(back);

        
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==update){
           String course = (String) cbcourse.getSelectedItem();
           String semester = (String) cbsemester.getSelectedItem();
           try{
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
              while(rs.next()){
                  labeltotal.setText(rs.getString(semester));
              }
           }catch(Exception e){
               e.printStackTrace();
           }
        }else if (ae.getSource()== pay){
           String rollno =  crollno.getSelectedItem();
           String course = (String) cbcourse.getSelectedItem();
           String semester = (String) cbsemester.getSelectedItem();
           String branch = (String) cbbranch.getSelectedItem();
           String total = (String) labeltotal.getText();
 
           try{
              Conn c = new Conn();
              String query = "insert into collegefee values('"+rollno+"' , '"+course+"' ,'"+branch+"' , '"+semester+"' , '"+total+"')";

              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "College Fee Submitted Sucessfully.");
              setVisible(false);
              }
           catch(Exception e){
               e.printStackTrace();
           }

        }
        else{
            setVisible(false);
        }
    }

        public static void main(String[] args){
           new StudentFeeForm();
        
    }
}
