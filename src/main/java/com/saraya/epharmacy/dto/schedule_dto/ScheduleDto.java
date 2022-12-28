package com.saraya.epharmacy.dto.schedule_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;

import javax.persistence.ManyToOne;

public class ScheduleDto extends AbstractDto {

    private Doctor doctor;

    private Appointment appointment;

    private String doctorName;

    private String emailPatientAppointment;

    private boolean isAccepted;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getEmailPatientAppointment() {
        return emailPatientAppointment;
    }

    public void setEmailPatientAppointment(String emailPatientAppointment) {
        this.emailPatientAppointment = emailPatientAppointment;
    }
}
