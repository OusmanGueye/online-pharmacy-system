package com.saraya.epharmacy.mapper.admin_mapper;

import com.saraya.epharmacy.dto.admin_dto.AdminDto;
import com.saraya.epharmacy.mapper.EntityMapper;
import com.saraya.epharmacy.modele.admin_modele.Admin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminMapper implements EntityMapper<AdminDto, Admin> {
    @Override
    public Admin toEntity(AdminDto dto) {
        Admin admin = new Admin();
        admin.setPassword(dto.getPassword());
        admin.setUsername(dto.getUsername());
        admin.setRoles(dto.getRoles());
        admin.setId(dto.getId());
        admin.setEmail(dto.getEmail());
        admin.setAddress(dto.getAddress());
        admin.setTelephon(dto.getTelephon());
        return admin;
    }

    @Override
    public AdminDto toDto(Admin entity) {
        AdminDto dto = new AdminDto();
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());
        dto.setRoles(entity.getRoles());
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setAddress(entity.getAddress());
        dto.setTelephon(dto.getTelephon());
        return dto;
    }

    @Override
    public List<Admin> toEntityList(List<AdminDto> dtos) {

        List<Admin> admins = new ArrayList<>();
        for (AdminDto dto : dtos) {
            admins.add(toEntity(dto));
        }
        return admins;
    }

    @Override
    public List<AdminDto> toDto(List<Admin> entitys) {
        List<AdminDto> dtos = new ArrayList<>();
        for (Admin admin : entitys) {
            dtos.add(toDto(admin));
        }
        return dtos;
    }
}
