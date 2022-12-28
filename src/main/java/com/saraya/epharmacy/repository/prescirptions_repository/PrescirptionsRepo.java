package com.saraya.epharmacy.repository.prescirptions_repository;

import com.saraya.epharmacy.modele.prescirptions_modele.Prescirptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescirptionsRepo extends JpaRepository<Prescirptions, Integer> {

}
