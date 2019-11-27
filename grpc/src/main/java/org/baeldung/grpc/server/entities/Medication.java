package org.baeldung.grpc.server.entities;

public class Medication {
    /*
    *  `idmedication` INT NOT NULL,
  `nameMedication` VARCHAR(45) NULL,
  `dosage` VARCHAR(45) NULL,
  `medicationcol` VARCHAR(45) NULL,
  PRIMARY KEY (`idmedication`))
    */

    private int idmedication;
    private String medicationName;
    private String dosage;
    private String sideEffects;

    //this is caculated in hours eg: intakeIntervals=8-> the medicine is  taken every 8 hours
    private int intakeIntervals=0;
    private int Medication_idMedication;

    public Medication(int idmedication, String medicationName) {
        this.idmedication = idmedication;
        this.medicationName = medicationName;
    }

    public Medication(int idmedication, String medicationName, String dosage, String sideEffects, int intakeIntervals, int medication_idMedication) {
        this.idmedication = idmedication;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.sideEffects = sideEffects;
        this.intakeIntervals = intakeIntervals;
        Medication_idMedication = medication_idMedication;
    }

    public Medication() {}

    public int getIdmedication() {
        return idmedication;
    }

    public void setIdmedication(int idmedication) {
        this.idmedication = idmedication;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public int getIntakeIntervals() {
        return intakeIntervals;
    }

    public void setIntakeIntervals(int intakeIntervals) {
        this.intakeIntervals = intakeIntervals;
    }

    public int getMedication_idMedication() {
        return Medication_idMedication;
    }

    public void setMedication_idMedication(int medication_idMedication) {
        Medication_idMedication = medication_idMedication;
    }
}
