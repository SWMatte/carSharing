package com.carSharing.service.imp;


import com.carSharing.entity.InsuranceCompany;
import com.carSharing.generic.MethodClass;
import com.carSharing.repository.InsuranceCompanyRepository;
import com.carSharing.service.CrudOperation;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.carSharing.generic.Utils;

@Service
@AllArgsConstructor
@Slf4j
public class InsuranceCompanyService extends MethodClass implements CrudOperation<InsuranceCompany> {

    @Autowired
    private final InsuranceCompanyRepository insuranceCompanyRepository;

    @Override
    public ResponseEntity<?> addElement(InsuranceCompany element) {
        log.info("Start " + getCurrentClassName() + " get into: " + getCurrentMethodName());
        if(!Utils.isNull(element)){
            insuranceCompanyRepository.save(element);
            log.info("End method:  "  + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            throw new IllegalArgumentException("The value passed into the method is null/not correct");
        }
    }

    @Override
    public ResponseEntity<?> deleteElement(int idElement) {
        log.info("Start " + getCurrentClassName() + " get into: " + getCurrentMethodName());
        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findInsuranceCompanyByNumberInsurance(String.valueOf(idElement));
        if(!Utils.isNull(insuranceCompany)){
            insuranceCompany.setDeleteFlag(true);
            insuranceCompanyRepository.save(insuranceCompany);
            log.info("End method:  "  + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        }else {
            throw  new EntityNotFoundException("Insurance company not found with ID:" + idElement);
        }
    }


}
