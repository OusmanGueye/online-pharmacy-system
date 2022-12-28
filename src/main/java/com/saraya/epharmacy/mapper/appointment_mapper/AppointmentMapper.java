package com.saraya.epharmacy.mapper.appointment_mapper;

import com.saraya.epharmacy.dto.appointment_dto.AppointmentDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentMapper implements EntityMapper<AppointmentDto, Appointment> {
    @Override
    public Appointment toEntity(AppointmentDto dto) {
        Appointment entity = new Appointment();
        entity.setId(dto.getId());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dto.getDate(), format);
        entity.setDate(date);
        entity.setPatient(dto.getPatient());
        entity.setAccepted(dto.isAccepted());
        entity.setDoctor(dto.getDoctor());
        return entity;
    }

    @Override
    public AppointmentDto toDto(Appointment entity) {
       AppointmentDto dto = new AppointmentDto();
       String date = entity.getDate().toString();
       dto.setDate(date);
       dto.setPatient(entity.getPatient());
       dto.setId(entity.getId());
       dto.setAccepted(entity.isAccepted());
       dto.setDoctor(entity.getDoctor());
       return dto;
    }

    @Override
    public List<Appointment> toEntityList(List<AppointmentDto> dtos) {
        List<Appointment> appointments = new ArrayList<>();
        for (AppointmentDto dto : dtos) {
            appointments.add(toEntity(dto));
        }
        return appointments;
    }

    @Override
    public List<AppointmentDto> toDto(List<Appointment> entitys) {
        List<AppointmentDto> dtos = new ArrayList<>();
        for (Appointment entity : entitys) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
