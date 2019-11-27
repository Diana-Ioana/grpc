package org.baeldung.grpc.server;

import org.baeldung.grpc.HelloRequest;
import org.baeldung.grpc.HelloResponse;
import org.baeldung.grpc.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;
import org.baeldung.grpc.server.BLL.PatientBLL;
import org.baeldung.grpc.server.DAO.MedicationDAO;
import org.baeldung.grpc.server.DAO.MedicationPlanDAO;
import org.baeldung.grpc.server.entities.Medication;
import org.baeldung.grpc.server.entities.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HelloServiceImpl extends HelloServiceImplBase {

    private static final Logger LOGGER = Logger.getLogger(GrpcServer.class.getName());

    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);


        List<Object> cnt = new ArrayList<Object>();
        List<Patient> patient1 = new ArrayList<Patient>();
        PatientBLL clientBll = new PatientBLL();


        try {
            patient1 = clientBll.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String id =" ";
        String name = "mama mia";
        String surname = "mama mia";
        String address = "mama mia";
        String birthDate = "mama mia";
        String gender = "mama mia";
        String medicalRecord = "mama mia";
        for(Patient it : patient1) {
            //  cnt.add(it);
            // LOGGER.info(it.getFirstName().toString());
            id = new StringBuilder()
                    .append(it.getIdPatient())
                    .toString();

            name = new StringBuilder()
                    .append(it.getPatientName())
                    .toString();
            surname = new StringBuilder()
                    .append(it.getPatientSurname())
                    .toString();
            address = new StringBuilder()
                    .append(it.getPatientAddress())
                    .toString();
            birthDate = new StringBuilder()
                    .append(it.getPatientBirthdate())
                    .toString();
            gender = new StringBuilder()
                    .append(it.getPatientGender())
                    .toString();
        }

        MedicationDAO medBD= new MedicationDAO();
        List<Medication> medicationList = medBD.printAllMedicationsForPatientId(Integer.parseInt(id));

        MedicationPlanDAO presBD = new MedicationPlanDAO();

//        LocalTime time = LocalTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        System.out.println("Ora curenta: "+time.format(formatter));



        String medicationId = " ";
        String medicationName=" ";
        String dosage =" ";
        String sideEffects=" ";
        String intokeInterval=" ";
        for(Medication it : medicationList) {
            medicationId +="#"+ it.getIdmedication();
            medicationName +="#"+it.getMedicationName();
            dosage +="#"+it.getDosage();
            sideEffects+="#"+it.getSideEffects();
            intokeInterval+="#"+it.getIntakeIntervals();
           // periodTreatment+="#"+(presBD.printAllPrescriptionsForPatientId(it.getId()).getPeriodTreatment());
        }
        HelloResponse response = HelloResponse.newBuilder()
                .setId(id)
                .setName(name)
                .setSurname(surname)
                .setAddress(address)
                .setBirthDate(birthDate)
                .setGender(gender)
                .setIdMedication(medicationId)
                .setMedicationName(medicationName)
                .setDosage(dosage)
                .setSideEffects(sideEffects)
                .setIntakeIntervals(intokeInterval)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
