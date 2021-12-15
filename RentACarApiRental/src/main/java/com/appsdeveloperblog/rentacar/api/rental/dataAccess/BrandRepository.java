package com.appsdeveloperblog.rentacar.api.rental.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.appsdeveloperblog.rentacar.api.rental.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
	

}
