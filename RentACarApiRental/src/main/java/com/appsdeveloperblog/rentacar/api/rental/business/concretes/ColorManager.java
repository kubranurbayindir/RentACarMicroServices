package com.appsdeveloperblog.rentacar.api.rental.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentacar.api.rental.business.abstracts.ColorService;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.BrandSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.CarSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.ColorSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.CreateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.DeleteColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.UpdateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.core.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.core.results.SuccessDataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.SuccessResult;
import com.appsdeveloperblog.rentacar.api.rental.dataAccess.ColorRepository;
import com.appsdeveloperblog.rentacar.api.rental.entities.Brand;
import com.appsdeveloperblog.rentacar.api.rental.entities.Car;
import com.appsdeveloperblog.rentacar.api.rental.entities.Color;

@Service
public class ColorManager implements ColorService {
	
	private ColorRepository colorRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorRepository colorRepository, ModelMapperService modelMapperService) {
		super();
		this.colorRepository = colorRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateColorDto createColorDto) {
		Color color = modelMapperService.forRequest().map(createColorDto, Color.class);
		this.colorRepository.save(color);
		return new SuccessResult("Renk bilgisi eklendi.");
	}

	@Override
	public Result update(UpdateColorDto updateColorDto) {
		Color color = modelMapperService.forRequest().map(updateColorDto, Color.class);
		this.colorRepository.save(color);
		return new SuccessResult("Renk bilgisi güncellendi.");
	}

	@Override
	public Result delete(DeleteColorDto deleteColorDto) {
		Color color = modelMapperService.forRequest().map(deleteColorDto, Color.class);
		this.colorRepository.delete(color);
		return new SuccessResult("Renk bilgisi silindi.");
	}

	@Override
	public DataResult<ColorSearchListDto> getById(int id) {
		var tempColor = this.colorRepository.getById(id);
		ColorSearchListDto colorSearchListDto = modelMapperService.forDto().map(tempColor, ColorSearchListDto.class);
		return new SuccessDataResult<ColorSearchListDto>(colorSearchListDto);
	}

	@Override
	public DataResult<List<ColorSearchListDto>> getAll() {
		List<Color> tempColor = this.colorRepository.findAll();
		List<ColorSearchListDto> colorSearchListDtos = tempColor.stream()
				.map(color->modelMapperService.forDto()
				.map(color, ColorSearchListDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ColorSearchListDto>>(colorSearchListDtos);

	}


}
