package com.saraya.epharmacy.modele.Schedule_modele;

import com.saraya.epharmacy.modele.BaseModel;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import com.saraya.epharmacy.modele.patient_modele.Patient;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "schedules")
public class Schedule extends BaseModel {

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Appointment appointment;

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
}
