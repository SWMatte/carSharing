package com.carSharing.service.imp;


import com.carSharing.entity.Maintenance;
import com.carSharing.repository.MaintenanceRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceService implements CrudOperation<Maintenance> {

    @Autowired
    private final MaintenanceRepository billingPaymentsRepository;
    @Override
    public ResponseEntity<?> addElement(Maintenance element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(Maintenance idElement) {
        return null;
    }

    @Override
    public ResponseEntity<Maintenance> getAllElement() {
        return null;
    }
}
