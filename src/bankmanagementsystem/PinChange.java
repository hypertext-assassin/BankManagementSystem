package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pinField,rePinField;
    JButton back,change;
    String pin;
    
    PinChange(String pin){
        
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 930, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 900, 930);
        add(imageLabel);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(260,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(text);
        
        JLabel pinText = new JLabel("New PIN : ");
        pinText.setBounds(165,350,200,25);
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(pinText);
        
        pinField = new JPasswordField();
        pinField.setFont(new Font("Raleway",Font.BOLD,16));
        pinField.setBounds(330,350,150,25);
        pinField.setBackground(Color.white);
        imageLabel.add(pinField);
        
        JLabel rePinText = new JLabel("Re-Enter New PIN : ");
        rePinText.setBounds(165,400,200,25);
        rePinText.setForeground(Color.white);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        imageLabel.add(rePinText);
        
        
        rePinField = new JPasswordField();
        rePinField.setFont(new Font("Raleway",Font.BOLD,16));
        rePinField.setBounds(330,400,150,25);
        rePinField.setBackground(Color.white);
        imageLabel.add(rePinField);
        
        change = new JButton("Change");
        change.setBounds(355,503,150,30);
        change.addActionListener(this);
        imageLabel.add(change);
        
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
        if(ae.getSource()== change){
            try{
                String npin = pinField.getText();
                String rpin = rePinField.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where  pin ='"+pin+"'";
                String query2 = "update login set pin = '"+rpin+"' where  pin ='"+pin+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where  pin ='"+pin+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    
    public static void main (String args[]){
        new PinChange("").setVisible(true);
    }
    
    
}
