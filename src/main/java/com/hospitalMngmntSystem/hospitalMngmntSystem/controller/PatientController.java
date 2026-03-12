package com.hospitalMngmntSystem.hospitalMngmntSystem.controller;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import com.hospitalMngmntSystem.hospitalMngmntSystem.service.CacheInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalMngmntSystem.hospitalMngmntSystem.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;
    @Autowired
    CacheInspectionService cacheInspectionService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long patientId) {

        Patient p =  patientService.getPatientById(patientId);
        return p;
    }
    @GetMapping("/cacheData")
    public void getCacheData(){
        cacheInspectionService.printCacheContents("patient");
    }





}
