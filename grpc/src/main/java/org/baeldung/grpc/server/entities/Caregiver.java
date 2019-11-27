package org.baeldung.grpc.server.entities;
import com.sun.tools.javac.util.List;

import java.util.Date;
import java.util.Set;

public class Caregiver {
    /**
     *`idCaregiver` INT NOT NULL AUTO_INCREMENT,
     *   `nameCaregiver` VARCHAR(45) NULL,
     *   `surnameCaregiver` VARCHAR(45) NULL,
     *   `genderCaregver` CHAR(3) NULL,
     *   `addressCaregiver` VARCHAR(45) NULL,
     *   `birthdateCaregiver` DATETIME(5) NULL,
     *   `emailCaregiver` VARCHAR(45) NULL,
     *   `passwordCaregiver` VARCHAR(45) NULL,
     */

    private int idCaregiver;
    private String caregiverName;
    private String caregiverSurname;
    private String caregiverGender;
    private String caregiverAddress;
    private Date caregiverBirthdate;
    private String caregiverEmail;
    private String caregiverPassword;

    public Caregiver(int idCaregiver, List<Integer> CaregiverList) {
        this.idCaregiver = idCaregiver;
    }

    public Caregiver(int idCaregiver, String caregiverName, String caregiverSurname, String caregiverGender, String caregiverAddress, Date caregiverBirthdate) {
        this.idCaregiver = idCaregiver;
        this.caregiverName = caregiverName;
        this.caregiverSurname = caregiverSurname;
        this.caregiverGender = caregiverGender;
        this.caregiverAddress = caregiverAddress;
        this.caregiverBirthdate = caregiverBirthdate;
    }


    public Caregiver() {}

    public int getIdCaregiver() {
        return idCaregiver;
    }

    public void setIdCaregiver(int idCaregiver) {
        this.idCaregiver = idCaregiver;
    }

    public String getCaregiverName() {
        return caregiverName;
    }

    public void setCaregiverName(String caregiverName) {
        this.caregiverName = caregiverName;
    }

    public String getCaregiverSurname() {
        return caregiverSurname;
    }

    public void setCaregiverSurname(String caregiverSurname) {
        this.caregiverSurname = caregiverSurname;
    }

    public String getCaregiverGender() {
        return caregiverGender;
    }

    public void setCaregiverGender(String caregiverGender) {
        this.caregiverGender = caregiverGender;
    }

    public String getCaregiverAddress() {
        return caregiverAddress;
    }

    public void setCaregiverAddress(String caregiverAddress) {
        this.caregiverAddress = caregiverAddress;
    }

    public Date getCaregiverBirthdate() {
        return caregiverBirthdate;
    }

    public void setCaregiverBirthdate(Date caregiverBirthdate) {
        this.caregiverBirthdate = caregiverBirthdate;
    }

    public String getCaregiverEmail() {
        return caregiverEmail;
    }

    public void setCaregiverEmail(String caregiverEmail) {
        this.caregiverEmail = caregiverEmail;
    }

    public String getCaregiverPassword() {
        return caregiverPassword;
    }

    public void setCaregiverPassword(String caregiverPassword) {
        this.caregiverPassword = caregiverPassword;
    }

    }
