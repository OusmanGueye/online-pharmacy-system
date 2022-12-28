package com.saraya.epharmacy.mapper.stock_mapper;

import com.saraya.epharmacy.dto.stock_dto.StockDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.stock_modele.Stock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockMapper implements EntityMapper<StockDto, Stock> {
    @Override
    public Stock toEntity(StockDto dto) {
        Stock entity = new Stock();
        entity.setMedecines(dto.getMedecines());
        entity.setId(dto.getId());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    @Override
    public StockDto toDto(Stock entity) {
        StockDto dto = new StockDto();
        dto.setMedecines(entity.getMedecines());
        dto.setQuantity(entity.getQuantity());
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public List<Stock> toEntityList(List<StockDto> dtos) {
        List<Stock> stocks = new ArrayList<>();

        for (StockDto dto: dtos) {
            stocks.add(toEntity(dto));
        }
        return stocks;
    }

    @Override
    public List<StockDto> toDto(List<Stock> entitys) {
        List<StockDto> dtos = new ArrayList<>();
        for (Stock entity: entitys) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
