package com.carSharing.service.imp;


import com.carSharing.entity.Booking;
import com.carSharing.repository.BookingRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService implements CrudOperation<Booking> {

    @Autowired
    private final BookingRepository BookingRepository;
    @Override
    public ResponseEntity<?> addElement(Booking element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(int idElement) {
        return null;
    }


}
