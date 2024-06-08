package com.carSharing.service.imp;


import com.carSharing.entity.Company;
import com.carSharing.repository.CompanyRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService implements CrudOperation<Company> {

    @Autowired
    private final CompanyRepository billingPaymentsRepository;
    @Override
    public ResponseEntity<?> addElement(Company element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(Company idElement) {
        return null;
    }

    @Override
    public ResponseEntity<Company> getAllElement() {
        return null;
    }
}
