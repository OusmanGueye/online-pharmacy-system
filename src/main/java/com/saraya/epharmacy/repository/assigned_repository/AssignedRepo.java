package com.saraya.epharmacy.repository.assigned_repository;

import com.saraya.epharmacy.modele.assigned_modele.Assigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedRepo extends JpaRepository<Assigned, Integer> {
}
