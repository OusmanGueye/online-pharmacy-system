package com.saraya.epharmacy.dto.admin_dto;

public class AdminDto {

    private int id;
    private String username;

    private String password;

    private String roles;

    private String email;

    private String address;

    private int telephon;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getTelephon() {
        return telephon;
    }

    public void setTelephon(int telephon) {
        this.telephon = telephon;
    }

    public AdminDto() {
    }

    public AdminDto(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public AdminDto(String username, String password, String roles, String email, String address, int telephon) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
        this.address = address;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
