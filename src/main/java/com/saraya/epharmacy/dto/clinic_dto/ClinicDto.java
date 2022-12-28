package com.saraya.epharmacy.dto.clinic_dto;

import com.saraya.epharmacy.dto.AbstractDto;

public class ClinicDto extends AbstractDto {

    private String name;
    private String address;
    private String description;

    private int telephon;

    public ClinicDto() {
    }

    public ClinicDto(String name, String address, String description, int telephon) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.telephon = telephon;
    }

    public int getTelephon() {
        return telephon;
    }

    public void setTelephon(int telephon) {
        this.telephon = telephon;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
