package com.saraya.epharmacy.service.delivery_service;

import com.saraya.epharmacy.dto.delivery_dto.DeliveryDto;
import com.saraya.epharmacy.mapper.delivery_mapper.DeliveryMapper;
import com.saraya.epharmacy.modele.delivery_modele.Delivery;
import com.saraya.epharmacy.repository.delivery_repo.DeliveryRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.pharmacist_service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService implements ServiceManagements<Delivery, DeliveryDto> {

    @Autowired
    private  DeliveryRepo repo;
    @Autowired
    private  MedecineService medecineService;
    @Autowired
    private PharmacistService pharmacistService;
    @Autowired
    private  DeliveryMapper mapper;

//    public DeliveryService(PharmacistService pharmacistService) {
////        this.repo = repo;
////        this.medecineService = medecineService;
////        this.pharmacistService = pharmacistService;
////        this.mapper = mapper;
//        this.pharmacistService = pharmacistService;
//    }

    @Override
    public DeliveryDto save(DeliveryDto deliveryDto) {
        deliveryDto.setPharmacy(pharmacistService.getByFullname(deliveryDto.getPharmacyName()));
//        for (String name: deliveryDto.getMedecineName()) {
//            deliveryDto.getMedecines().add(medecineService.findMedecineByName(name));
//        }
        return mapper.toDto(repo.save(mapper.toEntity(deliveryDto)));
    }

    @Override
    public void deleteById(int id) {
       repo.deleteById(id);
    }

    @Override
    public DeliveryDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<DeliveryDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public DeliveryDto update(DeliveryDto deliveryDto) {
        return mapper.toDto(repo.save(mapper.toEntity(deliveryDto)));
    }

    public void foundMedecines(List<String> medecineName, int deliveryId){
        Delivery delivery = repo.findById(deliveryId).get();
    }

    public List<Delivery> deliveryDtoListForPharmacy(int idPharmacy){
        List<Delivery> deliveriesForPharmacy = new ArrayList<>();
        List<Delivery> deliveries = repo.findAll();
        for (Delivery delivery: deliveries) {
            if (delivery.getPharmacist().getId() == idPharmacy){
                deliveriesForPharmacy.add(delivery);

            }
        }
        return deliveriesForPharmacy;
    }

    public List<DeliveryDto> deliveryDtoListForPatient(int idPatient){
        List<Delivery> deliveriesForPatient = new ArrayList<>();
        List<Delivery> deliveries = repo.findAll();
        for (Delivery delivery: deliveries) {
            if (delivery.getPatient().getId() == idPatient){
                deliveriesForPatient.add(delivery);
            }
        }
        return mapper.toDto(deliveriesForPatient);
    }
}
