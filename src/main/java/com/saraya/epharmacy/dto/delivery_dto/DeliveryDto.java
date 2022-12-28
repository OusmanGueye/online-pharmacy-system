package com.saraya.epharmacy.dto.delivery_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import com.saraya.epharmacy.modele.pharmacist_modele.Pharmacist;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

public class DeliveryDto extends AbstractDto {

    private String pharmacyName;

    private List<String> medecineName;

    private List<Medecine> medecines;

    private Pharmacist pharmacy;

    private Patient patient;

    private Boolean isAspected;

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public List<String> getMedecineName() {
        return medecineName;
    }

    public void setMedecineName(List<String> medecineName) {
        this.medecineName = medecineName;
    }

    public List<Medecine> getMedecines() {
        return medecines;
    }

    public void setMedecines(List<Medecine> medecines) {
        this.medecines = medecines;
    }

    public Pharmacist getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacist pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Boolean getAspected() {
        return isAspected;
    }

    public void setAspected(Boolean aspected) {
        isAspected = aspected;
    }
}
