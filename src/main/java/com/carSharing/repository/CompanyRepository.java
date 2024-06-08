package com.carSharing.repository;

import com.carSharing.entity.Company;
import com.carSharing.entity.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
