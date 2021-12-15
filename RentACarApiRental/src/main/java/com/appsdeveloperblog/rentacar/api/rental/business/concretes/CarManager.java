package com.appsdeveloperblog.rentacar.api.rental.business.concretes;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentacar.api.rental.business.abstracts.CarService;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.BrandSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CarSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CreateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.DeleteCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.UpdateCarDto;
import com.appsdeveloperblog.rentacar.api.rental.core.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.core.results.SuccessDataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.SuccessResult;
import com.appsdeveloperblog.rentacar.api.rental.dataAccess.CarRepository;
import com.appsdeveloperblog.rentacar.api.rental.entities.Car;

@Service
public class CarManager implements CarService {
	
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarRepository carRepository, ModelMapperService modelMapperService) {
		super();
		this.carRepository = carRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCarDto createCarDto) {
		Car car = modelMapperService.forRequest().map(createCarDto, Car.class);
		this.carRepository.save(car);
		return new SuccessResult("Araç bilgisi eklendi.");
	}

	@Override
	public Result update(UpdateCarDto updateCarDto) {
		Car car = modelMapperService.forRequest().map(updateCarDto, Car.class);
		this.carRepository.save(car);
		return new SuccessResult("Araç bilgisi güncellendi.");
	}

	@Override
	public Result delete(DeleteCarDto deleteCarDto) {
		Car car = modelMapperService.forRequest().map(deleteCarDto, Car.class);
		this.carRepository.delete(car);
		return new SuccessResult("Araç bilgisi silindi.");
	}

	@Override
	public DataResult<CarSearchListDto> getById(int id) {
		var car = this.carRepository.getById(id);
		CarSearchListDto tempCar = modelMapperService.forDto().map(car, CarSearchListDto.class);
		return new SuccessDataResult<CarSearchListDto>(tempCar);
	}

	@Override
	public DataResult<List<CarSearchListDto>> getAll() {
		List<Car> tempCars = this.carRepository.findAll();
		List<CarSearchListDto> carSearchListDtos = tempCars
				.stream().map(car->modelMapperService.forDto()
						.map(car, CarSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<CarSearchListDto>>(carSearchListDtos);
	}





}
