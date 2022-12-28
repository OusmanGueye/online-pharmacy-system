package com.saraya.epharmacy.service.schedule_service;

import com.saraya.epharmacy.dto.schedule_dto.ScheduleDto;
import com.saraya.epharmacy.mapper.schedule_mapper.ScheduleMapper;
import com.saraya.epharmacy.modele.Schedule_modele.Schedule;
import com.saraya.epharmacy.repository.schedule_repository.ScheduleRepo;
import com.saraya.epharmacy.service.ServiceManagements;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService implements ServiceManagements<Schedule, ScheduleDto> {

    private final ScheduleRepo repo;
    private final ScheduleMapper mapper;

    public ScheduleService(ScheduleRepo repo, ScheduleMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ScheduleDto save(ScheduleDto scheduleDto) {
        return mapper.toDto(repo.save(mapper.toEntity(scheduleDto)));
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public ScheduleDto findById(int id) {
        return null;
    }

    @Override
    public List<ScheduleDto> findAll() {
        return null;
    }

    @Override
    public ScheduleDto update(ScheduleDto scheduleDto) {
        return null;
    }
}
