package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,710,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,710);
        add(image);

        JLabel text=new JLabel("Please Enter Amount to Deposit");
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(250,270,400,25);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount=new JTextField();
        amount.setBounds(250,320,300,30);
        image.add(amount);

        deposit =new JButton("Deposit");
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("System",Font.BOLD,14));
        deposit.setBounds(430,420,100,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back =new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System",Font.BOLD,14));
        back.setBounds(430,450,100,25);
        back.addActionListener(this);
        image.add(back);

        setSize(800,710);
        setLocation(270,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource()==back)
           {
               setVisible(false);
               new Transactions("").setVisible(true);
           }
           if (e.getSource()==deposit)
           {
               String deposit_amount=amount.getText();
               //System.out.println(deposit_amount);
               Date date=new Date();
               if(deposit_amount.equals(""))
                   JOptionPane.showMessageDialog(null,"Enter DEPOSIT Amount");
               else {
                   try {
                       Conn c=new Conn();
                       String query1="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+deposit_amount+"')";
                       c.s.executeUpdate(query1);
                     String query2="select *from bankbalance where pin='"+pinnumber+"'";
                      ResultSet rs=c.s.executeQuery(query2);
                      String cash="";
                       if(rs.next())
                       cash=rs.getString("balance");
                       String totalbalance=""+((Integer.parseInt(cash))+(Integer.parseInt(deposit_amount)));
                       System.out.println(totalbalance);
                       String query3="UPDATE bankbalance SET balance='"+totalbalance+"' WHERE pin='"+pinnumber+"'";
                      c.s.executeUpdate(query3);
                       rs.close();
                       JOptionPane.showMessageDialog(null,deposit_amount+" Deposited Successfully");
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
}
