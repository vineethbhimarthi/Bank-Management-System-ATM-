package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    Transactions(String pinnumber)
    {
          this.pinnumber=pinnumber;
       setLayout(null);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
         Image i2= i1.getImage().getScaledInstance(800,710,Image.SCALE_DEFAULT);
         ImageIcon image=new ImageIcon(i2);
         JLabel label=new JLabel(image);
         label.setBounds(0,0,800,710);
         add(label);

         JLabel title=new JLabel("Select Your Transaction");
         title.setFont(new Font("System",Font.BOLD,18));
         title.setBounds(300,250,400,25);
         title.setForeground(Color.WHITE);
         label.add(title);

         deposit=new JButton("Deposit");
         deposit.setBackground(Color.WHITE);
         deposit.setForeground(Color.BLACK);
         deposit.setFont(new Font("System",Font.BOLD,14));
         deposit.setBounds(230,320,150,30);
         deposit.addActionListener(this);
         label.add(deposit);

         withdraw=new JButton("Cash Withdraw");
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.setFont(new Font("System",Font.BOLD,14));
        withdraw.setBounds(390,320,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastcash=new JButton("Fast Cash");
        fastcash.setBackground(Color.WHITE);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("System",Font.BOLD,14));
        fastcash.setBounds(230,360,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBackground(Color.WHITE);
        ministatement.setForeground(Color.BLACK);
        ministatement.setFont(new Font("System",Font.BOLD,14));
        ministatement.setBounds(390,360,150,30);
        ministatement.addActionListener(this);
        label.add(ministatement);

        pinchange=new JButton("Pin Change");
        pinchange.setBackground(Color.WHITE);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("System",Font.BOLD,14));
        pinchange.setBounds(230,400,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balance=new JButton("Balance Enquiry");
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("System",Font.BOLD,14));
        balance.setBounds(390,400,150,30);
        balance.addActionListener(this);
        label.add(balance);

        exit=new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("System",Font.BOLD,14));
        exit.setBounds(390,440,150,30);
        exit.addActionListener(this);
        label.add(exit);


        setSize(800,710);
        setLocation(270,0);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==exit) {
            setVisible(false);
            new Login().setVisible(true);
        }
        if(e.getSource()==deposit)
        {
          setVisible(false);
          new Deposit(pinnumber).setVisible(true);
        }
        if(e.getSource()==withdraw)
        {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }
        if(e.getSource()==fastcash)
        {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
        if(e.getSource()==pinchange)
        {
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
        if(e.getSource()==balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        if(e.getSource()==ministatement)
            new Ministatement(pinnumber).setVisible(true);

    }
}
