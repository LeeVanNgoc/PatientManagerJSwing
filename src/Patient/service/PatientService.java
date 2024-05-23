/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patient.service;

import Patient.data.PatientDown;
import Patient.model.Patient;
import java.util.List;

/**
 *
 * @author Adminis
 */
public class PatientService {

    private PatientDown patientDown;

    public PatientService() {
        patientDown = new PatientDown();
    }
    
    public List<Patient> getAllPatients(){
        return patientDown.getAllPatients();
    }
    
    public Patient getPatientById(int id) {
        return patientDown.getPatientById(id);
    }
    
    public void addPatient(Patient patient) {
        patientDown.addPatient(patient);
    }
    
    public void updatePatient(Patient patient) {
        patientDown.updatePatient(patient);
    }
    
    public void deletePatient(int id) {
        patientDown.deletePatient(id);
    }
}
