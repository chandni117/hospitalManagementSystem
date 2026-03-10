package com.hospitalMngmntSystem.hospitalMngmntSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findById(Doctor doctorId);

}
