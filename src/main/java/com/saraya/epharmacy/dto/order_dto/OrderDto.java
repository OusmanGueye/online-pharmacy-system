package com.saraya.epharmacy.dto.order_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.patient_modele.Patient;

import javax.persistence.OneToOne;
import java.util.List;

public class OrderDto extends AbstractDto {

    private double totalPay;

    @OneToOne
    private Patient patient;

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
