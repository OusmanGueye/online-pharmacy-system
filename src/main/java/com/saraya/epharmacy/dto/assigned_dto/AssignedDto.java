package com.saraya.epharmacy.dto.assigned_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import com.saraya.epharmacy.modele.traitment_modele.Traitment;

public class AssignedDto extends AbstractDto {

    private String namePatient;

    private String nameTraitment;

    private Patient patient;

    private Traitment traitment;

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getNameTraitment() {
        return nameTraitment;
    }

    public void setNameTraitment(String nameTraitment) {
        this.nameTraitment = nameTraitment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Traitment getTraitment() {
        return traitment;
    }

    public void setTraitment(Traitment traitment) {
        this.traitment = traitment;
    }
}
