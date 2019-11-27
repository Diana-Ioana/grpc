package org.baeldung.grpc.server.DAO;

import org.baeldung.grpc.server.entities.Medication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class MedicationDAO {

    Statement statement = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement findStatement = null;


    private static final Logger LOGGER = Logger.getLogger(MedicationDAO.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Medication printAllMedicationsForPatientId(int medication )  {
        Medication currentMedication = new Medication();
        String  query = "SELECT * FROM medication where medication_id_medication = ?";
        List<Medication> medicationList = new ArrayList();

        ResultSet rs = null;

        try {

            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);

            findStatement = connection.prepareStatement(query);
            findStatement.setInt(1, medication);
            resultSet = findStatement.executeQuery();

            while (resultSet.next()) {




                int idmedication=resultSet.getInt("idmedication");
                String dosage = resultSet.getString("dosage");
                int intokeInterval = resultSet.getInt("intake_interval");
                String medicationName = resultSet.getString("medication_name");
                int medication_id_medication = resultSet.getInt(medication);
                String sideEffects= resultSet.getString("side_effects");


                currentMedication.setIdmedication(idmedication);
                currentMedication.setDosage(dosage);
                currentMedication.setIntakeIntervals(intokeInterval);
                currentMedication.setMedication_idMedication(medication_id_medication);
                currentMedication.setMedicationName(medicationName);
                currentMedication.setSideEffects(sideEffects);


                // print the results
                //  LOGGER.info( id+ " "+ intokeInterval+" "+ periodTreatment+" ");

                medicationList.add(currentMedication);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return currentMedication;
    }


}
