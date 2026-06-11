package com.xworkz.project1;

import java.sql.*;
import java.time.LocalDateTime;

public class Learn {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_db","root","sagarhd");
            st=con.createStatement();
            String insertQuery="insert into payment (from_account,to_account,amount) values(789789,987654321,100)";
            String selectQuery="select * from payment";
            //execute return boolean
            //true when there is result to display
            //false when updated something

            boolean res=st.execute(insertQuery);
            System.out.println(res);
            //execute update return integer
            int num=st.executeUpdate(insertQuery);
            System.out.println(num);
            //execute Query returns ResultSet
           rs=st.executeQuery(selectQuery);
            while(rs.next()){
                int id=rs.getInt("payment_id");
                String from_account=rs.getString("from_account");
                String to_account=rs.getString("to_account");
                double amount=rs.getDouble("amount");
                LocalDateTime date= rs.getDate("payment_date").toLocalDate().atStartOfDay();
                System.out.println("id :"+id+" from :"+from_account+" to:"+to_account+" Date:"+date);
            }


        }
        catch (Exception e){
            throw  e;
        }
        finally {
            if(rs!=null){
                rs.close();
            }
            if(st!=null) {
                st.close();
            }
            if(con!=null){
            con.close();
            }
        }

    }
}
