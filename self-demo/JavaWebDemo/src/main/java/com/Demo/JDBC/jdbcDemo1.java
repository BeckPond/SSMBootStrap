package com.Demo.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=GMT%2B8","root","952712138");
            stat = conn.createStatement();
//            rs =stat.executeQuery("select *from stu where " )
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                System.out.println("连接关闭了");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
