package com.saraya.epharmacy.repository.pharmacist_repo;

import com.saraya.epharmacy.modele.pharmacist_modele.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepo extends JpaRepository<Pharmacist, Integer> {
    Pharmacist findByFullname(String fullname);
}
