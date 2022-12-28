package com.saraya.epharmacy.dto.medecine_dto;

import com.saraya.epharmacy.dto.AbstractDto;

public class MedecineDto extends AbstractDto {


    private String name;

    private String categorie;

    private double prix;

    private String description;

    public MedecineDto() {
    }

    public MedecineDto(String name, String categorie, double prix, String description) {
        this.name = name;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
