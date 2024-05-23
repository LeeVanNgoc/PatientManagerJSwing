/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patient.data;

import Patient.model.Patient;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Adminis
 */
public class PatientDown {

    /**
     *
     * @return
     */
    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM PATIENT";
        
        try {
                Connection connection = JDBCConnection.getJDBCConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Patient patient = new Patient();

                    patient.setId(rs.getInt("ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setPhoneFamily(rs.getString("PHONEFAMILY"));
                    patient.setHealthStatus(rs.getString("HEALTHSTATUS"));
                    patient.setDiagnosis(rs.getString("DIAGNOSIS"));
                    
                    java.sql.Time waittingTime = rs.getTime("WAITTINGTIME");
                    if (waittingTime != null) {
                        patient.setWaittingTime(new Time(waittingTime.getTime()));
                    }
                    
                    java.sql.Date planned = rs.getDate("PLANNEDDISCHARGE");
                    if ( planned != null) {
                        patient.setPlannedDischarge(new Date(planned.getTime()));
                    }
                    
                    java.sql.Date addmission = rs.getDate("ADDMISSIONDATE");
                    if (addmission != null ) {
                        patient.setAddmissionDate(new Date(addmission.getTime()));
                    }
                    
                    java.sql.Date discharge = rs.getDate("DISCHARGEDATE");
                    if (discharge != null) {
                        patient.setDischargeDate(new Date(discharge.getTime()));
                    }

                    patients.add(patient);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return patients;
    }
    
    public Patient getPatientById(int id) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM USER WHERE ID = ?";
        
        try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Patient patient = new Patient();

                    patient.setId(rs.getInt("ID"));
                    patient.setName(rs.getString("NAME"));
                    patient.setPhoneFamily(rs.getString("PHONEFAMILY"));
                    patient.setHealthStatus(rs.getString("HEALTHSTATUS"));
                    patient.setDiagnosis(rs.getString("DIAGNOSIS"));
                    
                    java.sql.Time waittingTime = rs.getTime("WAITTINGTIME");
                    if (waittingTime != null) {
                        patient.setWaittingTime(new Time(waittingTime.getTime()));
                    }
                    
                    java.sql.Date planned = rs.getDate("PLANNEDDISCHARGE");
                    if ( planned != null) {
                        patient.setPlannedDischarge(new Date(planned.getTime()));
                    }
                    
                    java.sql.Date addmission = rs.getDate("ADDMISSIONDATE");
                    if (addmission != null ) {
                        patient.setAddmissionDate(new Date(addmission.getTime()));
                    }
                    
                    java.sql.Date discharge = rs.getDate("DISCHARGEDATE");
                    if (discharge != null) {
                        patient.setDischargeDate(new Date(discharge.getTime()));
                    }

                    return patient;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }
    
    public void addPatient(Patient patient) {
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "INSERT INTO PATIENT(ID, NAME, PHONEFAMILY, HEALTHSTATUS, DIAGNOSIS, WAITTINGTIME, PLANNEDDISCHARGE, ADDMISSIONDATE, DISCHARGEDATE) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patient.getId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getPhoneFamily());
            preparedStatement.setString(4, patient.getHealthStatus());
            preparedStatement.setString(5, patient.getDiagnosis());
            preparedStatement.setTime(6, patient.getWaittingTime());
            preparedStatement.setDate(7, (Date) patient.getPlannedDischarge());
            preparedStatement.setDate(8, (Date) patient.getAddmissionDate());
            preparedStatement.setDate(9, (Date) patient.getDischargeDate());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePatient(Patient patient) {
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "WAITTINGTIME = ?, PLANNEDDISCHARGE = ?, ADDMISSIONDATE = ?, DISCHARGEDATE = ?,"
                         + "UPDATE PATIENT SET NAME = ?, PHONEFAMILY = ?, HEALTHSTATUS = ?, DIAGNOSIS = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patient.getId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getPhoneFamily());
            preparedStatement.setString(4, patient.getHealthStatus());
            preparedStatement.setString(5, patient.getDiagnosis());
            preparedStatement.setTime(6, patient.getWaittingTime());
            preparedStatement.setDate(7, (Date) patient.getPlannedDischarge());
            preparedStatement.setDate(8, (Date) patient.getAddmissionDate());
            preparedStatement.setDate(9, (Date) patient.getDischargeDate());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePatient(int id) {
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "DELETE FROM PATIENT WHERE ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
