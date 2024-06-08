package com.carSharing.controller;


import com.carSharing.entity.User;
import com.carSharing.generic.MethodClass;
import com.carSharing.service.CrudOperation;
import com.carSharing.service.iUser;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
@Slf4j
public class UserController extends MethodClass {

    @Autowired
    private final CrudOperation<User> crudOperation;
    @Autowired
    private final iUser iUser;


    @PostMapping("/addUser")
    ResponseEntity<?> addUser(@RequestBody User user) {
        log.info("get into " + getCurrentClassName() + "start method " + getCurrentMethodName());
        try {
            crudOperation.addElement(user);
            log.info("Finish method " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteUser(@RequestParam Integer idUser) {
        log.info("get into " + getCurrentClassName() + "start method " + getCurrentMethodName());
        try {
            crudOperation.deleteElement(idUser);
            log.info("finish method " + getCurrentMethodName());
            return ResponseEntity.ok(HttpStatus.OK+"\n User deleted correctly");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/getProfile")
    ResponseEntity<?> getProfileUser(@RequestParam String email) {
        log.info("get into " + getCurrentClassName() + "start method " + getCurrentMethodName());
        try {
            log.info("finish method " + getCurrentMethodName());
            return ResponseEntity.ok(iUser.getByEmail(email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
