package com.carSharing.service.imp;


import com.carSharing.entity.Car;
import com.carSharing.entity.Company;
import com.carSharing.entity.InsuranceCompany;
import com.carSharing.entity.TypeInsurance;
import com.carSharing.generic.MethodClass;
import com.carSharing.generic.Utils;
import com.carSharing.repository.CarRepository;
import com.carSharing.repository.CompanyRepository;
import com.carSharing.repository.InsuranceCompanyRepository;
import com.carSharing.service.CrudOperation;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
@AllArgsConstructor
@Slf4j
public class CarService extends MethodClass implements CrudOperation<Car> {

    @Autowired
    private final CarRepository carRepository;
    @Autowired
    private final InsuranceCompanyRepository insuranceCompanyRepository;
    @Autowired
    private final CompanyRepository companyRepository;
    //TODO: aggiungere un collegamento se non esiste gia fra company e assicurazioni cosi che io aggiungendo un veicolo passo una company e solo se questa ha un assicurazione attiva e non scaduta posso associarla al veicolo
    /*
    Recupero la company se non esiste eccezione;
    recupero la compagnia assicurativa, da quella metodo per identificare in base alla tipologia di assicurazione (annuale/semestrale ecc) per andare a modificare l'assicurazione con data di fine e poi il premio     */
    @Override
    public ResponseEntity<?> addElement(Car element) {
        log.info("Start " + getCurrentClassName() + " get into: " + getCurrentMethodName());
        if (!Utils.isNull(element)) {
            Company company = companyRepository.findById(element.getCompany().getIdCompany()).orElseThrow(()->new EntityNotFoundException("Company not found with this ID: " +element.getCompany().getIdCompany() ));
            InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(element.getInsuranceCompany().getIdInsuranceCompany()).orElseThrow(()->new EntityNotFoundException("Insurance not found with this ID: " +element.getInsuranceCompany().getIdInsuranceCompany()));
            TypeInsurance typeInsurance = insuranceCompany.getTypeInsurance();
            insuranceCompany.setInsuranceStart(calculateInsuranceStartDate());
            insuranceCompany.setInsuranceEnd(calculateDateInsuranceExpiration(typeInsurance));
            log.info("End method:  " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("The value passed into the method is null/not correct");
        }
    }

    @Override
    public ResponseEntity<?> deleteElement(int idElement) {
        log.info("Start " + getCurrentClassName() + " get into: " + getCurrentMethodName());
        Car car = carRepository.findByLicensePlate(String.valueOf(idElement)).orElseThrow(() -> new EntityNotFoundException("Car not found with ID:" + idElement));
        if (!Utils.isEmpty(String.valueOf(idElement))) {
            car.setDeleteFlag(true);
            carRepository.save(car);
            log.info("End method:  " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return null;
    }


    private Date calculateDateInsuranceExpiration(TypeInsurance typeInsurance){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        switch (typeInsurance) {
            case ANNUALE -> {
                calendar.add(Calendar.DAY_OF_YEAR, 365);
            }
            case BIENNALE -> {
                calendar.add(Calendar.DAY_OF_YEAR, 730);
            }
            case SEMESTRALE -> {
                calendar.add(Calendar.MONTH, 6);
            }
        }

        return calendar.getTime();
    }



        private Date calculateInsuranceStartDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
}
