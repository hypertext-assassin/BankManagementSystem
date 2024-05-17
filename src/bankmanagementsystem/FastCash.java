package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton hundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand,back;
    String pin;
    FastCash(String pin){
        this.pin = pin;
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image2 = image.getImage().getScaledInstance(900, 930, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imageLabel = new JLabel(image3);
        imageLabel.setBounds(0,0,900,930);
        add(imageLabel);
        
        JLabel text = new JLabel("Please select Withdrawl amount");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170,430,150,30);
        hundred.addActionListener(this);
        imageLabel.add(hundred);
        
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(355,430,150,30);
        fiveHundred.addActionListener(this);
        imageLabel.add(fiveHundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(170,465,150,30);
        thousand.addActionListener(this);
        imageLabel.add(thousand);
        
        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355,465,150,30);
        twoThousand.addActionListener(this);
        imageLabel.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170,500,150,30);
        fiveThousand.addActionListener(this);
        imageLabel.add(fiveThousand);
        
        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355,500,150,30);
        tenThousand.addActionListener(this);
        imageLabel.add(tenThousand);
        
        back = new JButton("Back");
        back.setBounds(355,535,150,30);
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
        if(ae.getSource()== back){
        setVisible(false);
        new Transactions(pin).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-= Integer.parseInt(rs.getString("amount"));                      
                    }
                }
                if (ae.getSource()!= back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"You don't have sufficient balance in your account");
                    return;
                }else{
                Date date = new Date();
                String query = "insert into bank values('"+pin+"' , '"+date+"', 'Withdrawl', '"+amount+"')"; 
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+ " Withdrawn Successfully");
                
                setVisible(false);
                new Transactions(pin).setVisible(true);

                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
   public static void main(String args[]){
        new FastCash("");
   } 
}
