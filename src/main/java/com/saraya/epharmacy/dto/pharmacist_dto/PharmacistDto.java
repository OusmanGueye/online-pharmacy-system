package com.saraya.epharmacy.dto.pharmacist_dto;

import com.saraya.epharmacy.dto.AbstractDto;

public class PharmacistDto extends AbstractDto {

    private String username;

    private String password;

    private String roles;

    private String fullname;

    private String address;

    private String email;

    private int telephon;

    public PharmacistDto() {
    }

    public PharmacistDto(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public PharmacistDto(String username, String password, String roles, String fullname, String address, String email, int telephon) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.telephon = telephon;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephon() {
        return telephon;
    }

    public void setTelephon(int telephon) {
        this.telephon = telephon;
    }
}
