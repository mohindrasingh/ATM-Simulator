package eBanking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Transactions(String pin){
        this.pin = pin;

        l1 = new JLabel("Please Select Your Transactions");
        l1.setFont(new Font("System", Font.BOLD, 38));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eBanking/icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(30, 60, 90, 100);
        add(l11);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);

        b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);

        b7= new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);


        setLayout(null);

        l1.setBounds(120,100,700,40);
        add(l1);

        b1.setBounds(40,250,300,60);
        add(b1);

        b2.setBounds(440,250,300,60);
        add(b2);

        b3.setBounds(40,360,300,60);
        add(b3);

        b4.setBounds(440,360,300,60);
        add(b4);

        b5.setBounds(40,470,300,60);
        add(b5);

        b6.setBounds(440,470,300,60);
        add(b6);

        b7.setBounds(240,600,300,60);
        add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(830,750);
        setLocation(400,20);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== b1){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource()== b2){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }
        else if(ae.getSource()== b3){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(ae.getSource()== b4){
//            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
        else if(ae.getSource()== b5){
            setVisible(false);
            new Pin(pin).setVisible(true);
        }
        else if(ae.getSource()== b6){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);

        }
        else if(ae.getSource()== b7){
            System.exit(0);
        }
    }

    public static void main(String[] arg){

        new Transactions("").setVisible(true);
    }
}
