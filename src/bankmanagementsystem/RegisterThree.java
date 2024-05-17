package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class RegisterThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle;
    String formno;
    
     RegisterThree(String formno){
        
        this.formno = formno;
        JLabel l1  =new JLabel("Page3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type  =new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBounds(100, 180, 150, 20);
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBounds(350, 180, 250, 20);
        r2.setBackground(Color.white);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        r3.setBounds(100, 220, 150, 20);
        r3.setBackground(Color.white);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        r4.setBounds(350, 220, 250, 20);
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup account = new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3); 
        account.add(r4);

        JLabel card  =new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);    

        JLabel cardDetails  =new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,330,400,20);
        add(cardDetails);         
        
        JLabel number  =new JLabel("XXXX-XXXX-XXXX-6526");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel pin  =new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin); 
        
        JLabel pinDetails  =new JLabel("Your 4 Digit PIN");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,400,400,20);
        add(pinDetails);  
        
        JLabel pnumber  =new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
                     
        JLabel services  =new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,400,30);
        add(services); 
        
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        c1.setBounds(100, 500, 200, 30);
        c1.setBackground(Color.white);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBounds(350, 500, 200, 30);
        c2.setBackground(Color.white);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        c3.setBounds(100, 550, 200, 30);
        c3.setBackground(Color.white);
        add(c3);
        
        c4 = new JCheckBox("Email/SMS Alert");
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        c4.setBounds(350, 550, 200, 30);
        c4.setBackground(Color.white);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        c5.setBounds(100, 600, 200, 30);
        c5.setBackground(Color.white);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        c6.setBounds(350, 600, 200, 30);
        c6.setBackground(Color.white);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above mentioned details are correct to the best of knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,15));
        c7.setBounds(100, 680, 700, 30);
        c7.setBackground(Color.white);
        add(c7);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setBounds(300,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancle = new JButton("CANCLE");
        cancle.setBackground(Color.black);
        cancle.setForeground(Color.white);
        cancle.setFont(new Font("Raleway",Font.BOLD,15));
        cancle.setBounds(420,720,100,30);
        cancle.addActionListener(this);
        add(cancle);
        
        
        setLayout(null);
        setVisible(true);
        setSize(850,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.WHITE);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if (r2.isSelected()){
             accountType="Fixed Deposit Account";
            }else if (r3.isSelected()){
             accountType="Current Account";
            }else if (r4.isSelected()){
             accountType="Reccuring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber  = ""+Math.abs((random.nextLong()%90000000l)+ 5040936000000000l);
            
             String pinnumber  = ""+Math.abs((random.nextLong()%9000l)+ 1000l);
             
             String facility = "";
             if(c1.isSelected()){
                 facility = facility + " ATM Card"+", ";
             }if(c2.isSelected()){
                 facility = facility + " Internet Banking"+", ";
             }if(c3.isSelected()){
                 facility = facility + " Mobile Banking"+", ";
             }if(c4.isSelected()){
                 facility = facility + " Email and SMS alert"+", ";
             } if(c5.isSelected()){
                 facility = facility + " Cheque Book"+", ";
             } if(c6.isSelected()){
                 facility = facility + " E-Statement"+", ";
             }
            
             try{
                 if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else{
                    Conn c = new Conn();
                    String query1 ="insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 ="insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                   
                    JOptionPane.showMessageDialog(null, "Card Number : "+ cardnumber+ "\n PIN :" + pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);


            }
             }catch(Exception e){
            System.err.println(e);
        }
            
        }else if(ae.getSource()== cancle){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new RegisterThree("");
    }
}
