package com.appsdeveloperblog.rentacar.users.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsdeveloperblog.rentacar.users.entities.CorporateCustomer;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer,Integer> {

}
