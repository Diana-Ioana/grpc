package org.baeldung.grpc.server.DAO;

import org.baeldung.grpc.server.entities.Medication;
import org.baeldung.grpc.server.entities.MedicationPlan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MedicationPlanDAO {
    Statement statement = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement findStatement = null;


    private static final Logger LOGGER = Logger.getLogger(MedicationPlanDAO.class.getName());
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mydbsd";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public MedicationPlan printAllMedicationPlansForPatientId(int patient_id )  {
        MedicationPlan currentMedicationPlan = new MedicationPlan();
        String  query = "SELECT * FROM medication_plan where id_patient = ?";
        List<Medication> medicationList = new ArrayList();

        ResultSet rs = null;

        try {

            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);

            findStatement = connection.prepareStatement(query);
            findStatement.setInt(1, patient_id);
            resultSet = findStatement.executeQuery();

            while (resultSet.next()) {




                int id_medication_plan=resultSet.getInt("id_medication_plan");
                Date end_date=resultSet.getDate("end_date");
                Date start_date=resultSet.getDate("start_date");

                currentMedicationPlan.setIdMedicationPlan(id_medication_plan);
                currentMedicationPlan.setEndDate(end_date);
                currentMedicationPlan.setStartDate(start_date);
                currentMedicationPlan.setPatient_idPatient(patient_id);


                // print the results
                //  LOGGER.info( id+ " "+ intokeInterval+" "+ periodTreatment+" ");

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.getCause();
        }
        return currentMedicationPlan;
    }



}
