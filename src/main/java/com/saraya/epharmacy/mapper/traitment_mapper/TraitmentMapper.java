package com.saraya.epharmacy.mapper.traitment_mapper;

import com.saraya.epharmacy.dto.traitment_dto.TraitmentDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.traitment_modele.Traitment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TraitmentMapper implements EntityMapper<TraitmentDto, Traitment> {

    @Override
    public Traitment toEntity(TraitmentDto dto) {
        Traitment entity = new Traitment();
        entity.setAdvice(dto.getAdvice());
        entity.setMedecines(dto.getMedecines());
        entity.setDescription(dto.getDescription());
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDoctor(dto.getDoctor());
        entity.setPatient(dto.getPatient());
        return entity;
    }

    @Override
    public TraitmentDto toDto(Traitment entity) {
        TraitmentDto dto = new TraitmentDto();
        dto.setAdvice(entity.getAdvice());
        dto.setDescription(entity.getDescription());
        dto.setMedecines(entity.getMedecines());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDoctor(entity.getDoctor());
        dto.setPatient(entity.getPatient());
        return dto;
    }

    @Override
    public List<Traitment> toEntityList(List<TraitmentDto> dtos) {
        List<Traitment> traitments = new ArrayList<>();
        for (TraitmentDto dto : dtos) {
            traitments.add(toEntity(dto));
        }
        return traitments;
    }

    @Override
    public List<TraitmentDto> toDto(List<Traitment> entitys) {
        List<TraitmentDto> dtos = new ArrayList<>();
        for (Traitment entity : entitys) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

}
