package com.carSharing.repository;

import com.carSharing.entity.Car;
import com.carSharing.entity.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
