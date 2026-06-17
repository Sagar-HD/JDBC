package com.xworkz.dao.impl;

import com.xworkz.dao.StudentDao;
import com.xworkz.dbutil.DbUtil;
import com.xworkz.dto.StudentDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudents(List<StudentDto> students) throws ClassNotFoundException, SQLException {
        if(students!=null){
            Connection con= DbUtil.getConnection();
            String insertQuery="insert into student values(?,?)";
            PreparedStatement ps=con.prepareStatement(insertQuery);
            for(StudentDto student :students){
                ps.setString(1,student.getUsername());
                ps.setString(2,student.getPassword());
                ps.addBatch();

            }
            int[] result=ps.executeBatch();
            for(int i:result){
                if(i>0){
                    System.out.println(
                            "success"
                    );
                }
                else{
                    System.out.println("failed");
                }
            }
            DbUtil.closeResources(con,ps);

        }


    }
}
