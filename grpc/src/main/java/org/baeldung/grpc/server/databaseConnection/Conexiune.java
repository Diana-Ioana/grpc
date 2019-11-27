package org.baeldung.grpc.server.databaseConnection;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Logger;

public class Conexiune {

    private static final Logger LOGGER = Logger.getLogger(Conexiune.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private static Conexiune singleInstance = new Conexiune();

    public Conexiune() {
        try {
            Class.forName(DRIVER); //se incearca sa se faca conexiunea la driver-ul bd
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER,PASSWORD);//se acceseaza driveManager-ul cu datele specifice bd
           // LOGGER.info("S-a realizat conexiunea la baza de date");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nu se poate realiza conexiunea la baza de date");
            e.printStackTrace();
        }
        return connection;
    }


    public static Connection getConnection() {
        return singleInstance.createConnection();
    }


    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Nu se poate inchide baza de date");
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Nu se poate inchide ResultSet");
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Nu se poate inchide Statement");
                e.printStackTrace();
            }
        }
    }
}
