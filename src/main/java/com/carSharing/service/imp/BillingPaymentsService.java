package com.carSharing.service.imp;


import com.carSharing.entity.BillingPayments;
import com.carSharing.repository.BillingPaymentsRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BillingPaymentsService implements CrudOperation<BillingPayments> {

    @Autowired
    private final BillingPaymentsRepository billingPaymentsRepository;
    @Override
    public ResponseEntity<?> addElement(BillingPayments element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(BillingPayments idElement) {
        return null;
    }

    @Override
    public ResponseEntity<BillingPayments> getAllElement() {
        return null;
    }
}
