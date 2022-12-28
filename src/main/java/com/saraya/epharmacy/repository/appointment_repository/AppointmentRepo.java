package com.saraya.epharmacy.repository.appointment_repository;

import com.saraya.epharmacy.modele.appointment_modele.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    Appointment findAppointmentByEmail(String email);
}
