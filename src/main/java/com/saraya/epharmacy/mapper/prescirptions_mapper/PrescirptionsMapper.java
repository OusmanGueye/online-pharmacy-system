package com.saraya.epharmacy.mapper.prescirptions_mapper;

import com.saraya.epharmacy.dto.prescirptions_dto.PrescirptionsDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.prescirptions_modele.Prescirptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescirptionsMapper implements EntityMapper<PrescirptionsDto, Prescirptions> {
    @Override
    public Prescirptions toEntity(PrescirptionsDto dto) {
        Prescirptions entity = new Prescirptions();
        entity.setMedecines(dto.getMedecines());
        entity.setId(dto.getId());
        entity.setPatient(dto.getPatient());
        entity.setPosologie(dto.getPosologie());
        entity.setMedecine(dto.getMedecine());
        entity.setDoctor(dto.getDoctor());
        return entity;
    }

    @Override
    public PrescirptionsDto toDto(Prescirptions entity) {
        PrescirptionsDto dto = new PrescirptionsDto();
        dto.setMedecines(entity.getMedecines());
        dto.setPatient(entity.getPatient());
        dto.setPosologie(entity.getPosologie());
        dto.setId(entity.getId());
        dto.setMedecine(entity.getMedecine());
        dto.setDoctor(entity.getDoctor());
        return dto;
    }

    @Override
    public List<Prescirptions> toEntityList(List<PrescirptionsDto> dtos) {
        List<Prescirptions> prescirptions = new ArrayList<>();
        for (PrescirptionsDto dto : dtos) {
            prescirptions.add(toEntity(dto));
        }
        return prescirptions;
    }

    @Override
    public List<PrescirptionsDto> toDto(List<Prescirptions> entitys) {
        List<PrescirptionsDto> prescirptions = new ArrayList<>();
        for (Prescirptions entity : entitys) {
            prescirptions.add(toDto(entity));
        }
        return prescirptions;
    }
}
