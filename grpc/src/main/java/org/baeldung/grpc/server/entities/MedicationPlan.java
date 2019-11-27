package org.baeldung.grpc.server.entities;

import java.sql.Date;
import java.util.Set;

public class MedicationPlan {
    /*One to Many mapping
     * idMedications
     * idPatient
     * Date of begining
     * Date of ending
     * IdMedPlan
     * */
    private int idMedicationPlan;
    private Date startDate;
    private Date endDate;

    //    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Patient_idPatient", referencedColumnName = "idPatient")
//    private Patient patient;
    private int patient;
    Set<Medication> medicationsList;

    public MedicationPlan(int idMedicationPlan, Date startDate, Date endDate, int patient, Set<Medication> medicationsList) {
        this.idMedicationPlan = idMedicationPlan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.patient = patient;
        this.medicationsList = medicationsList;
    }

    public MedicationPlan() {
    }

    public int getIdMedicationPlan() {
        return idMedicationPlan;
    }

    public void setIdMedicationPlan(int idMedicationPlan) {
        this.idMedicationPlan = idMedicationPlan;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPatient_idPatient() {
        return patient;
    }

    public void setPatient_idPatient(int patient_idPatient) {
        patient = patient_idPatient;
    }

    public Set<Medication> getMedicationsList() {
        return medicationsList;
    }

    public void setMedicationsList(Set<Medication> medicationsList) {
        this.medicationsList = medicationsList;
    }
}
