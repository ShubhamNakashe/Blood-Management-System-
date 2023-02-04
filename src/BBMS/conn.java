package BBMS;

import java.sql.*;
public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms", "root", "@Shubhu2003");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}