package org.baeldung.grpc.server.BLL;

import org.baeldung.grpc.server.DAO.MedicationDAO;
import org.baeldung.grpc.server.entities.Medication;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MedicationBLL {
        private MedicationDAO clientDAO;

        public MedicationBLL() {
            clientDAO = new MedicationDAO();
        }

//        public List<Medication> selectAll() throws SQLException {
//            List<Medication> listaMedicationi = new ArrayList<Medication>();
//            listaMedicationi=clientDAO.printAllMedicationsForPatientId();
//            if (listaMedicationi == null) {
//                JOptionPane.showMessageDialog(null,"Nu se gasesc clienti!");
//                throw new NoSuchElementException("Nu se gasesc clienti!");
//            }
//            return listaMedicationi;
//        }
//        public Medication insert(Integer id,String nume,Integer varsta) {
//            Medication clientCurent = null;
//            try {
//                clientCurent = clientDAO.insert(id,nume,varsta);
//                if (clientCurent == null) {
//                    JOptionPane.showMessageDialog(null,"Medicationul cu id-ul " + id +" nu a fost inserat!");
//                    throw new NoSuchElementException("Medicationul cu id-ul " + id +" nu a fost inserat!");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return clientCurent;
//        }
//
//        public Medication update(Integer noulId,String noulNume,Integer nouaVarsta,int vechiulId) {
//            Medication clientCurent = null;
//
//            try {
//
//                clientCurent = clientDAO.update(noulId,noulNume,nouaVarsta,vechiulId);
//                if (clientCurent == null) {
//                    JOptionPane.showMessageDialog(null,"Medicationul cu id-ul " + vechiulId +" nu a fost actualizat!");
//                    throw new NoSuchElementException("Medicationul cu id-ul " + vechiulId +" nu a fost actualizat!");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return clientCurent;
//        }
//
//        public Medication delete(int id,String name) {
//            Medication clientCurent = null;
//            try {
//                clientCurent = clientDAO.delete(name,id);
//                if (clientCurent == null) {
//                    //JOptionPane.showMessageDialog(null,"Medicationul cu id-ul " + id +" nu a fost sters!");
//                    throw new NoSuchElementException("Medicationul cu id-ul " + id +" nu a fost sters!");
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return clientCurent;
//        }

        public Medication findMedicationById(int id){
            Medication clientCurent = null;
            clientCurent = clientDAO.printAllMedicationsForPatientId(id);
            if (clientCurent == null) {
                JOptionPane.showMessageDialog(null,"Medicationul cu id-ul " + id +" nu a fost gasit!");
                throw new NoSuchElementException("Medicationul cu id-ul " + id +" nu a fost gasit!");
            }
            return clientCurent;
        }
    }

