package org.baeldung.grpc.server.BLL;

import org.baeldung.grpc.server.DAO.PatientDAO;
import org.baeldung.grpc.server.entities.Patient;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PatientBLL {
    private PatientDAO clientDAO;

    public PatientBLL() {
        clientDAO = new PatientDAO();
    }

    public List<Patient> selectAll() throws SQLException {
        List<Patient> listaPatienti = new ArrayList<Patient>();
        listaPatienti = clientDAO.selectAll();
        if (listaPatienti == null) {
            JOptionPane.showMessageDialog(null, "Nu se gasesc clienti!");
            throw new NoSuchElementException("Nu se gasesc clienti!");
        }
        return listaPatienti;
    }
//    public Patient insert(Integer id,String nume,Integer varsta) {
//        Patient clientCurent = null;
//        try {
//            clientCurent = clientDAO.insert(id,nume,varsta);
//            if (clientCurent == null) {
//                JOptionPane.showMessageDialog(null,"Patientul cu id-ul " + id +" nu a fost inserat!");
//                throw new NoSuchElementException("Patientul cu id-ul " + id +" nu a fost inserat!");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return clientCurent;
//    }
//
//    public Patient update(Integer noulId,String noulNume,Integer nouaVarsta,int vechiulId) {
//        Patient clientCurent = null;
//
//        try {
//
//            clientCurent = clientDAO.update(noulId,noulNume,nouaVarsta,vechiulId);
//            if (clientCurent == null) {
//                JOptionPane.showMessageDialog(null,"Patientul cu id-ul " + vechiulId +" nu a fost actualizat!");
//                throw new NoSuchElementException("Patientul cu id-ul " + vechiulId +" nu a fost actualizat!");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return clientCurent;
//    }
//
//    public Patient delete(int id,String name) {
//        Patient clientCurent = null;
//        try {
//            clientCurent = clientDAO.delete(name,id);
//            if (clientCurent == null) {
//                //JOptionPane.showMessageDialog(null,"Patientul cu id-ul " + id +" nu a fost sters!");
//                throw new NoSuchElementException("Patientul cu id-ul " + id +" nu a fost sters!");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return clientCurent;
//    }

    public Patient findPatientById(int id) {
        Patient clientCurent = null;
        try {
            clientCurent = clientDAO.findById(id);
            if (clientCurent == null) {
                JOptionPane.showMessageDialog(null, "Patientul cu id-ul " + id + " nu a fost gasit!");
                throw new NoSuchElementException("Patientul cu id-ul " + id + " nu a fost gasit!");
            }
            return clientCurent;
        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return clientCurent;
    }
}