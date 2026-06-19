package com.xworkz.dbutil;

import java.sql.*;

public class DbUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {

        String url="jdbc:mysql://localhost:3306/excel_data";
        String username="root";
        String password="sagarhd";
        Connection con= DriverManager.getConnection(url,username,password);
        return con;
    }
    public static void closeResources(Connection con, Statement st, ResultSet rs) throws SQLException {
        if(rs!=null){
            rs.close();

        }
        if(st!=null){
            st.close();
        }
        if(con!=null){
            con.close();
        }
    }
}
