package com.carSharing.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class UserController {


    @GetMapping("user")
    public String getUser(){
        return "USERRR";
    }

}