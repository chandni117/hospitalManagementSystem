package com.hospitalMngmntSystem.hospitalMngmntSystem.controller;

import com.hospitalMngmntSystem.hospitalMngmntSystem.dto.PatientDto;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import com.hospitalMngmntSystem.hospitalMngmntSystem.service.CacheInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospitalMngmntSystem.hospitalMngmntSystem.service.PatientService;


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
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long patientId) {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }
    @GetMapping("/cacheData")
    public void getCacheData(){
        cacheInspectionService.printCacheContents("patient");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatientById(@PathVariable("id") Long patientId, @RequestBody PatientDto patientDto){
        return ResponseEntity.ok(patientService.updatePatientById(patientId, patientDto));
    }





}
