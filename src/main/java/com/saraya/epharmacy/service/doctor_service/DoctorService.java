package com.saraya.epharmacy.service.doctor_service;

import com.saraya.epharmacy.dto.appointment_dto.AppointmentDto;
import com.saraya.epharmacy.dto.assigned_dto.AssignedDto;
import com.saraya.epharmacy.dto.doctor_dto.DoctorDto;
import com.saraya.epharmacy.dto.prescirptions_dto.PrescirptionsDto;
import com.saraya.epharmacy.dto.schedule_dto.ScheduleDto;
import com.saraya.epharmacy.mapper.doctor_mapper.DoctorMapper;
import com.saraya.epharmacy.modele.Schedule_modele.Schedule;
import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import com.saraya.epharmacy.modele.assigned_modele.Assigned;
import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import com.saraya.epharmacy.modele.patient_modele.Patient;
import com.saraya.epharmacy.modele.prescirptions_modele.Prescirptions;
import com.saraya.epharmacy.modele.traitment_modele.Traitment;
import com.saraya.epharmacy.repository.appointment_repository.AppointmentRepo;
import com.saraya.epharmacy.repository.doctor_repository.DoctorRepo;
import com.saraya.epharmacy.repository.patient_repository.PatientRepo;
import com.saraya.epharmacy.repository.prescirptions_repository.PrescirptionsRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import com.saraya.epharmacy.service.appointment_service.AppointmentService;
import com.saraya.epharmacy.service.assigned_service.AssignedService;
import com.saraya.epharmacy.service.medecine_service.MedecineService;
import com.saraya.epharmacy.service.patient_service.PatientService;
import com.saraya.epharmacy.service.prescirptions_service.PrescirptionsService;
import com.saraya.epharmacy.service.schedule_service.ScheduleService;
import com.saraya.epharmacy.service.traitmen_service.TraitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService implements ServiceManagements<Doctor, DoctorDto> {

    private final DoctorRepo repo;
    private final DoctorMapper mapper;

    @Autowired
    private AssignedService assignedService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private TraitmentService traitmentService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private MedecineService medecineService;
    @Autowired
    private PrescirptionsService prescirptionsService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private PrescirptionsRepo prescirptionsRepo;

    public DoctorService(DoctorRepo repo, DoctorMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public DoctorDto save(DoctorDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public DoctorDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public List<DoctorDto> findAll() {
        return mapper.toDto(repo.findAll());
    }

    @Override
    public DoctorDto update(DoctorDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public Doctor getByFullname(String fullname){
        return repo.findDoctorByFullname(fullname);
    }

    public AssignedDto createAssigned(String namePatient, String nameTraitment) {
        AssignedDto assigned = new AssignedDto();
        Patient patient = patientService.getPatientByName(namePatient);
        Traitment traitment = traitmentService.getTraitmentByName(nameTraitment);
        assigned.setTraitment(traitment);
        assigned.setPatient(patient);
        return assignedService.save(assigned);
    }

    public void isAccepteAppointmentSchedule(int idAppointment) {
         Appointment appointmentDto = appointmentRepo.findById(idAppointment).get();
         appointmentDto.setAccepted(true);
         appointmentRepo.save(appointmentDto);
    }

    public List<ScheduleDto> getAllSchedule(int idDoctor) {
        List<ScheduleDto> scheduleDtos = scheduleService.findAll();
        for (ScheduleDto dto : scheduleDtos) {
            if (dto.getDoctor().getId() == idDoctor);
        }
        return scheduleService.findAll();
    }

    public List<AppointmentDto> getAppointmentsDoctor(int idDoctor) {
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        for (AppointmentDto dto : appointmentService.findAll()) {
            if (dto.getDoctor().getId() == idDoctor){
                appointmentDtoList.add(dto);
            }
        }
       return appointmentDtoList;
    }

    public Prescirptions createPrescription(String medecine, String posologie, int idPatient) {
        Prescirptions prescirptions = new Prescirptions();
        prescirptions.setPatient(patientRepo.findById(idPatient).get());
        prescirptions.setMedecine(medecine);
        prescirptions.setPosologie(posologie);
        return prescirptionsRepo.save(prescirptions);
    }

    public Appointment getAppointment(int idAppointment) {
        return appointmentRepo.findById(idAppointment).get();
    }
}
