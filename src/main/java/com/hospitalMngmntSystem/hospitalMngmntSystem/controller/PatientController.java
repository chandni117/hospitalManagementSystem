package com.hospitalMngmntSystem.hospitalMngmntSystem.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hospitalMngmntSystem.hospitalMngmntSystem.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public void getPatientById(@PathVariable("id") Long patientId) {
        patientService.getPatientById(patientId);
    }



}
