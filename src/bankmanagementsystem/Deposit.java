package bankmanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    String pin;
    
    Deposit(String pin){
        
        this.pin = pin;
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image.getImage().getScaledInstance(900, 930, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imageLabel = new JLabel(image3);
        imageLabel.setBounds(0,0,900,930);
        add(imageLabel);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(190,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(175,350,320,25);
        amount.setBackground(Color.white);
        imageLabel.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,503,150,30);
        deposit.addActionListener(this);
        imageLabel.add(deposit);
        
        
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
      if(ae.getSource()== deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else{
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pin+"' , '"+date+"', 'Deposit', '"+number+"')"; 
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+  " Deposited Successfully");
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
        new Deposit("");
   } 
}
