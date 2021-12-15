package com.appsdeveloperblog.rentacar.users.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.rentacar.users.entities.IndividualCustomer;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, Integer>{

}
