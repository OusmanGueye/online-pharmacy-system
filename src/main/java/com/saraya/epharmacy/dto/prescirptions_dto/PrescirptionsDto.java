package com.saraya.epharmacy.dto.prescirptions_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.patient_modele.Patient;

import javax.persistence.ManyToOne;
import java.util.List;

public class PrescirptionsDto extends AbstractDto {

    private List<Medecine> medecines;

    private List<String> NameMedecines;

    private  String medecine;

    private String patienName;

    private Patient patient;

    private String posologie;

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

    public List<String> getNameMedecines() {
        return NameMedecines;
    }

    public void setNameMedecines(List<String> nameMedecines) {
        NameMedecines = nameMedecines;
    }

    public String getPatienName() {
        return patienName;
    }

    public void setPatienName(String patienName) {
        this.patienName = patienName;
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
