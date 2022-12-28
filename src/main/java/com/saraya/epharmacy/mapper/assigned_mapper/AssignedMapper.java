package com.saraya.epharmacy.mapper.assigned_mapper;

import com.saraya.epharmacy.dto.assigned_dto.AssignedDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.assigned_modele.Assigned;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignedMapper implements EntityMapper<AssignedDto, Assigned> {

    @Override
    public Assigned toEntity(AssignedDto dto) {
        Assigned entity = new Assigned();
        entity.setPatient(dto.getPatient());
        entity.setTraitment(dto.getTraitment());
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    public AssignedDto toDto(Assigned entity) {
        AssignedDto dto = new AssignedDto();
        dto.setPatient(entity.getPatient());
        dto.setTraitment(entity.getTraitment());
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public List<Assigned> toEntityList(List<AssignedDto> dtos) {
        List<Assigned> assigneds = new ArrayList<>();
        for (AssignedDto dto : dtos) {
            assigneds.add(toEntity(dto));
        }
        return assigneds;
    }

    @Override
    public List<AssignedDto> toDto(List<Assigned> entitys) {
        List<AssignedDto> dtos = new ArrayList<>();
        for (Assigned entity : entitys) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
