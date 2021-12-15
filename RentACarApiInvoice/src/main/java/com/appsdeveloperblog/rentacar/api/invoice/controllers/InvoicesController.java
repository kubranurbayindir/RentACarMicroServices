package com.appsdeveloperblog.rentacar.api.invoice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoicesController {

    @GetMapping("/status")
    public String check(){
        return "invoice is workin";
    }
}
