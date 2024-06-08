package com.carSharing.controller;


import com.carSharing.entity.BillingPayments;
import com.carSharing.entity.Car;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class CarController {

    @Autowired
    private final CrudOperation<Car> crudOperation;



}
