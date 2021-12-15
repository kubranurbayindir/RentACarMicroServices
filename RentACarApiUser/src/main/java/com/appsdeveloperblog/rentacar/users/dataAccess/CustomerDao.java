package com.appsdeveloperblog.rentacar.users.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.rentacar.users.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
