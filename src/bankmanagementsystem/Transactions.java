package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    String pin;
    Transactions(String pin){
        this.pin = pin;
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image.getImage().getScaledInstance(900, 930, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imageLabel = new JLabel(image3);
        imageLabel.setBounds(0,0,900,930);
        add(imageLabel);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,430,150,30);
        deposit.addActionListener(this);
        imageLabel.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,430,150,30);
        withdrawl.addActionListener(this);
        imageLabel.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,465,150,30);
        fastCash.addActionListener(this);
        imageLabel.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,465,150,30);
        miniStatement.addActionListener(this);
        imageLabel.add(miniStatement);
        
        pinChange = new JButton("PIN Change");
        pinChange.setBounds(170,500,150,30);
        pinChange.addActionListener(this);
        imageLabel.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,500,150,30);
        balanceEnquiry.addActionListener(this);
        imageLabel.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355,535,150,30);
        exit.addActionListener(this);
        imageLabel.add(exit);
        
        
        
        setLayout(null);
        setSize(900,860);
        setLocation(500,00);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()== fastCash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()== pinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource()== balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()== miniStatement){
//            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
    }
    
   public static void main(String args[]){
        new Transactions("");
   } 
}
