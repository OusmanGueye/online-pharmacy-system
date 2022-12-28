package com.saraya.epharmacy.mapper.clinic_mapper;

import com.saraya.epharmacy.dto.clinic_dto.ClinicDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.clinic_modele.Clinic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClinicMapper implements EntityMapper<ClinicDto, Clinic> {
    @Override
    public Clinic toEntity(ClinicDto dto) {
        Clinic entity = new Clinic();
        entity.setAddress(dto.getAddress());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setId(dto.getId());
        entity.setTelephon(dto.getTelephon());
        return entity;
    }

    @Override
    public ClinicDto toDto(Clinic entity) {
        ClinicDto dto = new ClinicDto();
        dto.setAddress(entity.getAddress());
        dto.setDescription(entity.getDescription());
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        dto.setTelephon(entity.getTelephon());
        return dto;
    }

    @Override
    public List<Clinic> toEntityList(List<ClinicDto> dtos) {
        List<Clinic> clinics = new ArrayList<>();
        for (ClinicDto dto : dtos) {
            clinics.add(toEntity(dto));
        }
        return clinics;
    }

    @Override
    public List<ClinicDto> toDto(List<Clinic> entitys) {
        List<ClinicDto> dtos = new ArrayList<>();
        for (Clinic entity : entitys) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
