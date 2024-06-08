package com.carSharing.service;

import org.springframework.http.ResponseEntity;

/**
 * This class has the rule of generic CrudOperation for the several entities
 * @param <T>
 */
public interface CrudOperation <T>{

    ResponseEntity<?> addElement(T element);

    ResponseEntity<?> deleteElement(int idElement);





}
