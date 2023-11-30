package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox atm,mobilebanking,cheque,internetbanking,emailalert,estatement,declare;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setSize(750,600);
        setVisible(true);
        setLocation(300,40);
        getContentPane().setBackground(Color.WHITE);

        JLabel title=new JLabel("Page 3: ACCOUNT DETAILS");
        title.setBounds(230,10,450,30);
        title.setFont(new Font("Raleway",Font.BOLD,22));
        add(title);

        JLabel account=new JLabel("Account Type");
        account.setBounds(50,65,150,25);
        account.setFont(new Font("Raleway",Font.BOLD,20));
        add(account);

        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,12));
        r1.setBackground(Color.WHITE);
        r1.setBounds(60,100,150,15);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,12));
        r2.setBackground(Color.WHITE);
        r2.setBounds(60,125,150,15);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,12));
        r3.setBackground(Color.WHITE);
        r3.setBounds(320,100,220,15);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,12));
        r4.setBackground(Color.WHITE);
        r4.setBounds(320,125,250,15);
        add(r4);

        ButtonGroup accounttype=new ButtonGroup();
        accounttype.add(r1);
        accounttype.add(r2);
        accounttype.add(r3);
        accounttype.add(r4);

        JLabel cardno=new JLabel("Card Number");
        cardno.setBounds(50,180,150,25);
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardno);
        JLabel c=new JLabel("Your 16 digit Card Number");
        c.setBounds(50,210,350,15);
        c.setFont(new Font("Raleway",Font.BOLD,12));
        add(c);
        JLabel card=new JLabel("XXXX-XXXX-XXXX-4814");
        card.setBounds(250,180,250,25);
        card.setFont(new Font("Raleway",Font.BOLD,20));
        add(card);
        JLabel pin=new JLabel("PIN");
        pin.setBounds(50,230,150,25);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        add(pin);
        JLabel p=new JLabel("Your 4 digit PIN");
        p.setBounds(50,260,250,15);
        p.setFont(new Font("Raleway",Font.BOLD,12));
        add(p);
        JLabel pinno=new JLabel("XXXX");
        pinno.setBounds(250,230,150,25);
        pinno.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinno);

        JLabel services=new JLabel("Services Required");
        services.setBounds(50,290,200,25);
        services.setFont(new Font("Raleway",Font.BOLD,20));
        add(services);
        atm=new JCheckBox("ATM Card");
        atm.setBounds(80,325,100,15);
        atm.setFont(new Font("Raleway",Font.BOLD,12));
        atm.setBackground(Color.WHITE);
        add(atm);
        mobilebanking=new JCheckBox("Mobile Banking");
        mobilebanking.setBounds(80,350,150,15);
        mobilebanking.setFont(new Font("Raleway",Font.BOLD,12));
        mobilebanking.setBackground(Color.WHITE);
        add(mobilebanking);
        cheque=new JCheckBox("Cheque Book");
        cheque.setBounds(80,375,150,15);
        cheque.setFont(new Font("Raleway",Font.BOLD,12));
        cheque.setBackground(Color.WHITE);
        add(cheque);
        internetbanking=new JCheckBox("Internet banking");
        internetbanking.setBounds(280,325,150,15);
        internetbanking.setFont(new Font("Raleway",Font.BOLD,12));
        internetbanking.setBackground(Color.WHITE);
        add(internetbanking);
        emailalert=new JCheckBox("Email & SMS alerts");
        emailalert.setBounds(280,350,200,15);
        emailalert.setFont(new Font("Raleway",Font.BOLD,12));
        emailalert.setBackground(Color.WHITE);
        add(emailalert);
        estatement=new JCheckBox(" E-Statement");
        estatement.setBounds(280,375,150,15);
        estatement.setFont(new Font("Raleway",Font.BOLD,12));
        estatement.setBackground(Color.WHITE);
        add(estatement);
        declare=new JCheckBox("I hereby declare that the information is accurate for best of my knowledge");
        declare.setBounds(60,410,600,15);
        declare.setFont(new Font("Raleway",Font.BOLD,12));
        declare.setBackground(Color.WHITE);
        add(declare);
         submit=new JButton("Submit");
        submit.setBounds(130,445,100,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("Cancel");
        cancel.setBounds(250,445,100,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);


    }
    public static void main(String[] args) {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean declaration=false;
        if(declare.isSelected())
            declaration=true;
        if(e.getSource()==submit)
        {
            String accounttype = null;
            if (r1.isSelected())
                accounttype = "Savings account";
            if (r2.isSelected())
                accounttype = "Current account";
            if (r3.isSelected())
                accounttype = "Fixed deposit account";
            if (r4.isSelected())
                accounttype = "Recurring deposit account";

            String servicesrequired = "";
            if (atm.isSelected())
                servicesrequired += " Atm";
            if (mobilebanking.isSelected())
                servicesrequired += " MobileBanking";
            if (cheque.isSelected())
                servicesrequired += "Cheque";
            if (internetbanking.isSelected())
                servicesrequired += "InternetBanking";
            if (emailalert.isSelected())
                servicesrequired += "Email & SMS alerts";
            if (estatement.isSelected())
                servicesrequired += "E-Statement";

            Random random = new Random();
            String cardno =""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinno=""+Math.abs((random.nextLong()%9000L)+1000L);

                try {
                    if (accounttype == null)
                        JOptionPane.showMessageDialog(null, "Account type is required");
                    else {
                        if(!declaration)
                            JOptionPane.showMessageDialog(null,"Accept the Declaration statement");
                        else {

                            Conn c = new Conn();
                            String query1 = "insert into signupthree values('" + formno + "','" + accounttype + "','" + cardno + "','" + pinno + "','" + servicesrequired + "')";
                            String query2 = "insert into login values('" + formno + "','" + cardno + "','" + pinno + "')";
                            String query3 ="insert into bankbalance values('"+pinno+"','0')";
                            c.s.executeUpdate(query1);
                            c.s.executeUpdate(query2);
                            c.s.executeUpdate(query3);

                            JOptionPane.showMessageDialog(null, "Card Number:" + cardno + "\n Pin No:" + pinno);
                            setVisible(false);
                            new Deposit(pinno).setVisible(true);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

        }
        if(e.getSource()==cancel)
        {
           setVisible(false);
           new Login().setVisible(true);
        }

    }
}
