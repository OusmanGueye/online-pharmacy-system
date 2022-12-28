package com.saraya.epharmacy.service.admin_service;

import com.saraya.epharmacy.dto.admin_dto.AdminDto;
import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.dto.stock_dto.StockDto;
import com.saraya.epharmacy.mapper.admin_mapper.AdminMapper;
import com.saraya.epharmacy.modele.admin_modele.Admin;
import com.saraya.epharmacy.repository.admin_repo.AdminRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import com.saraya.epharmacy.service.doctor_service.DoctorService;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.stock_service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements ServiceManagements<Admin, AdminDto>{
    @Autowired
    private  AdminRepo repo;
    @Autowired
    private  AdminMapper mapper;
    @Autowired
    private  StockService stockService;
    @Autowired
    private  MedecineService medecineService;


//    public AdminService(AdminRepo repo, AdminMapper mapper, StockService stockService, MedecineService medecineService, DoctorService doctorService) {
//        this.repo = repo;
//        this.mapper = mapper;
//        this.stockService = stockService;
//        this.medecineService = medecineService;
//    }

    @Override
    public AdminDto save(AdminDto adminDto) {
        return mapper.toDto(repo.save(mapper.toEntity(adminDto)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public AdminDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<AdminDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public AdminDto update(AdminDto adminDto) {
        return mapper.toDto(repo.save(mapper.toEntity(adminDto)));
    }

    public void addMedecineInStock(StockDto stockDto){
        stockDto.setMedecines(medecineService.findMedecineByName(stockDto.getMedecineName()));
        stockService.save(stockDto);
    }


}
