package com.saraya.epharmacy.service.prescirptions_service;

import com.saraya.epharmacy.dto.prescirptions_dto.PrescirptionsDto;
import com.saraya.epharmacy.mapper.prescirptions_mapper.PrescirptionsMapper;
import com.saraya.epharmacy.modele.prescirptions_modele.Prescirptions;
import com.saraya.epharmacy.repository.prescirptions_repository.PrescirptionsRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescirptionsService implements ServiceManagements<Prescirptions, PrescirptionsDto> {

    private final PrescirptionsMapper mapper;
    private final PrescirptionsRepo repo;

    public PrescirptionsService(PrescirptionsMapper mapper, PrescirptionsRepo repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public PrescirptionsDto save(PrescirptionsDto prescirptionsDto) {
        return mapper.toDto(repo.save(mapper.toEntity(prescirptionsDto)));
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public PrescirptionsDto findById(int id) {
        return null;
    }

    @Override
    public List<PrescirptionsDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public PrescirptionsDto update(PrescirptionsDto prescirptionsDto) {
        return null;
    }
}
