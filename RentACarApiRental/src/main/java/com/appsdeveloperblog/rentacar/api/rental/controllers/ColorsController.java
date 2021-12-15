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

import com.appsdeveloperblog.rentacar.api.rental.business.abstracts.ColorService;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.ColorSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.CreateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.DeleteColorDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.colorDto.UpdateColorDto;
import com.appsdeveloperblog.rentacar.api.rental.core.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.models.colorModels.CreateColorRequestModel;
import com.appsdeveloperblog.rentacar.api.rental.models.colorModels.DeleteColorRequestModel;
import com.appsdeveloperblog.rentacar.api.rental.models.colorModels.UpdateColorRequestModel;

@RestController
@RequestMapping("/colors")
public class ColorsController {
	
	private ColorService colorService;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorsController(ColorService colorService, ModelMapperService modelMapperService) {
		super();
		this.colorService = colorService;
		this.modelMapperService = modelMapperService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateColorRequestModel createColorRequestModel) {
		CreateColorDto createColorDto = modelMapperService.forRequest().map(createColorRequestModel, CreateColorDto.class);
		return this.colorService.add(createColorDto);
		
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateColorRequestModel updateColorRequestModel) {
		UpdateColorDto updateColorDto = modelMapperService.forRequest().map(updateColorRequestModel, UpdateColorDto.class);
		return this.colorService.update(updateColorDto);
		
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteColorRequestModel deleteColorRequestModel) {
		DeleteColorDto deleteColorDto = modelMapperService.forRequest().map(deleteColorRequestModel, DeleteColorDto.class);
		return this.colorService.delete(deleteColorDto);
		
	}
	
	@GetMapping("/getById")
	public DataResult<ColorSearchListDto> getById(int id){
		return this.colorService.getById(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<ColorSearchListDto>> getAll(){
		return this.colorService.getAll();
	}
	
	

}
