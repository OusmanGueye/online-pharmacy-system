package com.saraya.epharmacy.repository.patient_repository;

import com.saraya.epharmacy.modele.patient_modele.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
    Patient findPatientByName(String name);
    Patient findPatientByUsername(String username);
}
