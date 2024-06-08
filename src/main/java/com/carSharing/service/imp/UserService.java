package com.carSharing.service.imp;


import com.carSharing.entity.User;
import com.carSharing.repository.UserRepository;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements CrudOperation<User> {

    @Autowired
    private final UserRepository billingPaymentsRepository;
    @Override
    public ResponseEntity<?> addElement(User element) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteElement(User idElement) {
        return null;
    }

    @Override
    public ResponseEntity<User> getAllElement() {
        return null;
    }
}
