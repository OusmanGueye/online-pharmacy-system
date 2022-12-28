package com.saraya.epharmacy.service.stock_service;

import com.saraya.epharmacy.dto.medecine_dto.MedecineDto;
import com.saraya.epharmacy.dto.stock_dto.StockDto;
import com.saraya.epharmacy.mapper.stock_mapper.StockMapper;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.stock_modele.Stock;
import com.saraya.epharmacy.repository.stock_repo.StockRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService implements ServiceManagements<Stock, StockDto> {


    private final StockRepo repo;
    private final StockMapper mapper;

    public StockService(StockRepo repo, StockMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public StockDto save(StockDto stockDto) {
        return mapper.toDto(repo.save(mapper.toEntity(stockDto)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public StockDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<StockDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public StockDto update(StockDto stockDto) {
        return mapper.toDto(repo.save(mapper.toEntity(stockDto)));
    }

}
