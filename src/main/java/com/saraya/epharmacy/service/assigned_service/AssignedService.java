package com.saraya.epharmacy.service.assigned_service;

import com.saraya.epharmacy.dto.assigned_dto.AssignedDto;
import com.saraya.epharmacy.mapper.assigned_mapper.AssignedMapper;
import com.saraya.epharmacy.modele.assigned_modele.Assigned;
import com.saraya.epharmacy.repository.assigned_repository.AssignedRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignedService implements ServiceManagements<Assigned, AssignedDto> {

    private final AssignedRepo repo;
    private final AssignedMapper mapper;

    public AssignedService(AssignedRepo repo, AssignedMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public AssignedDto save(AssignedDto assignedDto) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public AssignedDto findById(int id) {
        return null;
    }

    @Override
    public List<AssignedDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public AssignedDto update(AssignedDto assignedDto) {
        return null;
    }
}
