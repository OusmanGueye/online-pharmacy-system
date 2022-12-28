package com.saraya.epharmacy.modele.prescirptions_modele;

import com.saraya.epharmacy.modele.BaseModel;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "prescirptions")
public class Prescirptions extends BaseModel {

    @OneToMany
    private List<Medecine> medecines;

    private  String medecine;

    @ManyToOne
    private Patient patient;

    private String posologie;

    @ManyToOne
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMedecine() {
        return medecine;
    }

    public void setMedecine(String medecine) {
        this.medecine = medecine;
    }

    public List<Medecine> getMedecines() {
        return medecines;
    }

    public void setMedecines(List<Medecine> medecines) {
        this.medecines = medecines;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }
}
