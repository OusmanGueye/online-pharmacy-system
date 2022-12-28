package com.saraya.epharmacy.mapper.schedule_mapper;

import com.saraya.epharmacy.dto.schedule_dto.ScheduleDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.Schedule_modele.Schedule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleMapper implements EntityMapper<ScheduleDto, Schedule> {
    @Override
    public Schedule toEntity(ScheduleDto dto) {
        Schedule schedule = new Schedule();
        schedule.setAccepted(dto.isAccepted());
        schedule.setAppointment(dto.getAppointment());
        schedule.setDoctor(dto.getDoctor());
        schedule.setId(dto.getId());
        return schedule;
    }

    @Override
    public ScheduleDto toDto(Schedule entity) {
        ScheduleDto dto = new ScheduleDto();
        dto.setAccepted(entity.isAccepted());
        dto.setAppointment(entity.getAppointment());
        dto.setDoctor(entity.getDoctor());
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public List<Schedule> toEntityList(List<ScheduleDto> dtos) {
        List<Schedule> schedules = new ArrayList<>();
        for (ScheduleDto scheduleDto : dtos) {
            schedules.add(toEntity(scheduleDto));
        }
        return schedules;
    }

    @Override
    public List<ScheduleDto> toDto(List<Schedule> entitys) {
        List<ScheduleDto> dtos = new ArrayList<>();
        for (Schedule schedule : entitys) {
            dtos.add(toDto(schedule));
        }
        return dtos;
    }
}
