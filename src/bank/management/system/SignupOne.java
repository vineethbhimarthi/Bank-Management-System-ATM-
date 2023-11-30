package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.ActionListener;

public class SignupOne extends  JFrame implements ActionListener{
    long random;
    JTextField name_tf,fname_tf,email_tf,address_tf,city_tf,state_tf,pincode_tf;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        setSize(800,660);
        setVisible(true);
        setLocation(250,40);

        Random ran=new Random();
         random=Math.abs((ran.nextLong()%9000l)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(180,7,600,70);
        add(formno);


        JLabel personaldetails=new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,18));
        personaldetails.setBounds(270,78,600,22);
        add(personaldetails);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(130,120,110,30);
        add(name);
        name_tf=new JFormattedTextField();
        name_tf.setBounds(300,120,350,30);
        name_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(name_tf);

        JLabel fname=new JLabel("Father Name");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(130,160,150,30);
        add(fname);
        fname_tf=new JFormattedTextField();
        fname_tf.setBounds(300,160,350,30);
        fname_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(fname_tf);

        JLabel dob=new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(130,200,150,30);
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,200,350,30);
        add(dateChooser);
//        JDateChooser chooser = new JDateChooser();
       // chooser.setLocale(Locale.US);

//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Date of Birth:"));
//        panel.add(chooser);
//        panel.setBounds(300,200,350,30);
//        add(panel);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(130,240,150,30);
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(300,240,60,30);
        male.setBackground(Color.LIGHT_GRAY);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(400,240,100,30);
        female.setBackground(Color.LIGHT_GRAY);
        add(female);
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("Email Address");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(130,280,150,30);
        add(email);
        email_tf=new JFormattedTextField();
        email_tf.setBounds(300,280,350,30);
        email_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(email_tf);

        JLabel marital=new JLabel("Marital Status");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(130,320,150,30);
        add(marital);
        married=new JRadioButton("Married");
        married.setBounds(300,320,80,30);
        married.setBackground(Color.LIGHT_GRAY);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400,320,100,30);
        unmarried.setBackground(Color.LIGHT_GRAY);
        add(unmarried);
        other=new JRadioButton("Other");
        other.setBounds(520,320,80,30);
        other.setBackground(Color.LIGHT_GRAY);
        add(other);

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);


        JLabel address=new JLabel("Address");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(130,360,150,30);
        add(address);
        address_tf=new JFormattedTextField();
        address_tf.setBounds(300,360,350,30);
        address_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(address_tf);

        JLabel city=new JLabel("City");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(130,400,150,30);
        add(city);
        city_tf=new JFormattedTextField();
        city_tf.setBounds(300,400,350,30);
        city_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(city_tf);

        JLabel state=new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(130,440,150,30);
        add(state);
        state_tf=new JFormattedTextField();
        state_tf.setBounds(300,440,350,30);
        state_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(state_tf);


        JLabel pincode=new JLabel("Pincode");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(130,480,150,30);
        add(pincode);
        pincode_tf=new JFormattedTextField();
        pincode_tf.setBounds(300,480,350,30);
        pincode_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(pincode_tf);


         next=new JButton("Next");
         next.setBounds(670,560,100,30);
         next.setForeground(Color.WHITE);
         next.setBackground(Color.BLACK);
         next.addActionListener(this);
         add(next);

        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=""+random;
        String name=name_tf.getText();
        String fname=fname_tf.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String email=email_tf.getText();
        String state=state_tf.getText();
        String address=address_tf.getText();
        String city=city_tf.getText();
        String pincode=pincode_tf.getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        if(female.isSelected())
            gender="Female";
        String marital_status=null;
        if(married.isSelected())
            marital_status="Married";
        if(unmarried.isSelected())
            marital_status="Unmarried";
        if(other.isSelected())
            marital_status="Other";

        try{
            if(name.isEmpty())
                JOptionPane.showMessageDialog(null,"Name is Required");
            else {
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+marital_status+"','"+email+"','"+state+"','"+address+"','"+city+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch (Exception ae) {
            System.out.println(ae);
        }
    }
}
