package com.xworkz.addDriver;

public class Learn {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver loaded sucessfully");
    }

}
