package com.saraya.epharmacy.mapper.pharmacist_mapper;

import com.saraya.epharmacy.dto.pharmacist_dto.PharmacistDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.pharmacist_modele.Pharmacist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacistMapper implements EntityMapper<PharmacistDto, Pharmacist> {
    @Override
    public Pharmacist toEntity(PharmacistDto dto) {
        Pharmacist entity = new Pharmacist();
        entity.setId(dto.getId());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setFullname(dto.getFullname());
        entity.setTelephon(dto.getTelephon());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRoles(dto.getRoles());
        return entity;
    }

    @Override
    public PharmacistDto toDto(Pharmacist entity) {
        PharmacistDto dto = new PharmacistDto();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        dto.setFullname(entity.getFullname());
        dto.setRoles(entity.getRoles());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setTelephon(entity.getTelephon());
        return dto;
    }

    @Override
    public List<Pharmacist> toEntityList(List<PharmacistDto> dtos) {
        List<Pharmacist> pharmacists = new ArrayList<>();

        for (PharmacistDto dto: dtos) {
            pharmacists.add(toEntity(dto));
        }

        return pharmacists;
    }

    @Override
    public List<PharmacistDto> toDto(List<Pharmacist> entitys) {
        List<PharmacistDto> pharmacistDtos = new ArrayList<>();

        for (Pharmacist entity: entitys) {
            pharmacistDtos.add(toDto(entity));
        }

        return pharmacistDtos;
    }
}
