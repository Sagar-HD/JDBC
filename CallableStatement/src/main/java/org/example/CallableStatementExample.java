package org.example;
import java.sql.*;

public class CallableStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "sagarhd";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                CallableStatement cs = con.prepareCall("{call addStudent(?,?)}")
        ) {

            cs.setString(1, "hanuman");
            cs.setString(2, "hanuman123");

            int rows = cs.executeUpdate();

            System.out.println(rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}