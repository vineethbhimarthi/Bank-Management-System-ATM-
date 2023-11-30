package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ministatement extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    Ministatement(String pinnumber)
    {
      this.pinnumber=pinnumber;
      setLayout(null);

      JLabel bank=new JLabel("Indian Bank");
      bank.setBounds(150,20,100,20);
      add(bank);

      JLabel card =new JLabel();
      card.setBounds(20,100,300,20);
      add(card);

      JLabel mini =new JLabel();
        mini.setBounds(20,80,370,300);
        add(mini);

      JLabel balance=new JLabel();
      balance.setBounds(20,360,300,20);
      add(balance);

        back=new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 10));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(300, 500, 80, 20);
        back.addActionListener(this);
        add(back);

      try{
          Conn c=new Conn();
          String query="select * from login where Pin='"+pinnumber+"'";
          ResultSet rs=c.s.executeQuery(query);
          if(rs.next())
              card.setText("Card Number: "+rs.getString("Card_no").substring(0,4)+"XXXXXXXX"+rs.getString("Card_no").substring(12));
          rs.close();

          String query3="select * from bankbalance where pin='"+pinnumber+"'";
          ResultSet rr=c.s.executeQuery(query3);
          if(rr.next())
              balance.setText("Your current balance is Rs "+rr.getString("balance"));

          rr.close();
      }catch (Exception e)
      {
          System.out.println(e);
      }
      try{
           Conn c=new Conn();
          String query2="select *from bank where pin='"+pinnumber+"'";
          ResultSet rs=c.s.executeQuery(query2);
          while(rs.next())
          {
              mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
          }

      }catch (Exception e) {
          System.out.println(e);
      }

      setSize(400,600);
      setLocation(20,20);
      getContentPane().setBackground(Color.WHITE);
      setVisible(true);
    }
    public static void main(String[] args) {
        new Ministatement("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
