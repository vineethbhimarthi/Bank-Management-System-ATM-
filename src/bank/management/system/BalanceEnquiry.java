package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber=pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 710, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 710);
        add(image);

     JLabel text=new JLabel("ACCOUNT BALANCE");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(300, 250, 400, 25);
        text.setForeground(Color.WHITE);
        image.add(text);

        try{
            Conn c=new Conn();
            String formquery="select *from signupthree where Pin='"+pinnumber+"'";
            ResultSet rs=c.s.executeQuery(formquery);
            String formno="";
            if(rs.next())
                formno=rs.getString("formno");
            String namequery="select * from signup where formno='"+formno+"'";
            ResultSet r=c.s.executeQuery(namequery);
            String name="";
            if(r.next())
                name=r.getString("name");
            String balancequery="select *from bankbalance where pin='"+pinnumber+"'";
            ResultSet r1=c.s.executeQuery(balancequery);
            String balance="";
            if(r1.next())
                balance=r1.getString("balance");

            JLabel text2=new JLabel("Hello Mr/Ms "+name+", your Bank Balance is Rs ");
            text2.setForeground(Color.WHITE);
            text2.setFont(new Font("Raleway",Font.BOLD,14));
            text2.setBounds(200, 345, 300, 20);
            image.add(text2);
            JLabel balancetxt=new JLabel(balance);
            balancetxt.setForeground(Color.GREEN);
            balancetxt.setFont(new Font("Raleway",Font.BOLD,14));
            balancetxt.setBounds(505, 345, 400, 20);
            image.add(balancetxt);


            back=new JButton("BACK");
            back.setFont(new Font("Raleway", Font.BOLD, 14));
            back.setForeground(Color.WHITE);
            back.setBackground(Color.BLACK);
            back.setBounds(500, 460, 80, 30);
            back.addActionListener(this);
            image.add(back);

        }catch (Exception e)
        {
            System.out.println(e);
        }

        setSize(800, 710);
        setLocation(270, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
