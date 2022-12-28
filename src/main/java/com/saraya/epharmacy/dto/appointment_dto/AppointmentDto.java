package com.saraya.epharmacy.dto.appointment_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import com.saraya.epharmacy.modele.patient_modele.Patient;

import java.time.LocalDate;

public class AppointmentDto extends AbstractDto {

    private String date;

    private Patient patient;

    private String patientName;

    private Doctor doctor;

    private boolean isAccepted;

    private int idDoctor;

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
