package com.hospitalMngmntSystem.hospitalMngmntSystem.service;

import com.hospitalMngmntSystem.hospitalMngmntSystem.dto.PatientDto;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import com.hospitalMngmntSystem.hospitalMngmntSystem.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    private final ModelMapper modelMapper;
    @Cacheable(value = "patient", key = "#patientId")
    @CachePut(value = "patient", key = "#patientId")
    public PatientDto getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                            .orElseThrow(() -> new EntityNotFoundException("Patient not found with id"));

        System.out.println(patient);
        return modelMapper.map(patient, PatientDto.class);
    }
    @Transactional
    public PatientDto updatePatientById(Long patientId, PatientDto patientDto){
        Patient p = patientRepository.findById(patientId).orElseThrow();
        p.setGender(patientDto.getGender());
        p.setEmail(patientDto.getEmail());
        p.setName(patientDto.getName());
        p.setBirthDate(patientDto.getBirthDate());
        return modelMapper.map(p, PatientDto.class);
    }
}
