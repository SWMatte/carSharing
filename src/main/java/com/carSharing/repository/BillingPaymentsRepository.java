package com.carSharing.repository;

import com.carSharing.entity.BillingPayments;
import com.carSharing.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingPaymentsRepository extends JpaRepository<BillingPayments,Integer> {
}
