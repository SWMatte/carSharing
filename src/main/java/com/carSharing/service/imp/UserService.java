package com.carSharing.service.imp;


import com.carSharing.entity.User;
import com.carSharing.generic.MethodClass;
import com.carSharing.generic.Utils;
import com.carSharing.repository.UserRepository;
import com.carSharing.service.CrudOperation;
import com.carSharing.service.iUser;
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
public class UserService extends MethodClass implements CrudOperation<User>, iUser {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> addElement(User element) {
        log.info("Start " + getCurrentClassName() + " get into: " + getCurrentMethodName());
        if (!Utils.isNull(element)) {
            userRepository.save(element);
            log.info("Finish method: " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            throw new EntityNotFoundException("The value passed is empty");
        }
    }

    @Override
    public ResponseEntity<?> deleteElement(int idElement) {
        log.info("Start" + getCurrentClassName() + "get into: " + getCurrentMethodName());
        User user = userRepository.findById(idElement).orElseThrow(() -> new EntityNotFoundException("user not found with ID:" + idElement));
        if (!Utils.isNull(user)) {
            user.setDeleteFlag(true);
            userRepository.save(user);
            log.info("Start" + getCurrentClassName() + "get into: " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return null;
    }


    @Override
    public ResponseEntity<?> getByEmail(String email) {
        if (!Utils.isEmpty(email)) {
            log.info("Start" + getCurrentClassName() + "get into: " + getCurrentMethodName());
            User user = userRepository.findByEmail(email);
            if (!Utils.isNull(user) && !user.isDeleteFlag()) {
                return ResponseEntity.ok(user);
            } else {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("This account have been deleted from the database");

            }
        }else {
            throw new EntityNotFoundException("User not found with email: " + email);
        }

    }
}
