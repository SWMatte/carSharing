package com.carSharing.repository;

import com.carSharing.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Integer> {


    Optional<Company> findByVATNumber(String VATNumber);
}
