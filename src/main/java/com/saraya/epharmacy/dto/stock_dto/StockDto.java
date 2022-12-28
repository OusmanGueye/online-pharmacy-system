package com.saraya.epharmacy.dto.stock_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;

import java.util.List;

public class StockDto extends AbstractDto {

    private Medecine medecines;

    private int quantity;

    private String medecineName;

    public Medecine getMedecines() {
        return medecines;
    }

    public void setMedecines(Medecine medecines) {
        this.medecines = medecines;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedecineName() {
        return medecineName;
    }

    public void setMedecineName(String medecineName) {
        this.medecineName = medecineName;
    }
}
