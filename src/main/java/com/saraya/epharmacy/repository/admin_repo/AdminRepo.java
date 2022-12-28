package com.saraya.epharmacy.repository.admin_repo;

import com.saraya.epharmacy.dto.admin_dto.AdminDto;
import com.saraya.epharmacy.modele.admin_modele.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findAdminByUsername(String username);
}
