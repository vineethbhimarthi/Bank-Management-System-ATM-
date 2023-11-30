package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {
    String pinnumber;
    JPasswordField npinf, rpinf;
    JButton change, cancel;

    Pinchange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 710, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 710);
        add(image);
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(300, 250, 400, 25);
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel newpin = new JLabel("New PIN");
        newpin.setFont(new Font("Raleway", Font.BOLD, 16));
        newpin.setForeground(Color.WHITE);
        newpin.setBounds(200, 340, 100, 25);
        image.add(newpin);
        npinf = new JPasswordField();
        npinf.setBounds(350, 340, 200, 25);
        npinf.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(npinf);


        JLabel rpin = new JLabel("Re-Enter New PIN");
        rpin.setFont(new Font("Raleway", Font.BOLD, 16));
        rpin.setForeground(Color.WHITE);
        rpin.setBounds(200, 375, 150, 25);
        image.add(rpin);
        rpinf = new JPasswordField();
        rpinf.setBounds(350, 375, 200, 25);
        rpinf.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(rpinf);

        change = new JButton("CHANGE");
        change.setFont(new Font("Raleway", Font.BOLD, 12));
        change.setForeground(Color.WHITE);
        change.setBackground(Color.GREEN);
        change.setBounds(500, 440, 90, 20);
        change.addActionListener(this);
        image.add(change);

        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Raleway", Font.BOLD, 12));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.RED);
        cancel.setBounds(500, 470, 90, 20);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(800, 710);
        setLocation(270, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Pinchange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String newpinno = npinf.getText();
            String repinno = rpinf.getText();
            if (newpinno.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the New Pin");
                return;
            }
            if (repinno.equals("")) {
                JOptionPane.showMessageDialog(null, "Re-Enter the New Pin");
                return;
            }
            if (!repinno.equals(newpinno)) {
                JOptionPane.showMessageDialog(null, "Pin number Mismatch");
                return;
            }
            try {
                Conn c = new Conn();
                String query1 = "update signupthree set Pin='" + newpinno + "' where Pin='" + pinnumber + "'";
                String query2 = "update login set Pin='" + newpinno + "' where Pin='" + pinnumber + "'";
                String query3 = "update bank set pin='" + newpinno + "' where pin='" + pinnumber + "'";
                String query4 = "update bankbalance set pin='" + newpinno + "' where pin='" + pinnumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                c.s.executeUpdate(query4);

                JOptionPane.showMessageDialog(null, "Pin changed Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception exe) {
                System.out.println(exe);
            }

        }
    }
}

