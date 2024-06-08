package com.carSharing.service;

import org.springframework.http.ResponseEntity;

public interface iUser {

    ResponseEntity<?> getByEmail(String email);
}
