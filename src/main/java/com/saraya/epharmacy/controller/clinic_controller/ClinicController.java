package com.saraya.epharmacy.controller.clinic_controller;

import com.saraya.epharmacy.service.clinic_service.ClinicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    private final ClinicService service;

    public ClinicController(ClinicService service) {
        this.service = service;
    }
}
