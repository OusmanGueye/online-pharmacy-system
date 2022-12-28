package com.saraya.epharmacy.controller.patient_controller;

import com.saraya.epharmacy.dto.appointment_dto.AppointmentDto;
import com.saraya.epharmacy.dto.assigned_dto.AssignedDto;
import com.saraya.epharmacy.dto.clinic_dto.ClinicDto;
import com.saraya.epharmacy.dto.delivery_dto.DeliveryDto;
import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.dto.medecine_dto.MedecineDto;
import com.saraya.epharmacy.dto.order_dto.OrderDto;
import com.saraya.epharmacy.dto.patient_dto.PatientDto;
import com.saraya.epharmacy.dto.pharmacist_dto.PharmacistDto;
import com.saraya.epharmacy.dto.prescirptions_dto.PrescirptionsDto;
import com.saraya.epharmacy.dto.schedule_dto.ScheduleDto;
import com.saraya.epharmacy.dto.traitment_dto.TraitmentDto;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import com.saraya.epharmacy.modele.order_modele.Order;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import com.saraya.epharmacy.repository.appointment_repository.AppointmentRepo;
import com.saraya.epharmacy.service.appointment_service.AppointmentService;
import com.saraya.epharmacy.service.clinic_service.ClinicService;
import com.saraya.epharmacy.service.delivery_service.DeliveryService;
import com.saraya.epharmacy.service.doctor_service.DoctorService;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.order_service.OrderService;
import com.saraya.epharmacy.service.patient_service.PatientService;
import com.saraya.epharmacy.service.pharmacist_service.PharmacistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/Patients")
public class PatientController {

    private final PatientService service;
    private final PharmacistService pharmacistService;
    private final DeliveryService deliveryService;
    private final OrderService orderService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private final MedecineService medecineService;

    private final AppointmentRepo appointmentRepo;
    private final ClinicService clinicService;

    public PatientController(PatientService service, PharmacistService pharmacistService, DeliveryService deliveryService, OrderService orderService, DoctorService doctorService, AppointmentService appointmentService, MedecineService medecineService, AppointmentRepo appointmentRepo, ClinicService clinicService) {
        this.service = service;
        this.pharmacistService = pharmacistService;
        this.deliveryService = deliveryService;
        this.orderService = orderService;
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
        this.medecineService = medecineService;
        this.appointmentRepo = appointmentRepo;
        this.clinicService = clinicService;
    }

    @PostMapping
    public ResponseEntity<PatientDto> create(@RequestBody PatientDto dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/medecines")
    public ResponseEntity<List<MedecineDto>> getAllMedecine(){
        return ResponseEntity.ok(service.getAllMedecines());
    }


    @GetMapping("/pharmacist")
    public ResponseEntity<List<PharmacistDto>> getAllPharmacist(){
        return ResponseEntity.ok(pharmacistService.findAll());
    }


    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}/book-medecine/{medecineName}")
    public ResponseEntity<Patient> bookMedecine(@PathVariable("medecineName") String medecineName,
                                                @PathVariable("id") int id){
        return ResponseEntity.ok(service.bookMedecine(medecineName, id));
    }

    @PostMapping("/delivery_medecine_pharmacy/{id}")
    public DeliveryDto contactPharmacy(@RequestBody DeliveryDto deliveryDto,
                                @PathVariable("id") int id){
       DeliveryDto dto = deliveryService.save(deliveryDto);
       return service.contactPharmacy(dto, id);
    }

    @PostMapping("/add_medecine_order/{idMedecine}/{idPatient}")
    public void addMedecineOrder(@PathVariable("idMedecine") int idMedecine,
                                 @PathVariable("idPatient") int idPatient){
        service.addMecineOrder(idMedecine, idPatient);
    }

    @GetMapping("/order/{idPatient}")
    public ResponseEntity<Order> orderPatient(@PathVariable("idPatient") int idPatient){
        return ResponseEntity.ok(service.afficheOrder(idPatient));
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> orderPatient(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/order/create/{idPatient}")
    public ResponseEntity<OrderDto> createOrder(@PathVariable("idPatient") int idPatient){
        return ResponseEntity.ok(service.createOrder(idPatient));
    }

    @GetMapping("/traitment-assigned/{idPatient}")
    public ResponseEntity<List<AssignedDto>> afficheTraitmentPatient(@PathVariable("idPatient") int idPatient){
        return ResponseEntity.ok(service.afficheAssignedPatient(idPatient));
    }

    @PostMapping("/appointment-create")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
         return ResponseEntity.ok(service.createAppointment(appointmentDto));
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDto>> getAllAppointment(){
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @GetMapping("/prescriptionsPatient/{idPatient}")
    public ResponseEntity<List<PrescirptionsDto>> getPrescriptionPatient(@PathVariable("idPatient") int idPatient){
        return ResponseEntity.ok(service.getPrescriptionPatient(idPatient));
    }

    @GetMapping("/traitmentPatient/{idPatient}")
    public ResponseEntity<List<TraitmentDto>> getTraitmentPatient(@PathVariable("idPatient") int idPatient){
        return ResponseEntity.ok(service.getTraitmentPatient(idPatient));
    }

    @PostMapping("/schedule-create")
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto dto){
        return ResponseEntity.ok(service.createSchedule(dto));
    }

//    @PostMapping("/clinic/{nameClinic}")
//    public ResponseEntity<ClinicDto> createClinic(@PathVariable("nameClinic") String nameClinic){
//        return ResponseEntity.ok(service.seacheClinic(nameClinic));
//    }

    @GetMapping("/clinic")
    public ResponseEntity<List<ClinicDto>> getAllClinic(){
        return ResponseEntity.ok(clinicService.findAll());
    }

    @GetMapping("/prescriptions/{idPatient}")
    public ResponseEntity<List<PrescirptionsDto>> affichePrescriptionsPatient(@PathVariable("idPatient") int idPatient){
        return ResponseEntity.ok(service.affichePrescriptionsPatient(idPatient));
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<PatientDto> getPatientByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(service.getPatientByUsername(username));
    }

    @GetMapping("/delivery/{idPatient}")
    public ResponseEntity<List<DeliveryDto>> getDelivery(@PathVariable("idPatient") int idPatient){
        return ResponseEntity.ok(deliveryService.deliveryDtoListForPatient(idPatient));
    }

    @DeleteMapping("/medecine_delete/{idPatient}/{idMedecine}")
    public void deleteMedecine(@PathVariable("idPatient") int idPatient, @PathVariable("idMedecine") int idMedecine){
        service.deleteMedecine(idPatient, idMedecine);
    }

    @DeleteMapping("/appointment_delete/{id}")
    public void deleteAppointment(@PathVariable("id") int id){
        service.deleteAppointment(id);
    }

    @GetMapping("/appointment/patient/{idPatient}")
    public List<Appointment> getAppointmentPatient(@PathVariable("idPatient") int idPatient){
        return service.getAppointmentPatient(idPatient);
    }

    @PutMapping
    public ResponseEntity<PatientDto> update(@RequestBody PatientDto dto){
        return ResponseEntity.ok(service.update(dto));
    }
}
