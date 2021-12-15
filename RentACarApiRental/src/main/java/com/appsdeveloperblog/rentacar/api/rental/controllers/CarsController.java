package com.appsdeveloperblog.rentacar.api.rental.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.rentacar.api.rental.business.abstracts.CarService;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.BrandSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.CreateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.DeleteBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.UpdateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CreateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.DeleteCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CarSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.UpdateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.core.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.models.carModels.CreateCarRequestModel;
import com.appsdeveloperblog.rentacar.api.rental.models.carModels.DeleteCarRequestModel;
import com.appsdeveloperblog.rentacar.api.rental.models.carModels.UpdateCarRequestModel;

@RestController
@RequestMapping("/cars")
public class CarsController {
	
	private CarService carService;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarsController(CarService carService, ModelMapperService modelMapperService) {
		super();
		this.carService = carService;
		this.modelMapperService = modelMapperService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateCarRequestModel createCarRequestModel) {

		CreateCarDto createCarDto = modelMapperService
				.forRequest()
				.map(createCarRequestModel,
				CreateCarDto.class);
		return this.carService.add(createCarDto);

	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateCarRequestModel updateCarRequestModel) {

		UpdateCarDto updateCarDto = modelMapperService
				.forRequest()
				.map(updateCarRequestModel,UpdateCarDto.class);
		return this.carService.update(updateCarDto);

	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteCarRequestModel deleteCarRequestModel) {

		DeleteCarDto deleteCarDto = modelMapperService
				.forRequest()
				.map(deleteCarRequestModel,DeleteCarDto.class);
		return this.carService.delete(deleteCarDto);
	}
	
	@GetMapping("/getById")
	public DataResult<CarSearchListDto> getById(int id){
		return this.carService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CarSearchListDto>> getAll(){
		return this.carService.getAll();
	}

}
