/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author admin
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/pfmsdemo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;
    private static Statement statement;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established!");
            JOptionPane.showMessageDialog(null, "Connection established!", 
                                              "Connection Status", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found", 
                                              "Connection Status", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            JOptionPane.showMessageDialog(null, "Failed to connect to the database", 
                                              "Connection Status", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        if (connection != null) {
                JOptionPane.showMessageDialog(null, "Connected to the database", 
                                              "Connection Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database", 
                                              "Connection Status", JOptionPane.ERROR_MESSAGE);
            }
        return connection;
    }
    

    public static ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}