package com.carSharing.repository;

import com.carSharing.entity.Car;
import com.carSharing.entity.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Integer> {


    Optional<Car> findByLicensePlate(String licensePlate);
}
