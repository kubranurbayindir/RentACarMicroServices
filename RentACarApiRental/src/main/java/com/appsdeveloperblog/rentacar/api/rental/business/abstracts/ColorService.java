package com.appsdeveloperblog.rentacar.api.rental.business.abstracts;

import java.util.List;

import com.appsdeveloperblog.rentacar.api.rental.business.dtos.carDto.DeleteCarDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.ColorSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.CreateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.DeleteColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.UpdateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.entities.Color;

public interface ColorService {
	
	Result add(CreateColorDto createColorDto);
	Result update(UpdateColorDto updateColorDto);
	Result delete(DeleteColorDto deleteColorDto);
	DataResult<ColorSearchListDto> getById(int id);
	DataResult<List<ColorSearchListDto>> getAll();

}
