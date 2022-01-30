package eBanking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame implements ActionListener{

    JButton b1;
    JLabel l1;
    String pin;

    MiniStatement(String pin){
        super("Mini Statement");
        this.pin = pin;

        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLayout(null);
        setLocation(20,20);

        l1 = new JLabel();
        l1.setBounds(20,80,400,20);
        add(l1);

        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150,20,200,20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20,120,400,200);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20,350,400,20);
        add(l4);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from login where pin = '"+pin+"'");
            while (rs.next()){
                l1.setText("Card Number:    " + rs.getString("cardno").substring(0,4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }

        }catch (Exception e){

        }
            int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from bank where pin = '"+pin+"'");
            while (rs.next()){
                l3.setText(l3.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("mode").equals(("Deposit"))) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch (Exception e){

        }

        l4.setText("Your current Account Balance is Rs " + balance);

        b1 = new JButton("Back");
        b1.setBounds(20,440,80,25);
        add(b1);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
                setVisible(false);
    }

    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
}
