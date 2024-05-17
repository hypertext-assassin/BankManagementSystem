package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    
    JButton back;
    String pin;
    
    MiniStatement(String pin){
        setTitle("Mini Statement");
        this.pin = pin;
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        mini.setForeground(Color.black);
//        mini.setFont(new Font("System",Font.BOLD,16));
        add(mini);
        
        
        JLabel bank = new JLabel("Union Bank");
        bank.setBounds(150,20,100,20);
        bank.setForeground(Color.black);
//        bank.setFont(new Font("System",Font.BOLD,16));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        card.setForeground(Color.black);
//        card.setFont(new Font("System",Font.BOLD,16));
        add(card);
        
        JLabel balance = new JLabel("Union Bank");
        balance.setBounds(20,400,300,20);
        balance.setForeground(Color.black);
//        balance.setFont(new Font("System",Font.BOLD,16));
        add(balance);
        
        try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from login where pinNumber = '"+pin+"'");
        while(rs.next()){
            card.setText("Card Number " + rs.getString("cardNumber").substring(0,4)+ "XXXXXXXX"+ rs.getString("cardNumber").substring(12) );
        }
        }catch(Exception e){
        System.out.println(e);
        }
        
        try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
        while(rs.next()){
            mini.setText(mini.getText() +"<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
        }
        }catch(Exception e){
        System.out.println(e);
        }


        int bal = 0;
    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
//            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal+= Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-= Integer.parseInt(rs.getString("amount"));                      
                }
            }
            balance.setText("Your current account balance is Rs "+ bal);
    }catch(Exception e){
        System.out.println(e);
    }
    
        
        
        back = new JButton("Back");
        back.setBounds(355,538,150,30);
        back.addActionListener(this);
//        imageLabel.add(back);
        
        setSize(400,600);
        setLocation(20,20);
//        setUndecorated(true);
        getRootPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
         new Transactions(pin).setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
