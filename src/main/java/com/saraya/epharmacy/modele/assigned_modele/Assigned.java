package com.saraya.epharmacy.modele.assigned_modele;

import com.saraya.epharmacy.modele.BaseModel;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import com.saraya.epharmacy.modele.traitment_modele.Traitment;

import javax.persistence.*;

@Entity
@Table(name = "assigneds")
public class Assigned extends BaseModel {

    @OneToOne
    private Traitment traitment;

    @ManyToOne
    private Patient patient;

    public Traitment getTraitment() {
        return traitment;
    }

    public void setTraitment(Traitment traitment) {
        this.traitment = traitment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
