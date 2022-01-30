package eBanking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{
    JTextField t1;
    JButton b1,b2;
    JLabel l1,l2;
    String pin;

    Withdrawal(String pin){
        this.pin = pin;


        l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        l1.setFont(new Font("System", Font.BOLD, 35));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eBanking/icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(30, 70, 100, 100);
        add(l11);

        l2 = new JLabel(" IS RS.10,000");
        l2.setFont(new Font("System", Font.BOLD, 35));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("WITHDRAWAL");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setLayout(null);


        l1.setBounds(130,100,800,60);
        add(l1);

        l2.setBounds(300,160,800,60);
        add(l2);

        t1.setBounds(220,250,360,50);
        add(t1);

        b1.setBounds(230,350,165,50);
        add(b1);

        b2.setBounds(410,350,160,50);
        add(b2);



        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,600);
        setLocation(400,20);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        try{

            if(ae.getSource()==b1){
                String amount = t1.getText();
                Date date = new Date();
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }
                else {
                    Conn c1 = new Conn();
                    ResultSet rs = c1.s.executeQuery(" select *from bank where pin = '"+pin+"' ");
                    int balance = 0;
                    while(rs.next()) {
                        if (rs.getString("mode").equals(("Deposit"))) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    String q1 = "insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')";

                    c1.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if(ae.getSource()== b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        new Withdrawal("").setVisible(true);
    }
}
