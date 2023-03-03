package com.musi.shop.web.dto;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionTest {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/musi?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "74700";

    @Test
    public void testConnection() throws Exception {
        Class.forName(DRIVER);
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
