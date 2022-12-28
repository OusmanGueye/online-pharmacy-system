package com.saraya.epharmacy.dto.traitment_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.patient_modele.Patient;

import java.util.List;

public class TraitmentDto extends AbstractDto {
    private String advice;
    private String name;
    private String description;
    private List<Medecine> medecines;

    private Patient patient;
    public String getAdvice() {
        return advice;
    }

    private Doctor doctor;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    private String doctorName;

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Medecine> getMedecines() {
        return medecines;
    }

    public void setMedecines(List<Medecine> medecines) {
        this.medecines = medecines;
    }
}
