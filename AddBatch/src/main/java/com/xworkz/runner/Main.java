package com.xworkz.runner;

import com.xworkz.dao.StudentDao;
import com.xworkz.dao.impl.StudentDaoImpl;
import com.xworkz.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDto student1=new StudentDto("sagarhd001","sagar123");
        StudentDto student2=new StudentDto("sagarshaiva001","sagar123");
        List<StudentDto> students=new ArrayList<>();
        students.add(student1);
        students.add(student2);
        StudentDao studentdao=new StudentDaoImpl();
        try {
            studentdao.addStudents(students);
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
}
