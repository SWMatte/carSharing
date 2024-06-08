package com.carSharing.service.imp;


import com.carSharing.entity.InsuranceCompany;
import com.carSharing.repository.InsuranceCompanyRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InsuranceCompanyService implements CrudOperation<InsuranceCompany> {

    @Autowired
    private final InsuranceCompanyRepository billingPaymentsRepository;
    @Override
    public ResponseEntity<?> addElement(InsuranceCompany element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(InsuranceCompany idElement) {
        return null;
    }

    @Override
    public ResponseEntity<InsuranceCompany> getAllElement() {
        return null;
    }
}
