package com.saraya.epharmacy.controller.doctor_controller;

import com.saraya.epharmacy.dto.appointment_dto.AppointmentDto;
import com.saraya.epharmacy.dto.assigned_dto.AssignedDto;
import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.dto.prescirptions_dto.PrescirptionsDto;
import com.saraya.epharmacy.dto.traitment_dto.TraitmentDto;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import com.saraya.epharmacy.modele.prescirptions_modele.Prescirptions;
import com.saraya.epharmacy.service.assigned_service.AssignedService;
import com.saraya.epharmacy.service.doctor_service.DoctorService;
import com.saraya.epharmacy.service.prescirptions_service.PrescirptionsService;
import com.saraya.epharmacy.service.traitmen_service.TraitmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/Doctors")
public class DoctorController {

    private final DoctorService service;
    private final TraitmentService traitmentService;
    private final PrescirptionsService prescirptionsService;

    public DoctorController(DoctorService service, AssignedService assignedService, TraitmentService traitmentService, PrescirptionsService prescirptionsService) {
        this.service = service;
        this.traitmentService = traitmentService;
        this.prescirptionsService = prescirptionsService;
    }


    @PostMapping("/create-assigned/{namePatient}/{nameTraitment}")
    public ResponseEntity<AssignedDto> sendTraitment(@PathVariable("namePatient") String namePatient,
                                                     @PathVariable("nameTraitment") String nameTraitment){
        return ResponseEntity.ok(service.createAssigned(namePatient, nameTraitment));
    }

    @PostMapping("/create-traitment")
    public ResponseEntity<TraitmentDto> createTraitment(@RequestBody TraitmentDto dto){
        return ResponseEntity.ok(traitmentService.save(dto));
    }

    @GetMapping("/appointment-schedule/{idDoctor}")
    public ResponseEntity<List<AppointmentDto>> getAllSchedule(@PathVariable("idDoctor") int idDoctor){
        return ResponseEntity.ok(service.getAppointmentsDoctor(idDoctor));
    }

    @GetMapping("/appointments/{idAppointment}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable("idAppointment") int idAppointment){
        return ResponseEntity.ok(service.getAppointment(idAppointment));
    }

    @GetMapping("/accepte-schedule/{idAppointment}")
    public void accepteSchedule(@PathVariable("idAppointment") int idAppointment){
        service.isAccepteAppointmentSchedule(idAppointment);
    }

    @PostMapping ("/create-prescriptions")
    public ResponseEntity<PrescirptionsDto> createPrescription(@RequestBody PrescirptionsDto prescirptionsDto){
        return ResponseEntity.ok(prescirptionsService.save(prescirptionsDto)) ;
    }

    @GetMapping("/{idDoctor}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable("idDoctor") int idDoctor){
        return ResponseEntity.ok(service.findById(idDoctor));
    }

    @PutMapping
    public ResponseEntity<DoctorDto> update(@RequestBody DoctorDto dto){
        return ResponseEntity.ok(service.update(dto));
    }

}
