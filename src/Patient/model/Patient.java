/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patient.model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author Adminis
 */
public class Patient {
    private int id;
    private String name;
    private String medicalFacilities;
    private String phoneFamily;
    private String healthStatus;
    private String diagnosis;
    private Time waittingTime;
    private Date plannedDischarge;
    private Date addmissionDate;
    private Date dischargeDate;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedicalFacilities() {
        return medicalFacilities;
    }

    public void setMedicalFacilities(String medicalFacilities) {
        this.medicalFacilities = medicalFacilities;
    }

    public String getPhoneFamily() {
        return phoneFamily;
    }

    public void setPhoneFamily(String phoneFamily) {
        this.phoneFamily = phoneFamily;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Time getWaittingTime() {
        return waittingTime;
    }

    public void setWaittingTime(Time waittingTime) {
        this.waittingTime = waittingTime;
    }

    public Date getPlannedDischarge() {
        return plannedDischarge;
    }

    public void setPlannedDischarge(Date plannedDischarge) {
        this.plannedDischarge = plannedDischarge;
    }

    public Date getAddmissionDate() {
        return addmissionDate;
    }

    public void setAddmissionDate(Date addmissionDate) {
        this.addmissionDate = addmissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    } 

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public static SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }
    
    public static Date convertStringToDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String converDateToString(Date date) {
        return dateFormat.format(date);
    }
    
    public static Time convertStringToTime(String timeStr) {
        try {
            Date parseDate = timeFormat.parse(timeStr);
            return new Time(parseDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String converTimeToString(Time time) {
        return timeFormat.format(time);
    }
    
}
