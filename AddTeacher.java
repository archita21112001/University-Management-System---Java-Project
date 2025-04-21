package university.management.sytstem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher  extends JFrame implements ActionListener{
   JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfadhaar;
   JLabel labelempId;
   JDateChooser dcdob;
   JComboBox cbqualification, cbdepartment;
   JButton submit, cancel; 
   
   Random ran = new Random();
   long first4 = Math.abs(ran.nextLong() % 9000L ) + 1000L;
   
    AddTeacher(){
        
        setSize(900,700);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
       
        //fathers name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //roll number
        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50, 200, 200, 30);
        lblempId.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblempId);
        
        labelempId = new JLabel("101"+first4);
        labelempId.setBounds(200, 200, 200, 30);
        labelempId.setFont(new Font("Serif", Font.BOLD, 20));
        add(labelempId);
        
        //DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200, 150, 30);
        add(dcdob);
        
        
        //Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        
        //Phone
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
         //Email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //Xth Perc.
        JLabel lblx = new JLabel("Class X(%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);
        
        //XIIth Perc.
        JLabel lblxii = new JLabel("Class XII(%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);
        
        //adhar
        JLabel lbladhaar = new JLabel("Adhaar Number");
        lbladhaar.setBounds(400, 350, 200, 30);
        lbladhaar.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbladhaar);
        
        tfadhaar = new JTextField();
        tfadhaar.setBounds(600,350,150,30);
        add(tfadhaar);
        
        //highest education
        JLabel lblqual = new JLabel("Qualification");
        lblqual.setBounds(50, 400, 200, 30);
        lblqual.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblqual);
      
        String qualification[]= {"B.Tech", "BBA", "BCA", "BSc.", "BCOM", "BA", "MSc", "MBA", "MCA", "M.Tech", "MCOM", "MA"};
        cbqualification = new JComboBox(qualification);
        cbqualification.setBounds(200,400,150,30);
        cbqualification.setBackground(Color.WHITE);
        add(cbqualification);
        
        //branch
        JLabel lbldepartment = new JLabel("Branch");
        lbldepartment.setBounds(400, 400, 200, 30);
        lbldepartment.setFont(new Font("Serif", Font.BOLD, 20));
        add(lbldepartment); 
        
        String Department[]= {"Computer Science", "Electronics", "Machanical", "Civil.", "IT"};
        cbdepartment = new JComboBox(Department);
        cbdepartment.setBounds(600,400,150,30);
        cbdepartment.setBackground(Color.WHITE);
        add(cbdepartment);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = labelempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address= tfaddress.getText();
            String phone= tfphone.getText();
            String email= tfemail.getText();
            String x= tfx.getText();
            String xii= tfxii.getText();
            String adhaar= tfadhaar.getText();
            String qualification = (String)cbqualification.getSelectedItem();
            String department = (String)cbdepartment.getSelectedItem();
            
            try{ 
                String query = "insert into teacher values('"+name+"','"+fname+"','"+empId+"','"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+adhaar+"', '"+qualification+"', '"+department+"')";
                Conn con=  new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
                
                
            }catch(Exception e){
               e.printStackTrace(); 
            }
            
    }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
      new AddTeacher();
      
    }
    
}
