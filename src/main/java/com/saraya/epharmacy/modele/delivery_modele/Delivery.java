package com.saraya.epharmacy.modele.delivery_modele;

import com.saraya.epharmacy.modele.BaseModel;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import com.saraya.epharmacy.modele.pharmacist_modele.Pharmacist;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery extends BaseModel {

    @ManyToMany
    private List<Medecine> medecines;

    @ManyToOne
    private Pharmacist pharmacist;

    @ManyToOne
    private Patient patient;

    private String pharmacyName;

    private Boolean isAspected;

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Boolean getAspected() {
        return isAspected;
    }

    public void setAspected(Boolean aspected) {
        isAspected = aspected;
    }

    public List<Medecine> getMedecines() {
        return medecines;
    }

    public void setMedecines(List<Medecine> medecines) {
        this.medecines = medecines;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
