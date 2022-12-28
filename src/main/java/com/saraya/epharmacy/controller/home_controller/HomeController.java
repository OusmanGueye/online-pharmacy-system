package com.saraya.epharmacy.controller.home_controller;

import com.saraya.epharmacy.dto.admin_dto.AdminDto;
import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.dto.patient_dto.PatientDto;
import com.saraya.epharmacy.dto.pharmacist_dto.PharmacistDto;
import com.saraya.epharmacy.service.admin_service.AdminService;
import com.saraya.epharmacy.service.doctor_service.DoctorService;
import com.saraya.epharmacy.service.patient_service.PatientService;
import com.saraya.epharmacy.service.pharmacist_service.PharmacistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/home")
public class HomeController {

    private final PatientService patientService;
    private final AdminService adminService;
    private final DoctorService doctorService;
    private final PharmacistService pharmacistService;

    public HomeController(PatientService patientService, AdminService adminService, DoctorService doctorService, PharmacistService pharmacistService) {
        this.patientService = patientService;
        this.adminService = adminService;
        this.doctorService = doctorService;
        this.pharmacistService = pharmacistService;
    }

    @PostMapping("/patient-create")
    public ResponseEntity<PatientDto> createDoctor(@RequestBody PatientDto dto){
        return ResponseEntity.ok(patientService.save(dto));
    }

    @PostMapping("/admin-create")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto dto){
        return ResponseEntity.ok(adminService.save(dto));
    }

    @GetMapping("/admin-list")
    public ResponseEntity<List<AdminDto>> getAllAdmin(){
        return ResponseEntity.ok(adminService.findAll());
    }

    @GetMapping("/patient-list")
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/doctor-list")
    public ResponseEntity<List<DoctorDto>> getAllDoctor(){
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/pharmacy-list")
    public ResponseEntity<List<PharmacistDto>> getAllPharmacy(){
        return ResponseEntity.ok(pharmacistService.findAll());
    }
}
