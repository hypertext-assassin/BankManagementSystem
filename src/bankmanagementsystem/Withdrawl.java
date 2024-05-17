package bankmanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdrawl,back;
    String pin;
    
    Withdrawl(String pin){
        
        this.pin = pin;
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image.getImage().getScaledInstance(900, 930, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imageLabel = new JLabel(image3);
        imageLabel.setBounds(0,0,900,930);
        add(imageLabel);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(190,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(175,350,320,25);
        amount.setBackground(Color.white);
        imageLabel.add(amount);
        
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355,503,150,30);
        withdrawl.addActionListener(this);
        imageLabel.add(withdrawl);
        
        
        back = new JButton("Back");
        back.setBounds(355,538,150,30);
        back.addActionListener(this);
        imageLabel.add(back);
        
        setLayout(null);
        setSize(900,860);
        setLocation(500,00);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()== withdrawl){
            String number = amount.getText();
            Date date = new Date();
            int balance=0;
            try{
                Conn conn = new Conn();
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
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl");
            }else if (ae.getSource()!= back && balance<Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"You don't have sufficient balance in your account");
                    return;
                }
            else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pin+"' , '"+date+"', 'Withdrawl', '"+number+"')"; 
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+ " Withdrawn Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
      }else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    
   public static void main(String args[]){
        new Withdrawl("");
   } 
}

