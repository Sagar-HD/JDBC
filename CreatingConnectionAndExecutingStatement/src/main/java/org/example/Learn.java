package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Learn {


    public static void main(String[] args) throws SQLException {
        Driver driver;
        System.out.println("driver loaded sucessfully");
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_db", "root", "sagarhd");
            System.out.println("connection succesfull");

            String query = "insert into payment (from_account,to_account,amount) values(0000000,0000000,'100')";
            String query2 = "delete from payment where amount=100";
            st = con.createStatement();
            st.execute(query);
            System.out.println("data saved ");

        } catch (SQLException e) {
            System.out.println("exception occured");
          throw e;

        } finally {
            if(con!=null) {
                con.close();
            }
            if(st!=null) {
                st.close();
            }

        }


    }
}
