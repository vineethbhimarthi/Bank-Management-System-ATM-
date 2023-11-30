package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends  JFrame implements ActionListener{

    JTextField pan_tf,aadhar_tf;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,education,occupation;
    JButton next;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setSize(800,660);
        setVisible(true);
        setLocation(250,40);
        setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");

        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,18));
        additionaldetails.setBounds(270,78,600,22);
        add(additionaldetails);

        JLabel name=new JLabel("Religion");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(130,120,110,30);
        add(name);
        String valReligion[] ={"Hindu","Muslim","Christian","Sikh","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,120,350,30);
        religion.setFont(new Font("Arial",Font.BOLD,15));
        add(religion);

        JLabel fname=new JLabel("Category");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(130,160,150,30);
        add(fname);
        String valCategory[]={"General","OBC","ST","SC","OTHER"};
         category=new JComboBox(valCategory);
        category.setBounds(300,160,350,30);
        category.setFont(new Font("Arial",Font.BOLD,15));
        add(category);

        JLabel dob=new JLabel("Income");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(130,200,150,30);
        add(dob);
        String valIncome[]={"Null","<2,50,000","<5,00,000","upto 10,00,000"};
         income=new JComboBox(valIncome);
        income.setBounds(300,200,350,30);
        income.setFont(new Font("Arial",Font.BOLD,15));
        add(income);
//        JDateChooser chooser = new JDateChooser();
        // chooser.setLocale(Locale.US);

//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Date of Birth:"));
//        panel.add(chooser);
//        panel.setBounds(300,200,350,30);
//        add(panel);

        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(130,240,150,20);
        add(gender);
        JLabel email=new JLabel("Qualification");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(130,260,150,30);
        add(email);
        String valEducation[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","other"};
         education =new JComboBox(valEducation);
        education.setBounds(300,260,350,30);
        education.setFont(new Font("Arial",Font.BOLD,15));
        add(education);

        JLabel marital=new JLabel("Occupation");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(130,320,150,30);
        add(marital);
        String valOccupation[]={"Salaried","Self-Employed","Bussinesman","Student","Retired","Other"};
         occupation=new JComboBox(valOccupation);
        occupation.setBounds(300,320,350,30);
        education.setFont(new Font("Arial",Font.BOLD,15));
        add(occupation);


        JLabel address=new JLabel("PAN Number");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(130,360,150,30);
        add(address);
        pan_tf=new JFormattedTextField();
        pan_tf.setBounds(300,360,350,30);
        pan_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(pan_tf);

        JLabel city=new JLabel("Aadhar Number");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(130,400,150,30);
        add(city);
        aadhar_tf=new JFormattedTextField();
        aadhar_tf.setBounds(300,400,350,30);
        aadhar_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(aadhar_tf);

        JLabel state=new JLabel("Senior Citizen");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(130,440,150,30);
        add(state);
        syes =new JRadioButton("Yes");
        syes.setBounds(300,440,60,30);
        syes.setBackground(Color.LIGHT_GRAY);
        add(syes);
        sno =new JRadioButton("No");
        sno.setBounds(370,440,60,30);
        sno.setBackground(Color.LIGHT_GRAY);
        add(sno);
        ButtonGroup citizengroup=new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);


        JLabel pincode=new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(130,480,180,30);
        add(pincode);
         eyes =new JRadioButton("Yes");
        eyes.setBounds(300,480,60,30);
        eyes.setBackground(Color.LIGHT_GRAY);
        add(eyes);
        eno =new JRadioButton("No");
        eno.setBounds(370,480,60,30);
        eno.setBackground(Color.LIGHT_GRAY);
        add(eno);
        ButtonGroup existinggroup=new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);



        next=new JButton("Next");
        next.setBounds(670,560,100,30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String span=pan_tf.getText();
        String saadhar=aadhar_tf.getText();
        String seniorcitizen=null;
        if(syes.isSelected())
        {
            seniorcitizen="Yes";
        }
        if(sno.isSelected())
            seniorcitizen="No";
        String existingaccount=null;
        if(eyes.isSelected())
            existingaccount="Yes";
        if(eno.isSelected())
            existingaccount="No";

        try{
            if(sreligion.isEmpty())
                JOptionPane.showMessageDialog(null,"Religion is Required");
            else {
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch (Exception ae) {
            System.out.println(ae);
        }
    }
}
