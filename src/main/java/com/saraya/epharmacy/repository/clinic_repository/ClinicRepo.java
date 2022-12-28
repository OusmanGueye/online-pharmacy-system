package com.saraya.epharmacy.repository.clinic_repository;

import com.saraya.epharmacy.modele.clinic_modele.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepo extends JpaRepository<Clinic, Integer> {
    Clinic findClinicByName(String name);
}
