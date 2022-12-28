package com.saraya.epharmacy.service.clinic_service;

import com.saraya.epharmacy.dto.clinic_dto.ClinicDto;
import com.saraya.epharmacy.mapper.clinic_mapper.ClinicMapper;
import com.saraya.epharmacy.modele.clinic_modele.Clinic;
import com.saraya.epharmacy.repository.clinic_repository.ClinicRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService implements ServiceManagements<Clinic, ClinicDto> {

    private final ClinicRepo repo;
    private final ClinicMapper mapper;

    public ClinicService(ClinicRepo repo, ClinicMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ClinicDto save(ClinicDto clinicDto) {
        return mapper.toDto(repo.save(mapper.toEntity(clinicDto)));
    }

    @Override
    public void deleteById(int id) {
       repo.deleteById(id);
    }

    @Override
    public ClinicDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<ClinicDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public ClinicDto update(ClinicDto clinicDto) {
        return mapper.toDto(repo.save(mapper.toEntity(clinicDto)));
    }

    public ClinicDto getClinicByName(String name){
        return mapper.toDto(repo.findClinicByName(name));
    }
}
