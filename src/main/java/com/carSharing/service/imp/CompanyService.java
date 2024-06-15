package com.carSharing.service.imp;


import com.carSharing.entity.Company;
import com.carSharing.entity.InsuranceCompany;
import com.carSharing.generic.MethodClass;
import com.carSharing.generic.Utils;
import com.carSharing.repository.CompanyRepository;
import com.carSharing.service.CrudOperation;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyService extends MethodClass implements CrudOperation<Company> {

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public ResponseEntity<?> addElement(Company element) {
        log.info("Start " + getCurrentClassName() + " get into: " + getCurrentMethodName());
        if (!Utils.isNull(element)) {
            companyRepository.save(element);
            log.info("End method:  " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("The value passed into the method is null/not correct");
        }
    }

    @Override
    public ResponseEntity<?> deleteElement(int idElement) {
        log.info("Start " + getCurrentClassName() + " get into: " + getCurrentMethodName());
        Company company = companyRepository.findByVATNumber(String.valueOf(idElement)).orElseThrow(() -> new EntityNotFoundException("Insurance company not found with ID:" + idElement));
        if (!Utils.isNull(company)) {
            company.setDeleteFlag(true);
            companyRepository.save(company);
            log.info("End method:  " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        }

        return null;
    }
}

