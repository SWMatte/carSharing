package com.carSharing.service.imp;


import com.carSharing.entity.Subscription;
import com.carSharing.repository.SubscriptionRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService implements CrudOperation<Subscription> {

    @Autowired
    private final SubscriptionRepository billingPaymentsRepository;
    @Override
    public ResponseEntity<?> addElement(Subscription element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(Subscription idElement) {
        return null;
    }

    @Override
    public ResponseEntity<Subscription> getAllElement() {
        return null;
    }
}
