package com.saraya.epharmacy.mapper.medecine_mapper;

import com.saraya.epharmacy.dto.medecine_dto.MedecineDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedecineMapper implements EntityMapper<MedecineDto, Medecine> {
    @Override
    public Medecine toEntity(MedecineDto dto) {
        Medecine entity = new Medecine();
        entity.setCategorie(dto.getCategorie());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrix(dto.getPrix());
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public MedecineDto toDto(Medecine entity) {
        MedecineDto dto = new MedecineDto();
        dto.setCategorie(entity.getCategorie());
        dto.setDescription(entity.getDescription());
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        dto.setPrix(entity.getPrix());
        return dto;
    }

    @Override
    public List<Medecine> toEntityList(List<MedecineDto> dtos) {
        List<Medecine> medecines = new ArrayList<>();

        for (MedecineDto dto: dtos) {
            medecines.add(toEntity(dto));
        }
        return medecines;
    }

    @Override
    public List<MedecineDto> toDto(List<Medecine> entitys) {
        List<MedecineDto> dtos = new ArrayList<>();

        for (Medecine medecine: entitys) {
            dtos.add(toDto(medecine));
        }
        return dtos;
    }
}
