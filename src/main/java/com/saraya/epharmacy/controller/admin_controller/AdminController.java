package com.saraya.epharmacy.controller.admin_controller;

import com.saraya.epharmacy.dto.admin_dto.AdminDto;
import com.saraya.epharmacy.dto.clinic_dto.ClinicDto;
import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.dto.medecine_dto.MedecineDto;
import com.saraya.epharmacy.dto.patient_dto.PatientDto;
import com.saraya.epharmacy.dto.pharmacist_dto.PharmacistDto;
import com.saraya.epharmacy.dto.stock_dto.StockDto;
import com.saraya.epharmacy.service.admin_service.AdminService;
import com.saraya.epharmacy.service.clinic_service.ClinicService;
import com.saraya.epharmacy.service.doctor_service.DoctorService;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.patient_service.PatientService;
import com.saraya.epharmacy.service.pharmacist_service.PharmacistService;
import com.saraya.epharmacy.service.stock_service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private  AdminService adminService;


    @Autowired
    private    PharmacistService pharmacistService;
    @Autowired
    private  MedecineService medecineService;
    @Autowired
    private  StockService stockService;
    @Autowired
    private  ClinicService clinicService;
    @Autowired
    private  DoctorService doctorService;
    @Autowired
    private  PatientService patientService;


//    public AdminController(AdminService adminService, PharmacistService pharmacistService, PharmacistService pharmacistService1, MedecineService medecineService, StockService stockService, ClinicService clinicService, DoctorService doctorService, PatientService patientService) {
//        this.adminService = adminService;
//        this.pharmacistService = pharmacistService1;
//        this.medecineService = medecineService;
//        this.stockService = stockService;
//        this.clinicService = clinicService;
//        this.doctorService = doctorService;
//        this.patientService = patientService;
//    }


    @PostMapping
    public ResponseEntity<AdminDto> create(AdminDto dto) {
        return ResponseEntity.ok(adminService.save(dto));
    }

    @PutMapping
    public ResponseEntity<AdminDto> update(@RequestBody AdminDto dto) {
        return ResponseEntity.ok(adminService.update(dto));
    }

    @GetMapping("/pharmacy_list")
    public ResponseEntity<List<PharmacistDto>> getAllPhamacy() {
        return ResponseEntity.ok(pharmacistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdmin(@PathVariable("id") int id){
        return ResponseEntity.ok(adminService.findById(id));
    }

    @GetMapping("/doctor_list")
    public ResponseEntity<List<DoctorDto>> getAllDoctor() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @PostMapping("/add_pharmacy")
    public ResponseEntity<PharmacistDto> createPharmacy(@RequestBody PharmacistDto pharmacistDto) {
        return ResponseEntity.ok(pharmacistService.save(pharmacistDto));
    }

    @PostMapping("/add_medecine")
    public ResponseEntity<MedecineDto> createMedecine(@RequestBody MedecineDto dto){
        return ResponseEntity.ok(medecineService.save(dto));
    }

    @PutMapping("/edite_medecine")
    public ResponseEntity<MedecineDto> editeMedecine(@RequestBody MedecineDto dto){
        return ResponseEntity.ok(medecineService.update(dto));
    }

    @PutMapping("/edite_pharmacy")
    public ResponseEntity<PharmacistDto> editeMedecine(@RequestBody PharmacistDto dto){
        return ResponseEntity.ok(pharmacistService.update(dto));
    }

    @PutMapping("/edite_doctor")
    public ResponseEntity<DoctorDto> editeDoctor(@RequestBody DoctorDto dto){
        return ResponseEntity.ok(doctorService.update(dto));
    }

    @PutMapping("/edite_patient")
    public ResponseEntity<PatientDto> editeDoctor(@RequestBody PatientDto dto){
        return ResponseEntity.ok(patientService.update(dto));
    }

    @PutMapping("/edite_clinic")
    public ResponseEntity<ClinicDto> editeDoctor(@RequestBody ClinicDto dto){
        return ResponseEntity.ok(clinicService.update(dto));
    }

    @GetMapping("/medecines_list")
    public ResponseEntity<List<MedecineDto>> getAllMedecines(){
        return ResponseEntity.ok(medecineService.findAll());
    }

    @GetMapping("/medecine/{id}")
    public ResponseEntity<MedecineDto> getMedecines(@PathVariable("id") int id){
        return ResponseEntity.ok(medecineService.findById(id));
    }

    @DeleteMapping("/medecine/delete/{id}")
    public void deleteMedecines(@PathVariable("id") int id){
         medecineService.deleteById(id);
    }

    @PostMapping("/add_medecine_in_stock")
    public void addMedecine(@RequestBody StockDto dto){
        adminService.addMedecineInStock(dto);
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<StockDto>> getAll(){
        return ResponseEntity.ok(stockService.findAll());
    }

    @PostMapping("/add-dotor")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody  DoctorDto dto){
        return ResponseEntity.ok(doctorService.save(dto));
    }

    @PostMapping("/clinic-create")
    public ResponseEntity<ClinicDto> createClinic(@RequestBody ClinicDto dto){
        return ResponseEntity.ok(clinicService.save(dto));
    }

    @GetMapping("/clinic-list")
    public ResponseEntity<List<ClinicDto>> getAllClinic(){
        return ResponseEntity.ok(clinicService.findAll());
    }

    @DeleteMapping("/clinic/{id}")
    public void deleteClinic(@PathVariable("id") int id){
        clinicService.deleteById(id);
    }


    @DeleteMapping("/pharmacy/{id}")
    public void deletePharmacy(@PathVariable("id") int id){
        pharmacistService.deleteById(id);
    }

    @DeleteMapping("/medecine_delete/{id}")
    public void deleteMedecine(@PathVariable("id") int id){
        medecineService.deleteById(id);
    }

    @DeleteMapping("/doctor_delete/{id}")
    public void deleteDoctor(@PathVariable("id") int id){
        doctorService.deleteById(id);
    }

    @DeleteMapping("/patient_delete/{id}")
    public void deletePatient(@PathVariable("id") int id){
       patientService.deleteById(id);
    }

}
