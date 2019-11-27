package org.baeldung.grpc.server.entities;
import java.sql.Date;

public class Patient {
    /*
    `idPatient` INT NOT NULL AUTO_INCREMENT,
  `namePatient` VARCHAR(45) NULL,
  `surnamePatient` VARCHAR(45) NULL,
  `genderPatient` CHAR(3) NULL,
  `birthdatePatient` DATETIME(5) NULL,
  `addressPatient` VARCHAR(45) NULL,
  `Caregiver_idCaregiver` INT NOT NULL,
  `emailPatient` VARCHAR(45) NULL,
  `passwordPatient` VARCHAR(45) NULL,
   */
    private int idPatient;
    private String patientName;
    private String patientSurname;
    private String patientGender;
    private Date patientBirthdate;
    private String patientAddress;
    private String patientEmail;
    private String patientPassword;
    private int Caregiver_idCaregiver;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MedicalRecord_idMedicalRecord", referencedColumnName = "idMedicalRecord")
    private MedicalRecord medicalRecord;
*/

//
//     @OneToOne(mappedBy = "Patient",fetch = FetchType.EAGER)
//    private MedicationPlan medicationPlan;

    public Patient(int idPatient, int caregiver_idCaregiver) {
        this.idPatient = idPatient;
        Caregiver_idCaregiver = caregiver_idCaregiver;
    }


    public Patient(int idPatient, String patientName, String patientSurname, String patientGender, Date patientBirthdate, String patientAddress, String patientEmail, String patientPassword, int caregiver_idCaregiver) {
        this.idPatient = idPatient;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.patientAddress = patientAddress;
        this.patientEmail = patientEmail;
        this.patientPassword = patientPassword;
        Caregiver_idCaregiver = caregiver_idCaregiver;
    }


    public Patient(int idPatient, String patientName, String patientSurname, String patientGender, Date patientBirthdate, String patientAddress, int caregiver_idCaregiver) {
        this.idPatient = idPatient;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.patientAddress = patientAddress;
        Caregiver_idCaregiver = caregiver_idCaregiver;
    }

    public Patient(int idPatient, String patientName, String patientSurname, String patientGender, Date patientBirthdate, String patientAddress) {
        this.idPatient = idPatient;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientGender = patientGender;
        this.patientBirthdate = patientBirthdate;
        this.patientAddress = patientAddress;
    }

    public Patient() {
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Date getPatientBirthdate() {
        return patientBirthdate;
    }

    public void setPatientBirthdate(Date patientBirthdate) {
        this.patientBirthdate = patientBirthdate;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public int getCaregiver_idCaregiver() {
        return Caregiver_idCaregiver;
    }

    public void setCaregiver_idCaregiver(int caregiver_idCaregiver) {
        Caregiver_idCaregiver = caregiver_idCaregiver;
    }
}
