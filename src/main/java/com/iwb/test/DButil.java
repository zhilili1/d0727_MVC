package com.iwb.test;

import java.sql.Connection;
import java.sql.DriverManager;

@DB(driveClassName = "com.mysql.jdbc.Driver",url="jdbc:mysql://localhost:3306/testmvc?characterEncoding=utf8",
        username = "root",password = "a12345")
public class DButil {
    public  static Connection getConnection() throws Exception {
        DB db =DButil.class.getAnnotation(DB.class);
        String driverClassName=db.driveClassName();
        String url =db.url();
        String username=db.username();
        String password =db.password();
        Class.forName(driverClassName);
        Connection c = DriverManager.getConnection(url,username,password);
        return c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }
}
