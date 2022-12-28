package com.saraya.epharmacy.mapper.delivery_mapper;

import com.saraya.epharmacy.dto.delivery_dto.DeliveryDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.delivery_modele.Delivery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryMapper implements EntityMapper<DeliveryDto, Delivery> {
    @Override
    public Delivery toEntity(DeliveryDto dto) {
        Delivery entity = new Delivery();
        entity.setAspected(dto.getAspected());
        entity.setMedecines(dto.getMedecines());
        entity.setPatient(dto.getPatient());
        entity.setPharmacist(dto.getPharmacy());
        entity.setId(dto.getId());
        entity.setPharmacyName(dto.getPharmacyName());
        return entity;
    }

    @Override
    public DeliveryDto toDto(Delivery entity) {
        DeliveryDto dto = new DeliveryDto();
        dto.setAspected(entity.getAspected());
        dto.setMedecines(entity.getMedecines());
        dto.setId(entity.getId());
        dto.setPatient(entity.getPatient());
        dto.setPharmacy(entity.getPharmacist());
        dto.setPharmacyName(entity.getPharmacyName());
        return dto;
    }

    @Override
    public List<Delivery> toEntityList(List<DeliveryDto> dtos) {
        List<Delivery> deliveries = new ArrayList<>();
        for (DeliveryDto dto: dtos) {
            deliveries.add(toEntity(dto));
        }
        return deliveries;
    }

    @Override
    public List<DeliveryDto> toDto(List<Delivery> entitys) {
        List<DeliveryDto> dtos = new ArrayList<>();
        for (Delivery entity: entitys) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
