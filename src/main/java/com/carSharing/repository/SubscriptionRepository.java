package com.carSharing.repository;

import com.carSharing.entity.Subscription;
import com.carSharing.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {
}
