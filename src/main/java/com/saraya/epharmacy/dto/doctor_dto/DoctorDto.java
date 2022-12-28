package com.saraya.epharmacy.dto.doctor_dto;

import com.saraya.epharmacy.dto.AbstractDto;

public class DoctorDto extends AbstractDto {

    private String username;

    private String password;

    private String roles;
    private String fullname;
    private String addresse;
    private int telephon;

    public String getPassword() {
        return password;
    }

    public DoctorDto() {
    }

    public DoctorDto(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public DoctorDto(String username, String password, String fullname, String addresse, int telephon, String roles) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.addresse = addresse;
        this.telephon = telephon;
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getTelephon() {
        return telephon;
    }

    public void setTelephon(int telephon) {
        this.telephon = telephon;
    }
}
