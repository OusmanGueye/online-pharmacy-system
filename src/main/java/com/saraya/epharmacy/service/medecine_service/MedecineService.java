package com.saraya.epharmacy.service.medecine_service;

import com.saraya.epharmacy.dto.medecine_dto.MedecineDto;
import com.saraya.epharmacy.mapper.medecine_mapper.MedecineMapper;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.repository.medecine_repo.MedecineRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecineService implements ServiceManagements<Medecine, MedecineDto> {

    private final MedecineMapper mapper;
    private final MedecineRepo repo;

    public MedecineService(MedecineMapper mapper, MedecineRepo repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public MedecineDto save(MedecineDto medecineDto) {
        return mapper.toDto(repo.save(mapper.toEntity(medecineDto)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public MedecineDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    public Medecine findByMedecine(int id) {
        return repo.findById(id).get();
    }

    @Override
    public List<MedecineDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public MedecineDto update(MedecineDto medecineDto) {
        return mapper.toDto(repo.save(mapper.toEntity(medecineDto)));
    }

    public Medecine findMedecineByName(String name){
        return repo.findMedecineByName(name);
    }
}
