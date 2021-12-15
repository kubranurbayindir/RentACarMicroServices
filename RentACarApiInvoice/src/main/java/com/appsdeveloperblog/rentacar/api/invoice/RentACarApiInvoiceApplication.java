package com.appsdeveloperblog.rentacar.api.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RentACarApiInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarApiInvoiceApplication.class, args);
    }

}
