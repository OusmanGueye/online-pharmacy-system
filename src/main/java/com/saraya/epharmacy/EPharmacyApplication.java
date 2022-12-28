package com.saraya.epharmacy;

import com.saraya.epharmacy.dto.admin_dto.AdminDto;
import com.saraya.epharmacy.dto.clinic_dto.ClinicDto;
import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.dto.medecine_dto.MedecineDto;
import com.saraya.epharmacy.dto.patient_dto.PatientDto;
import com.saraya.epharmacy.dto.pharmacist_dto.PharmacistDto;
import com.saraya.epharmacy.service.admin_service.AdminService;
import com.saraya.epharmacy.service.clinic_service.ClinicService;
import com.saraya.epharmacy.service.doctor_service.DoctorService;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.patient_service.PatientService;
import com.saraya.epharmacy.service.pharmacist_service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EPharmacyApplication implements CommandLineRunner{

//    public EPharmacyApplication(AdminService service, PatientService patientService, PharmacistService pharmacistService) {
//        this.service = service;
//        this.patientService = patientService;
//        this.pharmacistService = pharmacistService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(EPharmacyApplication.class, args);
    }

    @Autowired
    private AdminService service;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private  PharmacistService pharmacistService;
    @Autowired
    private MedecineService medecineService;
    @Autowired
    private ClinicService clinicService;

    @Override
    public void run(String... args) throws Exception {
         service.save(new AdminDto("ousmane", "gta", "admin", "ousmaneg@gmail.com", "Rufisque", 771323873));
         service.save(new AdminDto("more", "gta", "admin"));
         patientService.save(new PatientDto("Thierno Gueye", "Rufisque",76005143,"thierno", "gta5", "patient"));
         doctorService.save(new DoctorDto("fatou", "gta6", "Fatou Gueye", "Pikine rue", 771251410, "doctor"));
         pharmacistService.save(new PharmacistDto("ngone", "gta4", "pharmacy", "Ngone Gueye", "Pikine rue 10", "Ngone@gmail.com",772392943));
         medecineService.save(new MedecineDto("paracetamole", "pilule", 100, "baissela temperature"));
         clinicService.save(new ClinicDto("Principale", "Dakar", "Mellieur clinic ", 33125874));
        clinicService.save(new ClinicDto("Dentec", "Almadie", "best clinic ", 33120074));
    }
}
