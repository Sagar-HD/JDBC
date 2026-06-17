package com.xworkz.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=null;
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","sagarhd");
        return con;

    }
    public static void closeResources(Connection con, Statement st) throws SQLException {
        if(st!=null){
            st.close();
        }
        if(con!=null){
            con.close();
        }
    }
}
