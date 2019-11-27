package org.baeldung.grpc.server.DAO;

import org.baeldung.grpc.server.databaseConnection.Conexiune;
import org.baeldung.grpc.server.entities.Caregiver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CaregiverDAO {

    Statement statement = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement findStatement = null;


    private static final Logger LOGGER = Logger.getLogger(CaregiverDAO.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private static final String selectAll = "Select * from Caregiver";

    private final static String findStatementString = "SELECT * FROM caregiver where id_caregiver = ?";


    public ArrayList<Caregiver> selectAll() {
        Caregiver toReturn = null;
        ArrayList<Caregiver> lista = new ArrayList<Caregiver>();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);


            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_caregiver");
                String address = resultSet.getString("caregiver_address");
                String email = resultSet.getString("caregiver_email");
                Date birthdate = resultSet.getDate("caregiver_birthdate");
                String gender = resultSet.getString("caregiver_gender");
                String password = resultSet.getString("caregiver_password");
                String name = resultSet.getString("caregiver_name");
                String surname = resultSet.getString("caregiver_surname");
                toReturn = new Caregiver(id, name, surname, gender, address, birthdate);
                lista.add(toReturn);
            }
            System.out.println(lista);
        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return lista;
    }

    public static Caregiver findById(int studentId) {
        Caregiver toReturn = null;

        Connection dbConnection = Conexiune.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);


            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            rs.next();

            // String idStudent=rs.getString(1,"idStudent");
            String address = rs.getString("caregiver_address");
            String email = rs.getString("caregiver_email");
            Date birthdate = rs.getDate("caregiver_birthdate");
            String gender = rs.getString("caregiver_gender");
            String password = rs.getString("caregiver_password");
            String name = rs.getString("caregiver_name");
            String surname = rs.getString("caregiver_surname");
            toReturn = new Caregiver(studentId, name, surname, gender, address,birthdate);
        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return toReturn;
    }

}