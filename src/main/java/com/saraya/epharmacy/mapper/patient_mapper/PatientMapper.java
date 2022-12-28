package com.saraya.epharmacy.mapper.patient_mapper;

import com.saraya.epharmacy.dto.patient_dto.PatientDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientMapper implements EntityMapper<PatientDto, Patient> {

    @Override
    public Patient toEntity(PatientDto dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAddress(dto.getAddress());
        patient.setTelephone(dto.getTelephone());
        patient.setId(dto.getId());
        patient.setPassword(dto.getPassword());
        patient.setUsername(dto.getUsername());
        patient.setRoles(dto.getRoles());
        patient.setMedecines(dto.getMedecines());
        return patient;
    }

    @Override
    public PatientDto toDto(Patient entity) {
        PatientDto dto = new PatientDto();
        dto.setAddress(entity.getAddress());
        dto.setName(entity.getName());
        dto.setTelephone(entity.getTelephone());
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRoles(entity.getRoles());
        dto.setMedecines(entity.getMedecines());
        return dto;
    }

    @Override
    public List<Patient> toEntityList(List<PatientDto> dtos) {
        List<Patient> patients = new ArrayList<>();
        for (PatientDto dto: dtos) {
            patients.add(toEntity(dto));
        }
        return patients;
    }

    @Override
    public List<PatientDto> toDto(List<Patient> entitys) {
        List<PatientDto> dtos = new ArrayList<>();
        for (Patient entity: entitys) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
