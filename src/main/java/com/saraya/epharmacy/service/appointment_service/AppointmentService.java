package com.saraya.epharmacy.service.appointment_service;

import com.saraya.epharmacy.dto.appointment_dto.AppointmentDto;
import com.saraya.epharmacy.mapper.appointment_mapper.AppointmentMapper;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import com.saraya.epharmacy.repository.appointment_repository.AppointmentRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements ServiceManagements<Appointment, AppointmentDto> {

    private final AppointmentRepo repo;
    private final AppointmentMapper mapper;

    public AppointmentService(AppointmentRepo repo, AppointmentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {
        return mapper.toDto(repo.save(mapper.toEntity(appointmentDto)));
    }

    @Override
    public void deleteById(int id) {
       repo.deleteById(id);
    }

    @Override
    public AppointmentDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<AppointmentDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        return mapper.toDto(repo.save(mapper.toEntity(appointmentDto)));
    }

    public Appointment getAppointmentByEmail(String email){
        return repo.findAppointmentByEmail(email);
    }
}
