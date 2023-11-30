package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdraw(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 710, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 710);
        add(image);

        JLabel text = new JLabel("Please Enter Amount to Withdraw");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(250, 270, 400, 25);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(250, 320, 300, 30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.setFont(new Font("System", Font.BOLD, 14));
        withdraw.setBounds(430, 420, 100, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.setBounds(430, 450, 100, 25);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 710);
        setLocation(270, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transactions("").setVisible(true);
        }
        if (e.getSource() == withdraw) {
            String withdraw_amount = amount.getText();
            Date date = new Date();
            if (withdraw_amount.equals(""))
                JOptionPane.showMessageDialog(null, "Enter WITHDRAW Amount");
            else {
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + withdraw_amount + "')";
                    c.s.executeUpdate(query);
                    String query2="select *from bankbalance where pin='"+pinnumber+"'";
                    ResultSet rs=c.s.executeQuery(query2);
                    String cash="";
                    if(rs.next())
                        cash=rs.getString("balance");
                    if((Integer.parseInt(withdraw_amount))>(Integer.parseInt(cash)))
                    {
                        JOptionPane.showMessageDialog(null,"Sorry, Insufficient Balance!");
                    }
                    else {
                        String totalbalance = "" + ((Integer.parseInt(cash)) - (Integer.parseInt(withdraw_amount)));
                        System.out.println(totalbalance);
                        String query3 = "UPDATE bankbalance SET balance='" + totalbalance + "' WHERE pin='" + pinnumber + "'";
                        c.s.executeUpdate(query3);
                        rs.close();

                        JOptionPane.showMessageDialog(null, withdraw_amount + " Withdraw Succesfully");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);

                    }
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        }
    }
}