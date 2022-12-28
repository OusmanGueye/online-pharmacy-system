package com.saraya.epharmacy.dto.patient_dto;

import com.saraya.epharmacy.dto.AbstractDto;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;

import java.util.List;

public class PatientDto extends AbstractDto {

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

    public PatientDto() {
    }

    public PatientDto(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public PatientDto(String name, String address, int telephone, String username, String password, String roles) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    private List<Medecine> medecines;

    public List<Medecine> getMedecines() {
        return medecines;
    }

    public void setMedecines(List<Medecine> medecines) {
        this.medecines = medecines;
    }

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


}
