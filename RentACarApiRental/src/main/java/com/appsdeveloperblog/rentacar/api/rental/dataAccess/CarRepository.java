package com.appsdeveloperblog.rentacar.api.rental.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.appsdeveloperblog.rentacar.api.rental.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
