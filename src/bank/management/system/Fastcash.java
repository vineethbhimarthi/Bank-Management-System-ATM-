package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash  extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balance,exit;

    String pinnumber;
    Fastcash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,710,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel label=new JLabel(image);
        label.setBounds(0,0,800,710);
        add(label);

        JLabel title=new JLabel("Select Withdrawl Amount");
        title.setFont(new Font("System",Font.BOLD,18));
        title.setBounds(300,250,400,25);
        title.setForeground(Color.WHITE);
        label.add(title);

        deposit=new JButton("Rs 100");
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("System",Font.BOLD,14));
        deposit.setBounds(230,320,150,30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw=new JButton("RS 500");
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.setFont(new Font("System",Font.BOLD,14));
        withdraw.setBounds(390,320,150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastcash=new JButton("Rs 1000");
        fastcash.setBackground(Color.WHITE);
        fastcash.setForeground(Color.BLACK);
        fastcash.setFont(new Font("System",Font.BOLD,14));
        fastcash.setBounds(230,360,150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministatement=new JButton("RS 2000");
        ministatement.setBackground(Color.WHITE);
        ministatement.setForeground(Color.BLACK);
        ministatement.setFont(new Font("System",Font.BOLD,14));
        ministatement.setBounds(390,360,150,30);
        ministatement.addActionListener(this);
        label.add(ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBackground(Color.WHITE);
        pinchange.setForeground(Color.BLACK);
        pinchange.setFont(new Font("System",Font.BOLD,14));
        pinchange.setBounds(230,400,150,30);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balance=new JButton("Rs 10000");
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("System",Font.BOLD,14));
        balance.setBounds(390,400,150,30);
        balance.addActionListener(this);
        label.add(balance);

        exit=new JButton("Back");
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
        new Fastcash("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else
        {
         String amount=((JButton)e.getSource()).getText().substring(3);
           // System.out.println(amount);
            Date date=new Date();
                try {
                    Conn c=new Conn();
                    String query1="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query1);
                    String query2="select *from bankbalance where pin='"+pinnumber+"'";
                    ResultSet rs=c.s.executeQuery(query2);
                    String cash="";
                    if(rs.next())
                        cash=rs.getString("balance");
                    String totalbalance=""+(Integer.parseInt(cash)-Integer.parseInt(amount));
                    System.out.println(totalbalance);
                    String query3="UPDATE bankbalance SET balance='"+totalbalance+"' WHERE pin='"+pinnumber+"'";
                    c.s.executeUpdate(query3);
                    rs.close();
                    JOptionPane.showMessageDialog(null,amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception ee)
                {
                    System.out.println(ee);
                }
            }



    }
}
