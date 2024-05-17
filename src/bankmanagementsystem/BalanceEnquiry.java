package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pin;
    
    BalanceEnquiry(String pin){
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 930, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 930);
        add(imageLabel);
        Conn conn = new Conn();
        int balance = 0;
    try{
        ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-= Integer.parseInt(rs.getString("amount"));                      
                }
            }
    }catch(Exception e){
        System.out.println(e);
    }
    
        JLabel text = new JLabel("Your current account balance is Rs "+ balance);
        text.setBounds(165,300,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(text);
        
        back = new JButton("Back");
        back.setBounds(355,538,150,30);
        back.addActionListener(this);
        imageLabel.add(back);
        
        setSize(900,860);
        setLocation(500,0);
        setUndecorated(true);
        getRootPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
         new Transactions(pin).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
