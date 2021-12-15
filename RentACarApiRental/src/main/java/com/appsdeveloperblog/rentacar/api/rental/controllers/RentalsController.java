package com.appsdeveloperblog.rentacar.api.rental.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentals")
public class RentalsController {

    @GetMapping("/status")
    public String check(){
        return "rental is workin";
    }
}
