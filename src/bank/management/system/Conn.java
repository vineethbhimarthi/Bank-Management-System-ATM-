package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.sql.PreparedStatement;

public class Conn {
    Connection c;
    Statement s;
   //PreparedStatement ps;
    public Conn(){
        try{
//            Class.forName(com.mysql.cj.jdbc.Driver);
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1234");
            s=c.createStatement();
            //ps=c.prepareStatement("");
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
