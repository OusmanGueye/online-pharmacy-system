package com.saraya.epharmacy.mapper.doctor_mapper;

import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorMapper implements EntityMapper<DoctorDto, Doctor> {
    @Override
    public Doctor toEntity(DoctorDto dto) {
        Doctor entity = new Doctor();
        entity.setAddresse(dto.getAddresse());
        entity.setFullname(dto.getFullname());
        entity.setTelephon(dto.getTelephon());
        entity.setUsername(dto.getUsername());
        entity.setId(dto.getId());
        entity.setPassword(dto.getPassword());
        entity.setRoles(dto.getRoles());
        return entity;
    }

    @Override
    public DoctorDto toDto(Doctor entity) {
        DoctorDto dto = new DoctorDto();
        dto.setAddresse(entity.getAddresse());
        dto.setFullname(entity.getFullname());
        dto.setUsername(entity.getUsername());
        dto.setTelephon(entity.getTelephon());
        dto.setId(entity.getId());
        dto.setRoles(entity.getRoles());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    @Override
    public List<Doctor> toEntityList(List<DoctorDto> dtos) {
        List<Doctor> doctors = new ArrayList<>();
        for (DoctorDto dto : dtos) {
            doctors.add(toEntity(dto));
        }
        return doctors;
    }

    @Override
    public List<DoctorDto> toDto(List<Doctor> entitys) {
        List<DoctorDto> dtos = new ArrayList<>();
        for (Doctor doctor : entitys) {
            dtos.add(toDto(doctor));
        }
        return dtos;
    }
}
