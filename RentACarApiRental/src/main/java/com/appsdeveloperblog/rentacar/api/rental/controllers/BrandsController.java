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

import com.appsdeveloperblog.rentacar.api.rental.business.abstracts.BrandService;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.BrandSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.CreateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.DeleteBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.UpdateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.core.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.models.brandModels.CreateBrandRequestModel;
import com.appsdeveloperblog.rentacar.api.rental.models.brandModels.DeleteBrandRequestModel;
import com.appsdeveloperblog.rentacar.api.rental.models.brandModels.UpdateBrandRequestModel;

@RestController
@RequestMapping("/brands")
public class BrandsController {

	private BrandService brandService;
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandsController(BrandService brandService, ModelMapperService modelMapperService) {
		super();
		this.brandService = brandService;
		this.modelMapperService = modelMapperService;
	}

	@PostMapping("/add" )
	public Result add(@RequestBody @Valid CreateBrandRequestModel createBrandRequestModel) {

		CreateBrandDto createBrandDto = modelMapperService
				.forRequest()
				.map(createBrandRequestModel,
				CreateBrandDto.class);
		return this.brandService.add(createBrandDto);

	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateBrandRequestModel updateBrandRequestModel) {

		UpdateBrandDto updateBrandDto = modelMapperService
				.forRequest()
				.map(updateBrandRequestModel,UpdateBrandDto.class);
		return this.brandService.update(updateBrandDto);

	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteBrandRequestModel deleteBrandRequestModel) {

		DeleteBrandDto deleteBrandDto = modelMapperService
				.forRequest()
				.map(deleteBrandRequestModel,DeleteBrandDto.class);
		return this.brandService.delete(deleteBrandDto);
	}
	
	@GetMapping("/getById")
	public DataResult<BrandSearchListDto> getById(int id){
		return this.brandService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<BrandSearchListDto>> getAll(){
		return this.brandService.getAll();
	}

}
