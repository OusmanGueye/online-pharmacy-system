package com.saraya.epharmacy.service.pharmacist_service;

import com.saraya.epharmacy.dto.pharmacist_dto.PharmacistDto;
import com.saraya.epharmacy.mapper.pharmacist_mapper.PharmacistMapper;
import com.saraya.epharmacy.modele.delivery_modele.Delivery;
import com.saraya.epharmacy.modele.pharmacist_modele.Pharmacist;
import com.saraya.epharmacy.repository.pharmacist_repo.PharmacistRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import com.saraya.epharmacy.service.delivery_service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService implements ServiceManagements<Pharmacist, PharmacistDto> {

    @Autowired
    private  PharmacistRepo repo;

    @Autowired
    private  PharmacistMapper mapper;

    @Autowired
    private    DeliveryService deliveryService;

//    public PharmacistService(PharmacistRepo repo, PharmacistMapper mapper, DeliveryService deliveryService) {
//        this.repo = repo;
//        this.mapper = mapper;
////        this.repo = repo;
////        this.mapper = mapper;
////        this.deliveryService = deliveryService;
//        this.deliveryService = deliveryService;
//    }


    @Override
    public PharmacistDto save(PharmacistDto pharmacistDto) {
        return mapper.toDto(repo.save(mapper.toEntity(pharmacistDto)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public PharmacistDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<PharmacistDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public PharmacistDto update(PharmacistDto pharmacistDto) {
        return mapper.toDto(repo.save(mapper.toEntity(pharmacistDto)));
    }

    public Pharmacist getByFullname(String fullname){
        return repo.findByFullname(fullname);
    }

    public List<Delivery> getdelivery(int id){
        return deliveryService.deliveryDtoListForPharmacy(id);
    }
}
