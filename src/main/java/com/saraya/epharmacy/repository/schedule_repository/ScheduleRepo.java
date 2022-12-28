package com.saraya.epharmacy.repository.schedule_repository;

import com.saraya.epharmacy.modele.Schedule_modele.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
}
