package com.saraya.epharmacy.repository.medecine_repo;

import com.saraya.epharmacy.modele.medecine_modele.Medecine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecineRepo extends JpaRepository<Medecine, Integer> {
    Medecine findMedecineByName(String name);
}
