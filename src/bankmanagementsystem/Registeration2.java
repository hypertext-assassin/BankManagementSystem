
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Registeration2 extends JFrame implements ActionListener{
  
    JTextField panField,adhaarField;
    JComboBox religions,categories,incomes,educational,occupations;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    String formno;
    
    public Registeration2(String formno){
        this.formno = formno; 
    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");    
    setLayout(null);
           
    
    JLabel additionalDetails = new JLabel("Page 2: Additional Details");
    additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
    additionalDetails.setBounds(290,80,400,30);
    add(additionalDetails);
    
    JLabel religion = new JLabel("Religion : " );
    religion.setFont(new Font("Raleway",Font.BOLD,20));
    religion.setBounds(100,140,100,30);
    add(religion); 
    
    String religionsList[] = {"Hindu","Muslim","Sikh","Christian","Other"};
     religions = new JComboBox(religionsList);
    religions.setFont(new Font("Raleway",Font.BOLD,14));
    religions.setBounds(350,140,350,30);
    religions.setBackground(Color.white);
    add(religions);
    
    
    JLabel category = new JLabel("Category : " );
    category.setFont(new Font("Raleway",Font.BOLD,20));
    category.setBounds(100,190,200,30);
    add(category);
    
    String categoryList[] = {"General","OBC","SC","ST","Other"};
     categories = new JComboBox(categoryList);
    categories.setFont(new Font("Raleway",Font.BOLD,14));
    categories.setBounds(350,190,350,30);
    categories.setBackground(Color.white);
    add(categories);
    
    
    JLabel income = new JLabel("Income : " );
    income.setFont(new Font("Raleway",Font.BOLD,20));
    income.setBounds(100,240,200,30);
    add(income);
    
    
    String incomeList[] = {"Null","less than 150000","less than 250000","less than 500000","more than 500000"};
     incomes = new JComboBox(incomeList);
    incomes.setFont(new Font("Raleway",Font.BOLD,14));
    incomes.setBounds(350,240,350,30);
    incomes.setBackground(Color.white);
    add(incomes);
    
    
    JLabel education = new JLabel("Educational " );
    education.setFont(new Font("Raleway",Font.BOLD,20));
    education.setBounds(100,290,200,30);
    add(education);
       
    JLabel qualification = new JLabel("Qualification : " );
    qualification.setFont(new Font("Raleway",Font.BOLD,20));
    qualification.setBounds(100,320,200,30);
    add(qualification );
    
    String educationList[] = {"10th pass","12th pass","Graduate","Poatgraduate","Doctorate","Others"};
     educational = new JComboBox(educationList);
    educational.setFont(new Font("Raleway",Font.BOLD,14));
    educational.setBounds(350,320,350,30);
    educational.setBackground(Color.white);
    add(educational);
    
    
    JLabel occupation = new JLabel("Occupation : " );
    occupation.setFont(new Font("Raleway",Font.BOLD,20));
    occupation.setBounds(100,390,200,30);
    add(occupation);
    
    String occupationList[] = {"Student","Salaried","Self Employed","Business","Retired","Others"};
     occupations = new JComboBox(occupationList);
    occupations.setFont(new Font("Raleway",Font.BOLD,14));
    occupations.setBounds(350,390,350,30);
    occupations.setBackground(Color.white);
    add(occupations);
        
    
    JLabel pan = new JLabel("PAN Number : " );
    pan.setFont(new Font("Raleway",Font.BOLD,20));
    pan.setBounds(100,440,200,30);
    add(pan);
    
    
    panField = new JTextField();
    panField.setFont(new Font("Raleway",Font.BOLD,16));
    panField.setBounds(350,440,350,30);
    add(panField);
    
    JLabel adhaar = new JLabel("Adhaar Number : " );
    adhaar.setFont(new Font("Raleway",Font.BOLD,20));
    adhaar.setBounds(100,490,200,30);
    add(adhaar);
    
    adhaarField = new JTextField();
    adhaarField.setFont(new Font("Raleway",Font.BOLD,16));
    adhaarField.setBounds(350,490,350,30);
    add(adhaarField);
    
    JLabel senior = new JLabel("Senior citizen : " );
    senior.setFont(new Font("Raleway",Font.BOLD,20));
    senior.setBounds(100,540,200,30);
    add(senior);
    
    syes = new JRadioButton("Yes");
    syes.setFont(new Font("Raleway",Font.BOLD,16));
    syes.setBackground(Color.white);
    syes.setBounds(350,540,60,30);
    add(syes);
    
    
    sno = new JRadioButton("No");
    sno.setFont(new Font("Raleway",Font.BOLD,16));
    sno.setBackground(Color.white);
    sno.setBounds(460,540,100,30);
    add(sno);
    
    ButtonGroup seniorGroup = new ButtonGroup();
    seniorGroup.add(syes);
    seniorGroup.add(sno);
    
    JLabel existing = new JLabel("Existing Account : " );
    existing.setFont(new Font("Raleway",Font.BOLD,20));
    existing.setBounds(100,590,200,30);
    add(existing);
    
    eyes = new JRadioButton("Yes");
    eyes.setFont(new Font("Raleway",Font.BOLD,16));
    eyes.setBackground(Color.white);
    eyes.setBounds(350,590,60,30);
    add(eyes);
    
    
    eno = new JRadioButton("No");
    eno.setFont(new Font("Raleway",Font.BOLD,16));
    eno.setBackground(Color.white);
    eno.setBounds(460,590,100,30);
    add(eno);
    
    ButtonGroup existingGroup = new ButtonGroup();
    existingGroup.add(eyes);
    existingGroup.add(eno);
    
    
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
        String sreligion = (String)religions.getSelectedItem();
        String scategory = (String)categories.getSelectedItem();
        String sincome = (String)incomes.getSelectedItem();
        String seducation = (String)educational.getSelectedItem();
        String soccupation = (String)occupations.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if (sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if (eno.isSelected()){
            existingaccount="No";
        }
        
        String span = panField.getText();
        String sadhaar = adhaarField.getText();
         try{
            
                Conn c = new Conn();
                String query ="insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sadhaar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new RegisterThree(formno).setVisible(true);
             
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new Registeration2("");
    }
}
