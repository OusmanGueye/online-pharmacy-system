package com.saraya.epharmacy.repository.doctor_repository;

import com.saraya.epharmacy.modele.doctor_modele.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    Doctor findDoctorByFullname(String name);
}
