package com.saraya.epharmacy.modele.patient_modele;

import com.saraya.epharmacy.modele.BaseModel;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient extends BaseModel {

    private String name;

    private String address;

    private int telephone;

    private String username;

    private String password;

    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @OneToMany
    private List<Medecine> medecines;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public List<Medecine> getMedecines() {
        return medecines;
    }

    public void setMedecines(List<Medecine> medecines) {
        this.medecines = medecines;
    }
}
