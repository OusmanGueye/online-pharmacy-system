package com.saraya.epharmacy.service.patient_service;

import com.saraya.epharmacy.dto.appointment_dto.AppointmentDto;
import com.saraya.epharmacy.dto.assigned_dto.AssignedDto;
import com.saraya.epharmacy.dto.clinic_dto.ClinicDto;
import com.saraya.epharmacy.dto.delivery_dto.DeliveryDto;
import com.saraya.epharmacy.dto.medecine_dto.MedecineDto;
import com.saraya.epharmacy.dto.order_dto.OrderDto;
import com.saraya.epharmacy.dto.patient_dto.PatientDto;
import com.saraya.epharmacy.dto.prescirptions_dto.PrescirptionsDto;
import com.saraya.epharmacy.dto.schedule_dto.ScheduleDto;
import com.saraya.epharmacy.dto.traitment_dto.TraitmentDto;
import com.saraya.epharmacy.mapper.doctor_mapper.DoctorMapper;
import com.saraya.epharmacy.mapper.patient_mapper.PatientMapper;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import com.saraya.epharmacy.modele.order_modele.Order;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import com.saraya.epharmacy.repository.appointment_repository.AppointmentRepo;
import com.saraya.epharmacy.repository.patient_repository.PatientRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import com.saraya.epharmacy.service.appointment_service.AppointmentService;
import com.saraya.epharmacy.service.assigned_service.AssignedService;
import com.saraya.epharmacy.service.clinic_service.ClinicService;
import com.saraya.epharmacy.service.delivery_service.DeliveryService;
import com.saraya.epharmacy.service.doctor_service.DoctorService;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.order_service.OrderService;
import com.saraya.epharmacy.service.prescirptions_service.PrescirptionsService;
import com.saraya.epharmacy.service.schedule_service.ScheduleService;
import com.saraya.epharmacy.service.traitmen_service.TraitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements ServiceManagements<Patient, PatientDto> {
    @Autowired
    private PatientRepo repo;
    @Autowired
    private MedecineService medecineService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private  OrderService orderService;
    @Autowired
    private AssignedService assignedService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private PrescirptionsService prescirptionsService;
    @Autowired
    private DoctorMapper mapperDoctor;
    @Autowired
    private TraitmentService traitmentService;
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private  PatientMapper mapper;

//    public PatientService(PatientRepo repo, MedecineService medecineService, DeliveryService deliveryService, TraitmentService traitmentService, PatientMapper mapper) {
//        this.repo = repo;
//        this.medecineService = medecineService;
//        this.deliveryService = deliveryService;
//        this.traitmentService = traitmentService;
//        this.mapper = mapper;
//    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        return mapper.toDto(repo.save(mapper.toEntity(patientDto)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public PatientDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }


    @Override
    public List<PatientDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public PatientDto update(PatientDto patientDto) {
        return mapper.toDto(repo.save(mapper.toEntity(patientDto)));
    }

    public Patient getPatientByName(String name){
        return repo.findPatientByName(name);
    }

    public List<MedecineDto> getAllMedecines() {
        return medecineService.findAll();
    }

    public Patient bookMedecine(String medecineName, int idPatient) {
       Patient patient = repo.findById(idPatient).get();
       patient.getMedecines().add(medecineService.findMedecineByName(medecineName));
       return repo.save(patient);
    }


    public DeliveryDto contactPharmacy(DeliveryDto deliveryDto, int idPatients){
        deliveryDto.setPatient(repo.findById(idPatients).get());
        deliveryDto.setPharmacyName(deliveryDto.getPharmacy().getFullname());
        deliveryService.update(deliveryDto);
       return deliveryService.save(deliveryDto);
    }


    public void addMecineOrder(int idMedecine, int idPatient) {
        Patient patient = repo.findById(idPatient).get();
        patient.getMedecines().add(medecineService.findByMedecine(idMedecine));
        repo.save(patient);
    }

    public Order afficheOrder(int idPatient){
        return orderService.afficheOrderPatient(idPatient);
    }

    public OrderDto createOrder(int idPatient){
        OrderDto orderDto = new OrderDto();
        orderDto.setPatient(repo.findById(idPatient).get());
        return orderService.save(orderDto);
    }

    public List<AssignedDto> afficheAssignedPatient(int idPatient){
        List<AssignedDto> assignedDtoList = assignedService.findAll();
        List<AssignedDto> assignedDtoListForPatient = new ArrayList<>();
        for (AssignedDto dto : assignedDtoList) {
            if (dto.getPatient().getId() == idPatient)
                assignedDtoListForPatient.add(dto);
        }
        return assignedDtoListForPatient;
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        appointmentDto.setPatient(repo.findPatientByUsername(appointmentDto.getPatientName()));
//        appointmentDto.setDoctor(mapperDoctor.toEntity(doctorService.findById(appointmentDto.getIdDoctor())));
        return  appointmentService.save(appointmentDto);
    }

    public ScheduleDto createSchedule(ScheduleDto dto) {
        dto.setDoctor(doctorService.getByFullname(dto.getDoctorName()));
        dto.setAppointment(appointmentService.getAppointmentByEmail(dto.getEmailPatientAppointment()));
        return scheduleService.save(dto);
    }

    public ClinicDto seacheClinic(String nameClinic) {
        return clinicService.getClinicByName(nameClinic);
    }

    public List<PrescirptionsDto> affichePrescriptionsPatient(int idPatient) {
        List<PrescirptionsDto> dtos = new ArrayList<>();
        for (PrescirptionsDto dto : prescirptionsService.findAll()) {
            if (dto.getPatient().getId() == idPatient)
                dtos.add(dto);
        }
        return dtos;
    }

    public PatientDto getPatientByUsername(String username){
        return mapper.toDto(repo.findPatientByUsername(username));
    }

    public void deleteMedecine(int idPatient, int idMedecine) {
        Patient patient = repo.findById(idPatient).get();
        for (Medecine medecine: patient.getMedecines()) {
            if (medecine.getId() == idMedecine){
                patient.getMedecines().remove(medecine);
                break;
            }
        }
        repo.save(patient);
    }

    public List<Appointment> getAppointmentPatient(int idPatient) {

        List<Appointment> appointments = new ArrayList<>();
        for (Appointment appointment: appointmentRepo.findAll()) {
            if (appointment.getPatient().getId() == idPatient){
                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public List<PrescirptionsDto> getPrescriptionPatient(int idPatient) {
        List<PrescirptionsDto> prescirptionsDtos = new ArrayList<>();
        for (PrescirptionsDto prescirptionsDto: prescirptionsService.findAll()) {
            if (prescirptionsDto.getPatient().getId() == idPatient){
                prescirptionsDtos.add(prescirptionsDto);
            }
        }
        return prescirptionsDtos;
    }


    public List<TraitmentDto> getTraitmentPatient(int idPatient) {
        List<TraitmentDto> traitmentDtos = new ArrayList<>();
        for (TraitmentDto traitmentDto: traitmentService.findAll()) {
            if (traitmentDto.getPatient().getId() == idPatient){
                traitmentDtos.add(traitmentDto);
            }
        }
        return traitmentDtos;
    }

    public void deleteAppointment(int id) {
        appointmentService.deleteById(id);
    }
}
