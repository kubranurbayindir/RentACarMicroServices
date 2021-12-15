package com.appsdeveloperblog.rentacar.api.rental.business.abstracts;

import java.util.List;

import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CarSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CreateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.DeleteCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.UpdateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.entities.Car;

public interface CarService {
	
	Result add(CreateCarDto createCarDto);
	Result update(UpdateCarDto updateCarDto);
	Result delete(DeleteCarDto deleteCarDto);
	DataResult<CarSearchListDto> getById(int id);
	DataResult<List<CarSearchListDto>> getAll();

}
