package com.carSharing.controller;


import com.carSharing.entity.Car;
import com.carSharing.entity.Tariff;
import com.carSharing.service.CrudOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class TariffController {

    @Autowired
    private final CrudOperation<Tariff> crudOperation;



}
