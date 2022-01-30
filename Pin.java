package eBanking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener{
    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;

    Pin(String pin){
        this.pin = pin;

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 35));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("eBanking/icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(120, 100, 100, 100);
        add(l11);

        l2 = new JLabel("NEW PIN");
        l2.setFont(new Font("System", Font.BOLD, 22));

        l3 = new JLabel("RE-ENTER");
        l3.setFont(new Font("System", Font.BOLD, 22));

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("CHANGE");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);


        setLayout(null);


        l1.setBounds(220,130,800,60);
        add(l1);

        l2.setBounds(100,240,150,40);
        add(l2);

        l3.setBounds(100,300,150,40);
        add(l3);

        t1.setBounds(310,240,360,40);
        add(t1);

        t2.setBounds(310,300,360,40);
        add(t2);

        b1.setBounds(220,400,160,50);
        add(b1);

        b2.setBounds(400,400,160,50);
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
            String npin = t1.getText();
            String repin = t2.getText();

            if(ae.getSource()==b1){
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please New PIN");
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                }
                if(npin.equals(repin)){

                    Conn c1 = new Conn();
                    String q = " update bank set pin = '"+repin+"' where pin = '"+pin+"'";
                    String q2 = " update login set pin = '"+repin+"' where pin = '"+pin+"' ";
                    String q3 = " update signup3 set pin = '"+repin+"' where pin = '"+pin+"' ";

                    c1.s.executeQuery(q);
                    c1.s.executeQuery(q2);
                    c1.s.executeQuery(q3);

                    JOptionPane.showMessageDialog(null, "Pin Changed Successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "PIN entered doesn't match");
                }

            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        new Pin("").setVisible(true);
    }
}

