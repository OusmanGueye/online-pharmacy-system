package com.saraya.epharmacy.modele.stock_modele;

import com.saraya.epharmacy.modele.BaseModel;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stocks")
public class Stock extends BaseModel {

    @ManyToOne
    private Medecine medecines;

    private int quantity;

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
}
