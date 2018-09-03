package com.imokhonko.DAO;

import com.imokhonko.DAO.interfaces.IUserDAO;
import com.imokhonko.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements IUserDAO {

    private final static Logger logger = Logger.getLogger (getCurrentClassName());

    private final String URL = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC&useSSL=false";
    private final String userName = "root";
    private final String password = "";

    public List<User> selectAll() {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<User> list = new ArrayList<> ();

        try {
            conn = DriverManager.getConnection (URL, userName, password);
            logger.trace ("connection to db successfull");

            statement = conn.prepareStatement ("SELECT * FROM client");
            resultSet = statement.executeQuery ();

            logger.trace ("select data from db is successfull");

            while (resultSet.next ()) {
                String name = resultSet.getString ("name");
                String phone_number = resultSet.getString ("phone_number");
                String email = resultSet.getString ("email");
                String address = resultSet.getString ("address");
                User user = new User.Builder ()
                        .name (name)
                        .phone_number (phone_number)
                        .email (email)
                        .address (address)
                        .build ();
                list.add (user);
            }

        } catch (SQLException e) {
            logger.warn ("sql exception during executiong query to database");
            rollbackQuitely (conn);
        } finally {
            closeQuitely (resultSet);
            closeQuitely (statement);
            closeQuitely (conn);
        }
        return list;
    }

    public User selectUserByAddress(String address) {
        return null;
    }

    private void closeQuitely(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
                logger.trace ("connection closed successfully");
                return;
            } catch (SQLException e) {
                logger.warn ("connection is not closec");
            }
        }
        logger.trace ("connection is null");
    }

    private void closeQuitely(PreparedStatement statement) {
        if(statement != null) {
            try {
                statement.close();
                logger.trace ("statement closed successfully");
                return;
            } catch (SQLException e) {
                logger.warn ("statement is not closed");
            }
        }
        logger.warn ("statement is null");
    }

    private void closeQuitely(ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
                logger.trace ("resultSet closed successfully");
                return;
            } catch (SQLException e) {
                logger.warn ("resultSet is not closed");
            }
        }
        logger.warn ("resultSet is null");
    }

    private void rollbackQuitely(Connection conn) {
        if(conn != null) {
            try {
                conn.rollback ();
                logger.trace ("rollback successfull");
                return;
            } catch (SQLException e) {
                logger.warn ("rollback is not successfull");
            }
        }
        logger.trace ("connection for rollback is null");
    }

    private static String getCurrentClassName() {
        try {
            throw new RuntimeException ();
        } catch (RuntimeException e) {
            return e.getStackTrace ()[1].getClassName ();
        }
    }

}
