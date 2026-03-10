package com.hospitalMngmntSystem.hospitalMngmntSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long>{

}
