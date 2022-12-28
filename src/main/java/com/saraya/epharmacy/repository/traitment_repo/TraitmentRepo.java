package com.saraya.epharmacy.repository.traitment_repo;

import com.saraya.epharmacy.modele.traitment_modele.Traitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitmentRepo extends JpaRepository<Traitment, Integer> {
    Traitment findTraitmentByName(String name);
}
