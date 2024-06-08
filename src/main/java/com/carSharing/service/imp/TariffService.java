package com.carSharing.service.imp;


import com.carSharing.entity.Tariff;
import com.carSharing.repository.TariffRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TariffService implements CrudOperation<Tariff> {

    @Autowired
    private final TariffRepository TariffRepository;
    @Override
    public ResponseEntity<?> addElement(Tariff element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(int idElement) {
        return null;
    }


}
