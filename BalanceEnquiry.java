package eBanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    int balance = 0;
    BalanceEnquiry(String pin) {
        this.pin = pin;

        JLabel l1 = new JLabel();
        l1.setFont(new Font("System", Font.BOLD, 30));
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery(" select *from bank where pin = '" + pin + "' ");
            while (rs.next()) {
                if (rs.getString("mode").equals(("Deposit"))) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        l1.setText("Your current account balance is Rs " + balance);

        JButton b1 = new JButton("Back");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);

        setLayout(null);

        l1.setBounds(40,100,800,60);
        add(l1);

        b1.setBounds(500, 210, 150, 35);
        add(b1);

        setSize(750,310);
        setLocation(400,20);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

         public static void main(String[] args){
                new BalanceEnquiry("").setVisible(true);
           }
}