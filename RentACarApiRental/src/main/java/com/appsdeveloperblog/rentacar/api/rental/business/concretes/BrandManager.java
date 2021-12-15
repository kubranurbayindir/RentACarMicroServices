package com.appsdeveloperblog.rentacar.api.rental.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.rentacar.api.rental.business.abstracts.BrandService;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.BrandSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.CreateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.DeleteBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.UpdateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.core.mapping.ModelMapperService;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;
import com.appsdeveloperblog.rentacar.api.rental.core.results.SuccessDataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.SuccessResult;
import com.appsdeveloperblog.rentacar.api.rental.dataAccess.BrandRepository;
import com.appsdeveloperblog.rentacar.api.rental.entities.Brand;

@Service
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
		super();
		this.brandRepository = brandRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateBrandDto createBrandDto) {
		Brand brand = modelMapperService.forRequest().map(createBrandDto, Brand.class);
		this.brandRepository.save(brand);
		return new SuccessResult("Marka eklendi.");
	}

	@Override
	public Result update(UpdateBrandDto updateBrandDto) {
		Brand brand = modelMapperService.forRequest().map(updateBrandDto, Brand.class);
		this.brandRepository.save(brand);
		return new SuccessResult("Marka güncellendi.");
	}

	@Override
	public Result delete(DeleteBrandDto deleteBrandDto) {
		Brand brand = modelMapperService.forRequest().map(deleteBrandDto, Brand.class);
		this.brandRepository.delete(brand);
		return new SuccessResult("Marka silindi.");
	}

	@Override
	public DataResult<BrandSearchListDto> getById(int id) {
		Brand tempBrand = this.brandRepository.getById(id);
		BrandSearchListDto brandSearchListDto = modelMapperService.forDto().map(tempBrand, BrandSearchListDto.class);
		return new SuccessDataResult<BrandSearchListDto>(brandSearchListDto);
	}

	@Override
	public DataResult<List<BrandSearchListDto>> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		List<BrandSearchListDto> brandSearchListDtos = brands.stream()
				.map(brand->modelMapperService.forDto()
						.map(brand, BrandSearchListDto.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<BrandSearchListDto>>(brandSearchListDtos, "Markalar Listelendi.");
	}



}
