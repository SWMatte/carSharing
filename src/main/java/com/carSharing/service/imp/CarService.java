package com.carSharing.service.imp;


import com.carSharing.entity.Car;
import com.carSharing.repository.CarRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService implements CrudOperation<Car> {

    @Autowired
    private final CarRepository billingPaymentsRepository;
    @Override
    public ResponseEntity<?> addElement(Car element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(Car idElement) {
        return null;
    }

    @Override
    public ResponseEntity<Car> getAllElement() {
        return null;
    }
}
