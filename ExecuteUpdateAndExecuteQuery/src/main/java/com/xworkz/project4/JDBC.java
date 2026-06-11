package com.xworkz.project4;


import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver class loaded  and registered to Driver Manager");
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_db","root","sagarhd");
            st=con.createStatement();
            String insertQuery="insert into payment (from_account,to_account,amount) values ('999','678',1000)";
            String updateQuery="update payment set amount=100 where from_account=99 ";
            String selectQuery="select * from payment where from_account=999";
            String deleteQuery="delete from payment where from_account=999";

            int rowsInserted=st.executeUpdate(insertQuery);
            System.out.println(rowsInserted);
            System.out.println("data inserted");
            int rowsUpdated=st.executeUpdate(updateQuery);
            System.out.println(rowsUpdated);
            System.out.println("data updated");
            rs=st.executeQuery(selectQuery);
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getDate(5).toLocalDate().atStartOfDay()+" ");
            }
            int rowsDeleted=st.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted);
            System.out.println("data deleted");




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
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
}
