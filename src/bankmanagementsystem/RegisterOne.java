
package bankmanagementsystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class RegisterOne extends JFrame implements ActionListener{
    long randomNumber;
    JTextField nameField,fnameField,emailField,addressField,cityField,stateField,pinField;
    JDateChooser dobField;  
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    
            
    RegisterOne(){
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");   
    setLayout(null);
    Random ran = new Random();
     randomNumber = Math.abs((ran.nextLong()%9000L)+1000L);
        
    JLabel formNo = new JLabel("APPLICATION FORM NO. " + randomNumber);
    formNo.setFont(new Font("Raleway",Font.BOLD,38));
    formNo.setBounds(140,20,600,40);
    add(formNo);
    
    JLabel personalDetails = new JLabel("Page 1: Personal Details");
    personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
    personalDetails.setBounds(290,80,400,30);
    add(personalDetails);
    
    JLabel name = new JLabel("Name : " );
    name.setFont(new Font("Raleway",Font.BOLD,20));
    name.setBounds(100,140,100,30);
    add(name); 
    
    nameField = new JTextField();
    nameField.setFont(new Font("Raleway",Font.BOLD,16));
    nameField.setBounds(350,140,350,30);
    add(nameField);

    JLabel fname = new JLabel("Father's Name : " );
    fname.setFont(new Font("Raleway",Font.BOLD,20));
    fname.setBounds(100,190,200,30);
    add(fname);
    
    fnameField = new JTextField();
    fnameField.setFont(new Font("Raleway",Font.BOLD,16));
    fnameField.setBounds(350,190,350,30);
    add(fnameField);
    
    JLabel dob = new JLabel("Date of Birth : " );
    dob.setFont(new Font("Raleway",Font.BOLD,20));
    dob.setBounds(100,240,200,30);
    add(dob);
    
    dobField = new JDateChooser();
    dobField.setFont(new Font("Raleway",Font.BOLD,16));
    dobField.setBounds(350,240,350,30);
    add(dobField);
    
    JLabel gender = new JLabel("Gender : " );
    gender.setFont(new Font("Raleway",Font.BOLD,20));
    gender.setBounds(100,290,200,30);
    add(gender);
    
    male = new JRadioButton("Male");
    male.setFont(new Font("Raleway",Font.BOLD,16));
    male.setBackground(Color.white);
    male.setBounds(350,290,60,30);
    add(male);
    
    
    female = new JRadioButton("Female");
    female.setFont(new Font("Raleway",Font.BOLD,16));
    female.setBackground(Color.white);
    female.setBounds(460,290,100,30);
    add(female);
    
    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);
    
    JLabel email = new JLabel("Email Address : " );
    email.setFont(new Font("Raleway",Font.BOLD,20));
    email.setBounds(100,340,200,30);
    add(email);
    
    emailField = new JTextField();
    emailField.setFont(new Font("Raleway",Font.BOLD,16));
    emailField.setBounds(350,340,350,30);
    add(emailField);
    
    JLabel marital = new JLabel("Marital Status : " );
    marital.setFont(new Font("Raleway",Font.BOLD,20));
    marital.setBounds(100,390,200,30);
    add(marital);
    
    married = new JRadioButton("Married");
    married.setBounds(350,390,100,30);
    married.setBackground(Color.white);
    married.setFont(new Font("Raleway",Font.BOLD,16));
    add(married);
    
    unmarried = new JRadioButton("Unmarried");
    unmarried.setBounds(485,390,110,30);
    unmarried.setBackground(Color.white);
    unmarried.setFont(new Font("Raleway",Font.BOLD,16));
    add(unmarried);
    
    other = new JRadioButton("Other");
    other.setBounds(630,390,100,30);
    other.setBackground(Color.white);
    other.setFont(new Font("Raleway",Font.BOLD,16));
    add(other);
    
    
    ButtonGroup maritalGroup = new ButtonGroup();
    maritalGroup.add(married);
    maritalGroup.add(unmarried);
    maritalGroup.add(other);
    
    
    JLabel address = new JLabel("Address : " );
    address.setFont(new Font("Raleway",Font.BOLD,20));
    address.setBounds(100,440,200,30);
    add(address);
    
    
    addressField = new JTextField();
    addressField.setFont(new Font("Raleway",Font.BOLD,16));
    addressField.setBounds(350,440,350,30);
    add(addressField);
    
    JLabel city = new JLabel("City : " );
    city.setFont(new Font("Raleway",Font.BOLD,20));
    city.setBounds(100,490,200,30);
    add(city);
    
    cityField = new JTextField();
    cityField.setFont(new Font("Raleway",Font.BOLD,16));
    cityField.setBounds(350,490,350,30);
    add(cityField);
    
    JLabel state = new JLabel("State : " );
    state.setFont(new Font("Raleway",Font.BOLD,20));
    state.setBounds(100,540,200,30);
    add(state);
    
    stateField = new JTextField();
    stateField.setFont(new Font("Raleway",Font.BOLD,16));
    stateField.setBounds(350,540,350,30);
    add(stateField);
    
    JLabel pin = new JLabel("Pin Code : " );
    pin.setFont(new Font("Raleway",Font.BOLD,20));
    pin.setBounds(100,590,200,30);
    add(pin);
    
    pinField = new JTextField();
    pinField.setFont(new Font("Raleway",Font.BOLD,16));
    pinField.setBounds(350,590,350,30);
    add(pinField);
    
    next = new JButton("Next");
    next.setBackground(Color.black);
    next.setForeground(Color.white);
    next.setFont(new Font("Raleway",Font.BOLD,16));
    next.setBounds(620, 660, 80, 30);
    next.addActionListener(this);
    add(next);
    
    getContentPane().setBackground(Color.WHITE);
        
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
}
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = ""+ randomNumber;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField)dobField.getDateEditor().getUiComponent()).getText();
        String gender ="";
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }
        
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pin = pinField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c = new Conn();
                String query ="insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Registeration2(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    
    }
    
    
    public static void main(String[] args){
        new RegisterOne();
    }
}
