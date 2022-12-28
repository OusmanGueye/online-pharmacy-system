package com.saraya.epharmacy.controller.pharmacy_controller;

import com.saraya.epharmacy.controller.ControllerManagements;
import com.saraya.epharmacy.dto.pharmacist_dto.PharmacistDto;
import com.saraya.epharmacy.modele.delivery_modele.Delivery;
import com.saraya.epharmacy.service.pharmacist_service.PharmacistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/pharmacy")
public class PharmacyController  {

    private final PharmacistService service;

    public PharmacyController(PharmacistService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<PharmacistDto> create(@RequestBody PharmacistDto pharmacistDto) {
        return ResponseEntity.ok(service.save(pharmacistDto));
    }


    @PutMapping
    public ResponseEntity<PharmacistDto> update(@RequestBody PharmacistDto pharmacistDto) {
        return ResponseEntity.ok(service.update(pharmacistDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PharmacistDto> show(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PharmacistDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/list_delivery/{idPharmacy}")
    public ResponseEntity<List<Delivery>> getAlldelivery(@PathVariable("id") int idPharmacy){
        return ResponseEntity.ok(service.getdelivery(idPharmacy));
    }

}
