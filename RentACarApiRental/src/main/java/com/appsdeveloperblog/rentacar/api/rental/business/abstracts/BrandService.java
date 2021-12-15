package com.appsdeveloperblog.rentacar.api.rental.business.abstracts;

import java.util.List;

import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.BrandSearchListDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.CreateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.DeleteBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.business.dtos.brandDto.UpdateBrandDto;
import com.appsdeveloperblog.rentacar.api.rental.core.results.DataResult;
import com.appsdeveloperblog.rentacar.api.rental.core.results.Result;

public interface BrandService {
	
	Result add(CreateBrandDto createBrandDto);
	Result update(UpdateBrandDto updateBrandDto);
	Result delete(DeleteBrandDto deleteBrandDto);
	DataResult<BrandSearchListDto> getById(int id);
	DataResult<List<BrandSearchListDto>> getAll();

}
