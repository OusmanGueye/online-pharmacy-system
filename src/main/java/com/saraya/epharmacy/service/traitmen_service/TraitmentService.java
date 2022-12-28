package com.saraya.epharmacy.service.traitmen_service;

import com.saraya.epharmacy.dto.traitment_dto.TraitmentDto;
import com.saraya.epharmacy.mapper.traitment_mapper.TraitmentMapper;
import com.saraya.epharmacy.modele.traitment_modele.Traitment;
import com.saraya.epharmacy.repository.traitment_repo.TraitmentRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraitmentService implements ServiceManagements<Traitment, TraitmentDto> {

    private final TraitmentRepo repo;
    private final TraitmentMapper mapper;

    public TraitmentService(TraitmentRepo repo, TraitmentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public TraitmentDto save(TraitmentDto traitmentDto) {
        return mapper.toDto(repo.save(mapper.toEntity(traitmentDto)));
    }

    @Override
    public void deleteById(int id) {
         repo.deleteById(id);
    }

    @Override
    public TraitmentDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<TraitmentDto> findAll() {
       return mapper.toDto(repo.findAll());
    }

    @Override
    public TraitmentDto update(TraitmentDto traitmentDto) {
        return mapper.toDto(repo.save(mapper.toEntity(traitmentDto)));
    }

    public Traitment getTraitmentByName(String name){
        return repo.findTraitmentByName(name);
    }


}
