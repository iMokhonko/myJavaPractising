package com.imokhonko;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String userName = "root";
        String password = "";
        String connectionUrl = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC&useSSL=false";

        // register driver
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println ("class not found exception");
//            return;
//        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = DriverManager.getConnection (connectionUrl, userName, password);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement ("INSERT INTO clients " +
                    "(name, phone_number, email, address,  register_date) " +
                    "VALUES ('someName', '38098848328', 'vifosdf@gmasl.co', 'Kiev',  ?)");
            statement.setDate (1, new Date(System.currentTimeMillis ()));
            statement.executeUpdate ();
            connection.commit ();
            System.out.println ("Success!");

        } catch (SQLException e) {
            System.out.println ("SQL EXCEPTION: " + e);
            try {
                if(connection != null) {
                    connection.rollback ();
                }
            } catch (SQLException rollback_exception) {
                System.out.println ("rollback exception \n" + rollback_exception);
            }
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close ();
                }
            } catch (SQLException e) {
                System.out.println ("result set close exception");
            }
            try {
                if(preparedStatement != null) {
                    preparedStatement.close ();
                }
            } catch (SQLException e) {
                System.out.println ("prepared statemnt exception");
            }
            try {
                if(connection != null) {
                    connection.close ();
                }
            } catch (SQLException e) {
                System.out.println ("connection exception");
            }
        }

    }
}
