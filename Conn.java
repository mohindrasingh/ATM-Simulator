package eBanking;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/bankmng","root","root");
            s = c.createStatement();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
