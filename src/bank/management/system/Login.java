package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField card_tf;
    JPasswordField pin_tf;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE-ATM");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/title.png"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(140,40,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,45));
        text.setBounds(260,40,400,100);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(160,180,150,30);
        add(cardno);

        card_tf =new JTextField();
        card_tf.setBounds(310,180,200,28);
        card_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(card_tf);

        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(160,230,100,30);
        add(pin);

        pin_tf =new JPasswordField();
        pin_tf.setBounds(310,230,200,28);
        pin_tf.setFont(new Font("Arial",Font.BOLD,15));
        add(pin_tf);

        login=new JButton("SIGN IN");
        login.setBounds(320,300,80,25);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(420,300,80,25);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(320,335,180,25);
        signup.setBackground(Color.DARK_GRAY);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);


        setSize(800,500);
        setVisible(true);
        setLocation(250,100);


    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==clear)
        {
          card_tf.setText("");
          pin_tf.setText("");
        }
        if(e.getSource()==signup)
        {
         setVisible(false);
         new SignupOne().setVisible(true);
        }
        if(e.getSource()==login)
        {
            Conn c=new Conn();
            String cardnumber=card_tf.getText();
            String pinnumber=pin_tf.getText();
            String query="select * from login where Card_no='"+cardnumber+"' and Pin='"+pinnumber+"'";
            try{
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }
               else
                   JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
            }
            catch (Exception exe)
            {
                System.out.println(exe);
            }
        }

    }
}
