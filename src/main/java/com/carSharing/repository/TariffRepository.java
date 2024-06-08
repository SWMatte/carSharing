package com.carSharing.repository;

import com.carSharing.entity.Tariff;
import com.carSharing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff,Integer> {
}
