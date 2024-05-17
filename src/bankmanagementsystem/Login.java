package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login,clear,register;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    public Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel welcomeText = new JLabel("Welcome TO ATM");
        welcomeText.setFont(new Font("ALGERIAN",Font.BOLD,60));
        welcomeText.setBounds(200,35,600,70);
        add(welcomeText);
        
        
        JLabel cardText = new JLabel("Card Number");
        cardText.setFont(new Font("ARIAL",Font.PLAIN,28));
        cardText.setBounds(120,150,200,30);
        add(cardText);
        
         cardTextField = new JTextField();
        cardTextField.setFont(new Font("ARIAL",Font.PLAIN,18));
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);
        
        JLabel pinText = new JLabel("Pin Number");
        pinText.setFont(new Font("ARIAL",Font.PLAIN,28));
        pinText.setBounds(120,230,150,30);
        add(pinText);
        
         pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("ARIAL",Font.PLAIN,18));
        pinTextField.setBounds(300,230,250,30);
        add(pinTextField);
        
         login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("ARIAL",Font.PLAIN,18));
        add(login);
        
        
         clear = new JButton("CLEAR");
        clear.setBounds(452,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        clear.setFont(new Font("ARIAL",Font.PLAIN,18));
        add(clear);
        
        
         register = new JButton("REGISTER");
        register.setBounds(300,360,252,30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        register.setFont(new Font("ARIAL",Font.PLAIN,18));
        add(register);
        
        label.setBounds(70, 10, 100, 100);
        setSize(800,480);
        setVisible(true);
        setLocation(500,300);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== login){
           Conn conn = new Conn();
           String cardno = cardTextField.getText();
           String pin = pinTextField.getText();
           String query = "select * from login where cardNumber = '"+cardno+"' and pinNumber = '"+pin+"'";
           try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pin).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
           }catch(Exception e){
               System.out.println(e);
           }
           
        }else if (ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource()== register){
            setVisible(false);
            new RegisterOne().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login(); 
        
    }
    
}
