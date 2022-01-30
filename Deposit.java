package eBanking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener{

    JTextField t1;
    JButton b1,b2;
    JLabel l1;
    String pin;
    Deposit(String pin){

        this.pin = pin;
        setTitle("DEPOSIT");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eBanking/icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 90, 100, 100);
        add(l11);

        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setFont(new Font("System", Font.BOLD, 35));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setLayout(null);

        l1.setBounds(170,120,800,60);
        add(l1);

        t1.setBounds(250,230,300,50);
        add(t1);

        b1.setBounds(260,330,125,50);
        add(b1);

        b2.setBounds(415,330,125,50);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(830,550);
        setLocation(400,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        try{

            if(ae.getSource()==b1){
                String amount = t1.getText();
                Date date = new Date();
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }
                else {
                    Conn c1 = new Conn();

                    c1.s.executeUpdate(" insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"'); ");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
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
            System.out.println("error: " +e);
        }
    }

    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}